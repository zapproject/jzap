package io.github.zapproject.jzap;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
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
class SubscriberTest {
    static Subscriber subscriber;

    static Web3j web3j;
    static Credentials creds;
    static ContractGasProvider gasPro;
    
    static byte[] title = new byte[32];
    static byte[] endpoint = new byte[32];
    static List<byte[]> params;
    static BigInteger queryID;
    
    TransactionReceipt txQueries;

    @BeforeAll
    static void setup() throws Exception {
        web3j = Web3j.build(new HttpService("http://172.17.0.2:8545"));
        creds = Credentials.create("0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80");
        gasPro = new DefaultGasProvider();

        NetworkProviderOptions opt = new NetworkProviderOptions(31337, web3j, creds, gasPro);
        subscriber = new Subscriber(opt);

        System.arraycopy("testProvider".getBytes(), 0, title, 0, 12);
        System.arraycopy("Ramanujan".getBytes(), 0, endpoint, 0, 9);

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
    void testSubscriberApproveToBond() throws Exception {
        ApproveType type = new ApproveType();
        type.provider = creds.getAddress();
        type.zapNum = new BigInteger("1000000000");

        assertNotNull(subscriber.approveToBond(type));
    }

    @Test
    @Order(2)
    void testSubscriberBond() throws Exception {
        BondType type = new BondType();
        type.dots = new BigInteger("999");
        type.provider = creds.getAddress();
        type.endpoint = endpoint;
        type.subscriber = subscriber.bondage.getContractAddress();

        assertNotNull(subscriber.bond(type));
    }

    @Test
    @Order(3)
    void testSubscriberSubscribe() throws Exception {
        SubscribeType type = new SubscribeType();
        type.endpoint = endpoint;
        type.provider = creds.getAddress();
        type.endpointParams = params;
        type.dots = new BigInteger("100");

        assertNotNull(subscriber.subscribe(type));
    }

    @Test
    @Order(4)
    void testSubscriberQueryData() throws Exception {
        QueryArgs args = new QueryArgs();
        args.endpoint = endpoint;
        args.endpointParams = params;
        args.query = "query";
        args.provider = creds.getAddress();
        
        assertNotNull(txQueries = subscriber.queryData(args));

        List<Dispatch.IncomingEventResponse> events = subscriber.dispatch.getIncomingEvents(txQueries);
        queryID = events.get(events.size()-1).id;
    }

    @Test
    @Order(5)
    void testSubscriberCancelQuery() throws Exception {
        assertNotNull(subscriber.cancelQuery(queryID));
    }

    @Test
    void testSubscriberGetZapBalance() throws Exception {
        assertNotNull(subscriber.getZapBalance());
    }

    @Test
    void testSubscriberGetZapAllowance() throws Exception {
        assertNotNull(subscriber.getZapAllowance());
    }

    @Test
    void testSubscriberDelegateBond() throws Exception {
        DelegateBondType type = new DelegateBondType();
        type.dots = new BigInteger("1");
        type.endpoint = endpoint;
        type.provider = creds.getAddress();
        type.subscriber = subscriber.bondage.getContractAddress();

        assertNotNull(subscriber.delegateBond(type));
    }

    @Test
    void testSubscriberUnbond() throws Exception {
        UnbondType type = new UnbondType();
        type.dots = new BigInteger("1");
        type.endpoint = endpoint;
        type.provider = creds.getAddress();

        assertNotNull(subscriber.unBond(type));
    }

    @Test
    void testSubscriberGetNumEscrow() throws Exception {
        BondageArgs args = new BondageArgs();
        args.endpoint = endpoint;
        args.provider = creds.getAddress();

        assertNotNull(subscriber.getNumEscrow(args));
    }

    @Test
    void testSubscriberGetBoundDots() throws Exception {
        BondageArgs args = new BondageArgs();
        args.endpoint = endpoint;
        args.provider = creds.getAddress();

        assertNotNull(subscriber.getBoundDots(args));
    }

    @Test
    void testSubscriberHasEnoughZap() throws Exception {
        assertNotNull(subscriber.hasEnoughZap(new BigInteger("1")));
    }
}