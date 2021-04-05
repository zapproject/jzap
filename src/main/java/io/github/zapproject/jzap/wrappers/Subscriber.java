package io.github.zapproject.jzap;

import io.github.zapproject.jzap.ApproveType;
import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.List;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.TransactionReceipt;


/**
 * Represents an offchain Subscriber and provider an interface to the appropriate smart contracts
 */
public class Subscriber {
    public String subscriberOwner;
    public Dispatch dispatch;
    public Bondage bondage;
    public Arbiter arbiter;
    public Registry registry;
    public ZapToken zapToken;

    /**
     * Constructor for Subscriber
     * @param options Wrapper class NetworkProviderOptions for {int networkID, org.web3j.protocol.Web3j web3j, org.web3j.crypto.Credentials credentials, org.web3j.tx.gas.ContractGasProvider contractGasProvider}
     */
    public Subscriber(NetworkProviderOptions options) throws Exception {
        assert !options.credentials.getAddress().isBlank() : "Owner address is required";
        this.subscriberOwner = options.credentials.getAddress();
        this.dispatch = Dispatch.load(options);
        this.bondage = Bondage.load(options);
        this.arbiter = Arbiter.load(options);
        this.registry = Registry.load(options);
        this.zapToken = ZapToken.load(options);
    }

    /**
     * Get the Zpa balance of the current Subscriber
     * @return Zap balance in wei
     */
    public BigInteger getZapBalance() throws Exception {
        return zapToken.balanceOf(subscriberOwner).send();
    }

    /**
     * Gets the Zap allowant of the current subscriber to Bondage
     * @return Zap allowance in wei
     */
    public BigInteger getZapAllowance() throws Exception {
        return zapToken.allowance(subscriberOwner, bondage.getContractAddress()).send();
    }

    /**
     * Approve number of Zap to a provider
     * @param   type Wrapper object which contains zapNum
     * @return  Log of transactions done in Bondage contract
     */
    public TransactionReceipt approveToBond(ApproveType type) throws Exception {
        return zapToken.approve(bondage.getContractAddress(), type.zapNum).send();
    }

    /**
     * Bonds zapNum amount of Zap to the given provider's endpoint, yielding dots that enable this subscriber to send queries
     * @param   type Wrapper object which contains the provider, endpoing, and dots
     * @return  Log of transactions done in this Bondage contract
     */
    public TransactionReceipt bond(BondType type) throws Exception {
        BigInteger approved = zapToken.allowance(subscriberOwner, bondage.getContractAddress()).send();
        BigInteger required = bondage.calcZapForDots(type.provider, type.endpoint, type.dots).send();
        BigInteger balance = this.getZapBalance();

        assert approved.intValue() >= required.intValue() : "You don't have enough ZAP approved";
        assert balance.intValue() >= required.intValue() : "Balance insufficent";

        return bondage.bond(type.provider, type.endpoint, type.dots).send();
    }

    /**
     * Delegate bonds zapNum amount of Zap to the given provider's endpoint, yielding dots that enable given subscriber to send queries.
     * @param   type    Wrapper object which contrains provider, endpoint, and dots
     * @return  Log of transactions done with the Bondage contract
     */
    public TransactionReceipt delegateBond(DelegateBondType type) throws Exception {
        BigInteger approved = zapToken.allowance(subscriberOwner, bondage.getContractAddress()).send();
        BigInteger required = bondage.calcZapForDots(type.provider, type.endpoint, type.dots).send();
        BigInteger balance = this.getZapBalance();

        assert approved.intValue() >= required.intValue() : "You don't have enough ZAP approved";
        assert balance.intValue() >= required.intValue() : "Balance insufficient";

        return bondage.delegateBond(type.subscriber, type.provider, type.endpoint, type.dots).send();
    }

    /**
     * Unbonds a given number of dots from a given oracle, returning Zap to this subscriber based on the bonding curve.
     * @param   type Wrapper object which contains provider, endpoint, and dots
     * @return  Log of transactions done with the Bondage contract
     */
    public TransactionReceipt unBond(UnbondType type) throws Exception {
        BigInteger boundDots = bondage.getBoundDots(subscriberOwner, type.provider, type.endpoint).send();

        assert boundDots.intValue() >= type.dots.intValue() : "Dots to unbond is less than requested";

        return bondage.unbond(type.provider, type.endpoint, type.dots).send();
    }

