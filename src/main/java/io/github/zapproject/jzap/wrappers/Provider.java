package io.github.zapproject.jzap;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import org.web3j.protocol.core.methods.response.TransactionReceipt;


public class Provider {
    public String providerOwner;
    public Dispatch dispatch;
    public Bondage bondage;
    public Arbiter arbiter;
    public Registry registry;
    public HashMap<byte[], CurveType> curves;
    public BigInteger pubKey;
    public byte[] title;

    public Provider(NetworkProviderOptions options) throws Exception {
        assert !options.credentials.getAddress().isBlank() : "Owner address is required";

        this.providerOwner = options.credentials.getAddress();
        this.dispatch = Dispatch.load(options);
        this.bondage = Bondage.load(options);
        this.arbiter = Arbiter.load(options);
        this.registry = Registry.load(options);
        this.curves = new HashMap<byte[], CurveType>();
    }

    public TransactionReceipt initiateProvider(InitProvider init) throws Exception {
        return registry.initiateProvider(init.publicKey, init.title).send();
    }
    
    public TransactionReceipt initiateProviderCurve(InitCurve init) throws Exception {
        return registry.initiateProviderCurve(init.endpoint, init.term, init.broker).send();
    }

    public TransactionReceipt setEndpointParams(EndpointParams params) throws Exception {
        return registry.setEndpointParams(params.endpoint, params.endpointParams).send();
    }

    public TransactionReceipt clearEndpoint(EndpointMethods method) throws Exception {
        return registry.clearEndpoint(method.endpoint).send();
    }

    /* GETTERS */
    public byte[] getTitle() throws Exception {
        if (title == null)
            title = registry.getTitle(providerOwner).send();
        return title;
    }

    public boolean isProviderInitialized() throws Exception {
        return registry.isProviderInitiated(providerOwner).send();
    }

    public boolean isEndpointCreated(byte[] endpoint) throws Exception {
        return !registry.getEndpointBroker(providerOwner, endpoint).send().isEmpty();
    }

    public BigInteger getPubKey() throws Exception {
        if (pubKey == null)
            pubKey = registry.getPublicKey(providerOwner).send();
        return pubKey;
    } 

    public CurveType getCurve(byte[] endpoint) throws Exception {
        CurveType curve = new CurveType();
        curve.curve = registry.getProviderCurve(providerOwner, endpoint).send();
        curves.put(endpoint, curve);
        return curve;
    }

    public byte[] getProviderParam(byte[] key) throws Exception {
        return registry.getProviderParameter(providerOwner, key).send();
    }

    public List<byte[]> getAllProviderParams() throws Exception {
        return registry.getAllProviderParams(providerOwner).send();
    }

    public String getEndpointBroker(byte[] endpoint) throws Exception {
        return registry.getEndpointBroker(providerOwner, endpoint).send();
    }

    public List<byte[]> getEndpointParams(byte[] endpoint) throws Exception {
        return registry.getEndpointParams(providerOwner, endpoint).send();
    }

    public List<byte[]> getEndpoints() throws Exception {
        return registry.getProviderEndpoints(providerOwner).send();
    }

    /* BONDAGE */
    public BigInteger getBoundDots(byte[] endpoint, String subscriber) throws Exception {
        assert endpoint.length > 0 : "Endpoint required";
        assert !subscriber.isBlank() : "Subscriber required";
        return bondage.getBoundDots(subscriber, providerOwner, endpoint).send();
    }

    public BigInteger getDotsIssued(byte[] endpoint) throws Exception {
        assert endpoint.length > 0 : "Endpoint required";
        return bondage.getDotsIssued(providerOwner, endpoint).send();
    }

    public BigInteger getDotsLimit(byte[] endpoint) throws Exception {
        return bondage.dotLimit(providerOwner, endpoint).send();
    }

    public BigInteger getZapRequired(byte[] endpoint, BigInteger dots) throws Exception {
        return bondage.calcZapForDots(providerOwner, endpoint, dots).send();
    }

    public BigInteger getNumEscrow(BondageArgs args) throws Exception {
        return bondage.getNumEscrow(args.subscriber, args.provider, args.endpoint).send();
    }

    /* DISPATCH */
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
    public List<Arbiter.DataPurchaseEventResponse> listenSubscribes(TransactionReceipt txReceipt) {
        return arbiter.getDataPurchaseEvents(txReceipt);
    }

    public List<Arbiter.DataSubscriptionEndEventResponse> listenUnsubscribes(TransactionReceipt txReceipt) {
        return arbiter.getDataSubscriptionEndEvents(txReceipt);
    }

    public List<Dispatch.IncomingEventResponse> listenQueries(TransactionReceipt txReceipt) {
        return dispatch.getIncomingEvents(txReceipt);
    }

    public List<Bondage.BoundEventResponse> listenBound(TransactionReceipt txReceipt) {
        return bondage.getBoundEvents(txReceipt);
    }

    public List<Bondage.UnboundEventResponse> listenUnbound(TransactionReceipt txReceipt) {
        return bondage.getUnboundEvents(txReceipt);
    }
}
