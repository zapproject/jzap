package io.github.zapproject.jzap;

import java.math.BigInteger;
import java.util.List;
import org.web3j.protocol.core.methods.response.TransactionReceipt;


public class Subscriber {
    public String subscriberOwner;
    public Dispatch dispatch;
    public Bondage bondage;
    public Arbiter arbiter;
    public Registry registry;
    public ZapToken zapToken;

    public Subscriber(NetworkProviderOptions options) throws Exception {
        assert !options.credentials.getAddress().isBlank() : "Owner address is required";
        this.subscriberOwner = options.credentials.getAddress();
        this.dispatch = Dispatch.load(options);
        this.bondage = Bondage.load(options);
        this.arbiter = Arbiter.load(options);
        this.registry = Registry.load(options);
        this.zapToken = ZapToken.load(options);
    }

    public BigInteger getZapBalance() throws Exception {
        return zapToken.balanceOf(subscriberOwner).send();
    }

    public BigInteger getZapAllowance() throws Exception {
        return zapToken.allowance(subscriberOwner, bondage.getContractAddress()).send();
    }

    public TransactionReceipt approveToBond(ApproveType type) throws Exception {
        return zapToken.approve(bondage.getContractAddress(), type.zapNum).send();
    }

    public TransactionReceipt bond(BondType type) throws Exception {
        BigInteger approved = zapToken.allowance(subscriberOwner, bondage.getContractAddress()).send();
        BigInteger required = bondage.calcZapForDots(type.provider, type.endpoint, type.dots).send();
        BigInteger balance = this.getZapBalance();

        assert approved.intValue() >= required.intValue() : "You don't have enough ZAP approved";
        assert balance.intValue() >= required.intValue() : "Balance insufficent";

        return bondage.bond(type.provider, type.endpoint, type.dots).send();
    }

    public TransactionReceipt delegateBond(DelegateBondType type) throws Exception {
        BigInteger approved = zapToken.allowance(subscriberOwner, bondage.getContractAddress()).send();
        BigInteger required = bondage.calcZapForDots(type.provider, type.endpoint, type.dots).send();
        BigInteger balance = this.getZapBalance();

        assert approved.intValue() >= required.intValue() : "You don't have enough ZAP approved";
        assert balance.intValue() >= required.intValue() : "Balance insufficient";

        return bondage.delegateBond(type.subscriber, type.provider, type.endpoint, type.dots).send();
    }

    public TransactionReceipt unBond(UnbondType type) throws Exception {
        BigInteger boundDots = bondage.getBoundDots(subscriberOwner, type.provider, type.endpoint).send();

        assert boundDots.intValue() >= type.dots.intValue() : "Dots to unbond is less than requested";

        return bondage.unbond(type.provider, type.endpoint, type.dots).send();
    }

    public TransactionReceipt subscribe(SubscribeType type) throws Exception {
        BigInteger providerPubKey = registry.getProviderPublicKey(type.provider).send();
        BigInteger required = bondage.calcZapForDots(type.provider, type.endpoint, type.dots).send();
        BigInteger balance = this.getZapBalance();

        assert balance.intValue() >= required.intValue() : "Insufficient balance, require " + required.intValue() + " ZAP for " + type.dots + " dots";
        
        BigInteger boundDots = bondage.getBoundDots(subscriberOwner, type.provider, type.endpoint).send();

        assert boundDots.intValue() >= type.dots.intValue() : "Insufficient bound dots, please bond " + type.dots.intValue() + " dots to subscribe";

        return arbiter.initiateSubscription(type.provider, type.endpoint, type.endpointParams, providerPubKey, type.dots).send();
    }

    public TransactionReceipt queryData(QueryArgs args) throws Exception {
        BigInteger boundDots = bondage.getBoundDots(subscriberOwner, args.provider, args.endpoint).send();

        assert boundDots != null : "Insufficient balance of bound dots to query";

        return dispatch.query(args.provider, args.query, args.endpoint, args.endpointParams).send();
    }

    public TransactionReceipt cancelQuery(BigInteger queryID) throws Exception {
        return dispatch.cancelQuery(queryID).send();
    }

    /* GETTERS */

    public BigInteger getNumEscrow(BondageArgs args) throws Exception {
        return bondage.getNumEscrow(subscriberOwner, args.provider, args.endpoint).send();
    }

    public BigInteger getBoundDots(BondageArgs args) throws Exception {
        return bondage.getBoundDots(subscriberOwner, args.provider, args.endpoint).send();
    }

    public List<Dispatch.OffchainResponseEventResponse> listenToOffchainResponse(TransactionReceipt txReceipt) {
        return dispatch.getOffchainResponseEvents(txReceipt);
    }

    public boolean hasEnoughZap(BigInteger required) throws Exception {
        return zapToken.balanceOf(subscriberOwner).send().intValue() >= required.intValue();
    }
}