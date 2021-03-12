package io.github.zapproject.jzap;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import org.web3j.protocol.core.methods.response.TransactionReceipt;


/**
 * Represents a Zap provider and provides an interface to the appropiate smart contracts
 */
public class Provider {
    public String providerOwner;
    public Dispatch dispatch;
    public Bondage bondage;
    public Arbiter arbiter;
    public Registry registry;
    public HashMap<byte[], CurveType> curves;
    public BigInteger pubKey;
    public byte[] title;

    /**
     * Initializes the zap provider
     * @param options wrapper class NetworkProviderOptions for {int networkID, org.web3j.protocol.Web3j web3j, org.web3j.crypto.Credentials credentials, org.web3j.tx.gas.ContractGasProvider contractGasProvider}
     */
    public Provider(NetworkProviderOptions options) throws Exception {
        assert !options.credentials.getAddress().isBlank() : "Owner address is required";

        this.providerOwner = options.credentials.getAddress();
        this.dispatch = Dispatch.load(options);
        this.bondage = Bondage.load(options);
        this.arbiter = Arbiter.load(options);
        this.registry = Registry.load(options);
        this.curves = new HashMap<byte[], CurveType>();
    }

    /**
     * Calls the registry contract to initialize a new provider endpoint.&nbspThis needs to be called for each endpoint.
     * @param   init    Wrapper class which contains the public key and title for the provider endpoint
     * @return  A remote function call to Registry contract which returns the transaction receipt
     */
    public TransactionReceipt initiateProvider(InitProvider init) throws Exception {
        return registry.initiateProvider(init.publicKey, init.title).send();
    }
    
    /**
     * Call the registry contract to initialize a new curve for a given endpoint.
     * @param   init    Wrapper class which contains the endpoint, curve, and broker for the endpoint curve
     * @return  A remote function call to Registry contract which returns the transaction receipt
     */
    public TransactionReceipt initiateProviderCurve(InitCurve init) throws Exception {
        return registry.initiateProviderCurve(init.endpoint, init.term, init.broker).send();
    }

    /**
     * Set the parameter of a provider
     * @param   params  Wrapper class which contains the key and value of new params for provider
     * @return  A remote function call to Registry contract which returns the transaction receipt
     */
    public TransactionReceipt setProviderParameter(SetProviderParams params) throws Exception {
        return registry.setProviderParameter(params.key, params.value).send();
    }

    /**
     * Set the title of a provider
     * @param   title   The new title for a provider
     * @return  A remote function call to Registry contract which return the transaction receipt
     */
    public TransactionReceipt setTitle(SetProviderTitle title) throws Exception {
        return registry.setProviderTitle(title.title).send();
    }

    /**
     * Set params for an endpoint
     * @param   params  Wrapper class which contains the endpoint and endpoint params
     * @return  A remote function call to Registry contract which returns the transaction receipt
     */
    public TransactionReceipt setEndpointParams(EndpointParams params) throws Exception {
        return registry.setEndpointParams(params.endpoint, params.endpointParams).send();
    }

    /**
     * Clears the pass endpoint for a provider
     * @param   method  Wrapper class which contains the endpoint of a provider
     * @return  A remote function call to Registry contract which returns the transaction receipt
     */
    public TransactionReceipt clearEndpoint(EndpointMethods method) throws Exception {
        return registry.clearEndpoint(method.endpoint).send();
    }

    /* GETTERS */

    /**
     * Gets the title fo this provider from the Registry contract
     * @return The title of this provider in byte[32]
     */
    public byte[] getTitle() throws Exception {
        if (title == null)
            title = registry.getTitle(providerOwner).send();
        return title;
    }

    /**
     * Gets whether this provider has already been created
     * @return Whether this provider has been created
     */
    public boolean isProviderInitialized() throws Exception {
        return registry.isProviderInitiated(providerOwner).send();
    }

    /**
     * Gets whether this endpoint and its corresponding curve have already been set
     * @param   endpoint    Data endpoint for this provider
     * @return  Whether this endpoint has been created for this provider
     */
    public boolean isEndpointCreated(byte[] endpoint) throws Exception {
        return !registry.getEndpointBroker(providerOwner, endpoint).send().isEmpty();
    }

    /**
     * Gets the public key of this provider from the Registry contract
     * @return The public key of this provider
     */
    public BigInteger getPubKey() throws Exception {
        if (pubKey == null)
            pubKey = registry.getPublicKey(providerOwner).send();
        return pubKey;
    } 

    /**
     * Gets the curve of a defined endpoint from the Registry contract
     * @param   Data endpoint of this provider
     * @return  The curve of this endpoint
     */
    @SuppressWarnings("unchecked")
    public CurveType getCurve(byte[] endpoint) throws Exception {
        CurveType curve = new CurveType();
        curve.curve = registry.getProviderCurve(providerOwner, endpoint).send();
        curves.put(endpoint, curve);
        return curve;
    }

    /**
     * Get a parameter from a provider
     * @param   key The key for this provider
     * @return  Value of the params for this provider in byte[32]
     */
    public byte[] getProviderParam(byte[] key) throws Exception {
        return registry.getProviderParameter(providerOwner, key).send();
    }

    /**
     * Get all the parameters of a provider
     * @return List of params belonging to this provider
     */
    @SuppressWarnings("unchecked")
    public List<byte[]> getAllProviderParams() throws Exception {
        return registry.getAllProviderParams(providerOwner).send();
    }

    /**
     * Get the broker address of this endpoint
     * @param   endpoint    Data endpoint of this provider
     * @return  The broker for this endpoint
     */
    public String getEndpointBroker(byte[] endpoint) throws Exception {
        return registry.getEndpointBroker(providerOwner, endpoint).send();
    }

