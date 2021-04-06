package io.github.zapproject.jzap.wrappers;

import io.github.zapproject.jzap.types.BaseContractTypes.NetworkProviderOptions;
import io.github.zapproject.jzap.types.BondageTypes.BondageArgs;
import io.github.zapproject.jzap.types.DispatchTypes.ResponseArgs;
import io.github.zapproject.jzap.types.ProviderTypes.InitCurve;
import io.github.zapproject.jzap.types.ProviderTypes.InitProvider;
import io.github.zapproject.jzap.types.RegistryTypes.EndpointParams;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProviderIntegrationTest {
    static Provider provider;

    static Web3j web3j;
    static Credentials creds;
    static Credentials creds2;
    static ContractGasProvider gasPro;

    static byte[] title = new byte[32];
    static byte[] endpoint = new byte[32];
    static byte[] endpoint2 = new byte[32];
    static List<BigInteger> curve;
    static List<byte[]> params;

    TransactionReceipt txSub;
    TransactionReceipt txUnSub;
    TransactionReceipt txQueries;
    TransactionReceipt txBound;
    TransactionReceipt txUnbound;

    @BeforeAll
    static void setup() throws Exception {
        web3j = Web3j.build(new HttpService("http://172.17.0.2:8545"));
        creds = Credentials.create("0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80");
        creds2 = Credentials.create("0x7c852118294e51e653712a81e05800f419141751be58f605c371e15141b007a6");
        gasPro = new DefaultGasProvider();

        NetworkProviderOptions opt = new NetworkProviderOptions(31337, web3j, creds, gasPro);
        provider = new Provider(opt);

        System.arraycopy("testProvider".getBytes(), 0, title, 0, 12);
        System.arraycopy("testEndpoint".getBytes(), 0, endpoint, 0, 12);
        System.arraycopy("Ramanujan".getBytes(), 0, endpoint2, 0, 9);

        curve = new ArrayList<BigInteger>();
        curve.add(BigInteger.valueOf(3));
        curve.add(BigInteger.valueOf(0));
        curve.add(BigInteger.valueOf(2));
        curve.add(BigInteger.valueOf(1));
        curve.add(BigInteger.valueOf(1000000));

        byte[] param1 = new byte[32];
        byte[] param2 = new byte[32];
        System.arraycopy("A".getBytes(), 0, param1, 0, 1);
        System.arraycopy("B".getBytes(), 0, param2, 0, 1);
        params = new ArrayList<byte[]>();
        params.add(param1);
        params.add(param2);
    }
    
    @Test
    @Order(1)
    void testProviderInitiateProvider() throws Exception {
        InitProvider init = new InitProvider();
        init.publicKey = BigInteger.valueOf(103);
        init.title = title;

        if (provider.isProviderInitialized()) {
            System.out.println("Provider is already initiated");
        } else {
            assertNotNull(provider.initiateProvider(init));
        }
    }

    @Test
    @Order(2)
    void testProviderInitiateProviderCurve() throws Exception {
        InitCurve init = new InitCurve();
        init.broker = "0x0000000000000000000000000000000000000000";
        init.endpoint = endpoint;
        init.term = curve;

        assertNotNull(provider.initiateProviderCurve(init));
    }

    @Test
    @Order(3)
    void testProviderSetEndpointParams() throws Exception {
        EndpointParams param = new EndpointParams();
        param.endpoint = endpoint;
        param.endpointParams = params;
        
        assertNotNull(provider.setEndpointParams(param));
    }

    @Test
    void testProviderGetTitle() throws Exception {
        assertNotNull(provider.getTitle());
    }

    @Test
    void testProviderIsEndpointCreated() throws Exception {
        assertNotNull(provider.isEndpointCreated(endpoint));
    }

    @Test
    void testProviderGetPubKey() throws Exception {
        assertNotNull(provider.getPubKey());
    }

    @Test
    void testProviderGetProviderParams() throws Exception {
        assertNotNull(provider.getAllProviderParams());
    }

    @Test
    void testProviderGetEndpointBroker() throws Exception {
        assertNotNull(provider.getEndpointBroker(endpoint));
    }

    @Test
    void testProviderGetEndpointParams() throws Exception {
        assertNotNull(provider.getEndpointParams(endpoint));
    }

    @Test
    void testProviderGetEndpoints() throws Exception {
        assertNotNull(provider.getEndpoints());
    }

    @Test
    void testProviderGetBoundDots() throws Exception {
        assertNotNull(provider.getBoundDots(endpoint, creds.getAddress()));
    }

    @Test
    void testProviderGetDotsIssued() throws Exception {
        assertNotNull(provider.getDotsIssued(endpoint));
    }

    @Test
    void testProviderGetDotsLimit() throws Exception {
        assertNotNull(provider.getDotsLimit(endpoint));
    }

    @Test
    void testProviderGetZapRequired() throws Exception {
        assertNotNull(provider.getZapRequired(endpoint, new BigInteger("10")));
    }

    @Test
    void testProviderGetNumEscrow() throws Exception {
        BondageArgs args = new BondageArgs();
        args.dots = new BigInteger("10");
        args.endpoint = endpoint;
        args.provider = creds.getAddress();
        args.subscriber = creds.getAddress();
        args.zapNum = new BigInteger("10");
        assertNotNull(provider.getNumEscrow(args));
    }

    @Test
    @Order(4)
    void testProviderRespond() throws Exception {
        ResponseArgs args = new ResponseArgs();
        args.dynamic = false;
        args.responseParams = new ArrayList<String>();
        args.responseParams.add("respond1");
        // Bondage bond = Bondage.load("0x8a791620dd6260079bf849dc5567adc3f2fdc318", web3j, creds2, gasPro);
        Dispatch dis = Dispatch.load("0x5fc8d32690cc91d4c39d9d3abcbd16989f875707", web3j, creds, gasPro);
    
        // bond.bond(creds.getAddress(), endpoint, new BigInteger("999")).send();
        txQueries = dis.query(creds.getAddress(), "query", endpoint2, params).send();
        List <Dispatch.IncomingEventResponse> events = provider.listenQueries(txQueries);
        args.queryID = events.get(events.size()-1).id;
        assertNotNull(provider.respond(args));
    }

    @Disabled
    void testProviderListenSubscribes() throws Exception {
        assertNotNull(provider.listenSubscribes(txSub));
    }

    @Disabled
    void testProviderListenUnSub() throws Exception {
        assertNotNull(provider.listenUnsubscribes(txUnSub));
    }

    @Disabled
    void testProviderListenQueries() throws Exception {
        assertNotNull(provider.listenQueries(txQueries));
    }

    @Disabled
    void testProviderListenBound() throws Exception {
        assertNotNull(provider.listenBound(txBound));
    }

    @Disabled
    void testProviderListenUnbound() throws Exception {
        assertNotNull(provider.listenUnbound(txUnbound));
    }
}