    /**
     * Initializes a temporal subscription to an oracle, defined in terms of # of blocks.
     * @param   type Wrapper object which contains the provider, endpoint, and dots
     * @return  Log of transactions done with the Arbiter contract
     */
    public TransactionReceipt subscribe(SubscribeType type) throws Exception {
        BigInteger providerPubKey = registry.getProviderPublicKey(type.provider).send();
        BigInteger required = bondage.calcZapForDots(type.provider, type.endpoint, type.dots).send();
        BigInteger balance = this.getZapBalance();

        assert balance.intValue() >= required.intValue() : "Insufficient balance, require " + required.intValue() + " ZAP for " + type.dots + " dots";
        
        BigInteger boundDots = bondage.getBoundDots(subscriberOwner, type.provider, type.endpoint).send();

        assert boundDots.intValue() >= type.dots.intValue() : "Insufficient bound dots, please bond " + type.dots.intValue() + " dots to subscribe";

        return arbiter.initiateSubscription(type.provider, type.endpoint, type.endpointParams, providerPubKey, type.dots).send();
    }

    /**
     * Queries data from a subscriber to a given provider's endpoint, passing in a query string and endpoint parameters that will be processed by the oracle
     * @param   args Wrapper object which contains the provider, query, endpoint, and endpoint params
     * @return  Log of transactions done with Dispatch contract
     */
    public TransactionReceipt queryData(QueryArgs args) throws Exception {
        BigInteger boundDots = bondage.getBoundDots(subscriberOwner, args.provider, args.endpoint).send();

        assert boundDots != null : "Insufficient balance of bound dots to query";

        return dispatch.query(args.provider, args.query, args.endpoint, args.endpointParams).send();
    }

    /**
     * Cancel a query
     * @param   queryId Query ID identifier
     * @return  Log of transactions done with Dispatch contract
     */
    public TransactionReceipt cancelQuery(BigInteger queryID) throws Exception {
        return dispatch.cancelQuery(queryID).send();
    }

    /* GETTERS */

    /**
     * Get number of dots escrow
     * @param   args Wrapper object which contains the provider and endpoint
     * @return  Number of escrow dots
     */
    public BigInteger getNumEscrow(BondageArgs args) throws Exception {
        return bondage.getNumEscrow(subscriberOwner, args.provider, args.endpoint).send();
    }

    /**
     * Gets the number of dots that are bounded to a provider's endpoint for the current subscriber
     * @param   args Wrapper object which contains the provider and endpoint
     * @return  Number of bound dots to this provider's endpoint
     */
    public BigInteger getBoundDots(BondageArgs args) throws Exception {
        return bondage.getBoundDots(subscriberOwner, args.provider, args.endpoint).send();
    }

    /**
     * Listens to all offchain responses events
     * @param   txReceipt Log of transactions done in Dispatch contract
     * @return  List of offchain response events
     */
    public List<Dispatch.OffchainResponseEventResponse> listenToOffchainResponse(TransactionReceipt txReceipt) {
        return dispatch.getOffchainResponseEvents(txReceipt);
    }

    /**
     * Listens to all offchain responses events
     * @param   DefaultBlockParameter   Start block to listening for events
     * @param   DefaultBlockParameter   End block to listening for events
     * @return  Flowable of a offchain response event
     */
    public Flowable<Dispatch.OffchainResponseEventResponse> listenToOffchainResponse(DefaultBlockParameter start, DefaultBlockParameter end) {
        return dispatch.offchainResponseEventFlowable(start, end);
    }

    /**
     * Checks the Zap balance of the subscriber and compares it to a given amount
     * @param   required    Number of Zap to check for
     * @return  Whether there is enough Zap
     */
    public boolean hasEnoughZap(BigInteger required) throws Exception {
        return zapToken.balanceOf(subscriberOwner).send().intValue() >= required.intValue();
    }
}