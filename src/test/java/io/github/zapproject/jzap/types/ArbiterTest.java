package zapprotocol.jzap.wrappers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ArbiterTest {
    private static Arbiter arbiter;
    private static ZapCoordinator coordinator;
    private static Registry registry;
    private static Bondage bondage;
    private static Database database;
    private static ZapToken token;
    private static Registry reg2;

    private static Web3j web3j;
    private static Credentials creds;
    private static Credentials creds2;
    private static ContractGasProvider gasPro;
    private static byte[] endpoint = new byte[32];
    private static String subscriber;

    private TransactionReceipt txPurchase;
    private TransactionReceipt txEnd;
    private TransactionReceipt txParams;

    @SuppressWarnings("unchecked")
    @BeforeAll
    static void setup() throws Exception {
        web3j = Web3j.build(new HttpService());
        creds = Credentials.create("0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80");
        creds2 = Credentials.create("0x47e179ec197488593b187f80a00eb0da91f1b9d0b13f8733639f19c30a34926a");
        gasPro = new DefaultGasProvider();

        database = Database.load("0xdc64a140aa3e981100a9beca4e685f962f0cf6c9", web3j, creds, gasPro);
        coordinator = ZapCoordinator.load("0xe7f1725e7734ce288f8367e1bb143e90bb3f0512", web3j, creds, gasPro);
        arbiter = Arbiter.load("0x9fe46736679d2d9a65f0992f2272de9f3c7fa6e0", web3j, creds, gasPro);
        registry = Registry.load("0xa513e6e4b8f2a923d98304ec87f64353c4d5c853", web3j, creds, gasPro);
        reg2 = Registry.load("0xa513e6e4b8f2a923d98304ec87f64353c4d5c853", web3j, creds2, gasPro);
        bondage = Bondage.load("0x8a791620dd6260079bf849dc5567adc3f2fdc318", web3j, creds, gasPro);
        token = ZapToken.load("0x5fbdb2315678afecb367f032d93f642f64180aa3", web3j, creds, gasPro);

        System.arraycopy("Ramanujan".getBytes(), 0, endpoint, 0, 9);
        subscriber = creds.getAddress();
    }
    
    // @Test
    // @Order(1)
    // void testArbiterUpdateDependencies() throws Exception {
    //     assertNotNull(coordinator.updateAllDependencies());
    // }

    @Test
    @Order(1)
    void testArbiterDB() throws Exception {
        assertNotNull(arbiter.db().send());
    }

    @Test
    @Order(1)
    void testArbiterInitiateSubscription() throws Exception {
        byte[] param1 = new byte[32];
        byte[] param2 = new byte[32];
        List<byte[]> params = new ArrayList<byte[]>();
        System.arraycopy("A".getBytes(), 0, param1, 0, 1);
        System.arraycopy("B".getBytes(), 0, param2, 0, 1);
        params.add(param1);
        params.add(param2);

        // token.allocate(creds.getAddress(), new BigInteger("150000000000")).send();
        bondage.bond(creds.getAddress(), endpoint, new BigInteger("100")).send();
        
        assertNotNull(txPurchase = arbiter.initiateSubscription(
            creds.getAddress(), endpoint, 
            params, BigInteger.valueOf(100), BigInteger.valueOf(10)).send());

        assertNotNull(arbiter.getDataPurchaseEvents(txPurchase));

        assertNotNull(arbiter.dataPurchaseEventFlowable(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST));
    }

    @Test
    @Order(3)
    void testArbiterGetSubscription() throws Exception {
        assertNotNull(arbiter.getSubscription(creds.getAddress(), subscriber, endpoint).send());
    }

    @Test
    @Order(4)
    void testArbiterGetDots() throws Exception {
        assertNotNull(arbiter.getDots(creds.getAddress(), subscriber, endpoint).send());
    }

    @Test
    @Order(5)
    void testArbiterGetBlockStart() throws Exception {
        assertNotNull(arbiter.getBlockStart(creds.getAddress(), subscriber, endpoint).send());
    }

    @Test
    @Order(6)
    void testArbiterGetPreBlockEnd() throws Exception {
        assertNotNull(arbiter.getPreBlockEnd(creds.getAddress(), subscriber, endpoint).send());
    }

    @SuppressWarnings("unchecked")
    @Test
    @Order(7)
    void testArbiterPassParams() throws Exception {
        byte[] param1 = new byte[32];
        byte[] param2 = new byte[32];
        System.arraycopy("param1".getBytes(), 0, param1, 0, 6);
        System.arraycopy("param2".getBytes(), 0, param2, 0, 6);
        List params = new ArrayList<byte[]>();
        params.add(param1);
        params.add(param2);

        assertNotNull(arbiter.passParams(creds.getAddress(), endpoint, params).send());
        
        // assertNotNull(arbiter.getParamsPassedEvents(txParams));

        assertNotNull(arbiter.paramsPassedEventFlowable(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST));
    }

    @Test
    @Order(8)
    void testArbiterEndSubscriptionSubscriber() throws Exception {
        assertNotNull(txEnd = arbiter.endSubscriptionSubscriber(creds.getAddress(), endpoint).send());

        assertNotNull(arbiter.getDataSubscriptionEndEvents(txEnd));

        assertNotNull(arbiter.dataSubscriptionEndEventFlowable(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST));
    }

    @Disabled
    void testArbiterEndSubscriptionProvider() throws Exception {
        assertNotNull(arbiter.endSubscriptionProvider(subscriber, endpoint).send());
    }
}