    /**
     * Get the endpoint params at a certain index of a provider's endpoint
     * @param   endpoint    Data endpoint of a provider
     * @return  Endpoint params at this index
     */
    @SuppressWarnings("unchecked")
    public List<byte[]> getEndpointParams(byte[] endpoint) throws Exception {
        return registry.getEndpointParams(providerOwner, endpoint).send();
    }

    /**
     * Get the endpoints fo a given provider
     * @return List of endpoints belonging to this provider
     */
    @SuppressWarnings("unchecked")
    public List<byte[]> getEndpoints() throws Exception {
        return registry.getProviderEndpoints(providerOwner).send();
    }

    /* BONDAGE */

    /**
     * Gets the total amount of Zap bound to a given endpoint
     * @param   endpoint    Data endpoint of this provider
     * @return  Amount of bound Zap (wei)
     */
    public BigInteger getZapBound(byte[] endpoint) throws Exception {
        return bondage.getZapBound(providerOwner, endpoint).send();
    }
    
    /**
     * Get the total amount of dots bound by a user
     * @param   endpoint    Data endpoint of the provider
     * @param   subscriber  Address of the subscriber
     * @return  Amount of dots for this subscriber
     */
    public BigInteger getBoundDots(byte[] endpoint, String subscriber) throws Exception {
        assert endpoint.length > 0 : "Endpoint required";
        assert !subscriber.isBlank() : "Subscriber required";
        return bondage.getBoundDots(subscriber, providerOwner, endpoint).send();
    }

    /**
     * Gets the total amount of dots issued
     * @param   endpoint    Data endpoint of this provider
     * @return  Amount of dots
     */
    public BigInteger getDotsIssued(byte[] endpoint) throws Exception {
        assert endpoint.length > 0 : "Endpoint required";
        return bondage.getDotsIssued(providerOwner, endpoint).send();
    }

    /**
     * Get maximum dots an endpoint can issue
     * @param   endpoint    Data endpoint of this provider
     * @return  Maximum dots can be bound to this endpoint
     */
    public BigInteger getDotsLimit(byte[] endpoint) throws Exception {
        return bondage.dotLimit(providerOwner, endpoint).send();
    }

    /**
     * Gets the total amount of Zap required to bond x dots
     * @param   endpoint    Data endpoint of this provider
     * @param   dots        Number of dots
     * @return  Amount of required Zap (wei)
     */
    public BigInteger getZapRequired(byte[] endpoint, BigInteger dots) throws Exception {
        return bondage.calcZapForDots(providerOwner, endpoint, dots).send();
    }

    /**
     * Get number of dots escrow
     * @param   args    Wrapper object which contains subscriber, provider, and endpoint
     * @return  Number of escrow dots
     */
    public BigInteger getNumEscrow(BondageArgs args) throws Exception {
        return bondage.getNumEscrow(args.subscriber, args.provider, args.endpoint).send();
    }

    /* DISPATCH */

    /**
     * Responds to a specific query from the subscriber
     * @param   args    Wrapper object which contains queryID and response params
     * @return  A remote function call to Dispatch contract which returns the transaction receipt
     */
    public TransactionReceipt respond(ResponseArgs args) throws Exception {
        switch(args.responseParams.size()) {
            case 1: 
                return dispatch.respond(args.queryID, args.responseParams.get(0)).send();
            case 2: 
                return dispatch.respond(args.queryID, args.responseParams.get(0), args.responseParams.get(1)).send();
            case 3: 
                return dispatch.respond(args.queryID, args.responseParams.get(0), args.responseParams.get(1), args.responseParams.get(2)).send();
            case 4: 
                return dispatch.respond(args.queryID, args.responseParams.get(0), args.responseParams.get(1), args.responseParams.get(2), args.responseParams.get(3)).send();
            default:
                throw new Exception("Invalid number of response parameters");
        }
    }

    /* EVENTS */

    /**
     * Listen for start subscription events from the Arbiter contract
     * @param   txReceipt   Log of transactions done on this contract
     * @return  List of data purchase events
     */
    public List<Arbiter.DataPurchaseEventResponse> listenSubscribes(TransactionReceipt txReceipt) {
        return arbiter.getDataPurchaseEvents(txReceipt);
    }

    /**
     * Listen to unscription events emmited by the Arbiter contract
     * @param   txReceipt   Log of transactions done on this contract
     * @return  List of data subscription end events
     */
    public List<Arbiter.DataSubscriptionEndEventResponse> listenUnsubscribes(TransactionReceipt txReceipt) {
        return arbiter.getDataSubscriptionEndEvents(txReceipt);
    }

    /**
     * Listen to query events emitted by the Dispatch contract
     * @param   txReceipt   Log of transactions done on this contract
     * @return  List of incoming events
     */
    public List<Dispatch.IncomingEventResponse> listenQueries(TransactionReceipt txReceipt) {
        return dispatch.getIncomingEvents(txReceipt);
    }

    /**
     * Listens to bound bondage contract events
     * @param   txReceipt   Log of transactions done on this contract
     * @return  List of bound events
     */
    public List<Bondage.BoundEventResponse> listenBound(TransactionReceipt txReceipt) {
        return bondage.getBoundEvents(txReceipt);
    }

    /**
     * Listens to unbound contract events
     * @param   txReceipt   Log of transaction done on this contract
     * @return  List of unbound events
     */
    public List<Bondage.UnboundEventResponse> listenUnbound(TransactionReceipt txReceipt) {
        return bondage.getUnboundEvents(txReceipt);
    }
}
