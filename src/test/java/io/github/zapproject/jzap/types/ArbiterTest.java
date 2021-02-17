package zapprotocol.jzap.wrappers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ArbiterTest {
    private static Arbiter arbiter;
    private static ZapCoordinator coordinator;
    private static Database database;
    private static Web3j web3j;
    private static Credentials creds;
    private static ContractGasProvider gasPro;
    private static TransactionReceipt txReceipt;
    private static byte[] endpoint = new byte[32];
    private static String subscriber;

    @BeforeAll
    static void setup() throws Exception {
        web3j = Web3j.build(new HttpService());
        creds = Credentials.create("0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80");
        gasPro = new DefaultGasProvider();
        coordinator = ZapCoordinator.load("0xe7f1725e7734ce288f8367e1bb143e90bb3f0512", web3j, creds, gasPro);
        arbiter = Arbiter.load("0x9fe46736679d2d9a65f0992f2272de9f3c7fa6e0", web3j, creds, gasPro);
        System.arraycopy("Ramanujan".getBytes(), 0, endpoint, 0, 9);
        subscriber = creds.getAddress();
    }

    @Test
    void testArbiterBondageAddress() throws Exception {
        assertNotNull(arbiter.bondageAddress().send());
    }

    @Test
    void testArbiterInitiateSubscription() throws Exception {
        byte[] param1 = new byte[32];
        byte[] param2 = new byte[32];
        List<byte[]> params = new ArrayList<byte[]>();
        System.arraycopy("param1".getBytes(), 0, param1, 0, 6);
        System.arraycopy("param2".getBytes(), 0, param2, 0, 6);
        params.add(param1);
        params.add(param2);
        assertNotNull(txReceipt = arbiter.initiateSubscription(creds.getAddress(), endpoint, params, 
                BigInteger.valueOf(100), BigInteger.valueOf(10)).send());
    }

    @Test
    void testArbiterGetSubscription() throws Exception {
        assertNotNull(arbiter.getSubscription(creds.getAddress(), subscriber, endpoint).send());
    }

    @Test
    void testArbiterGetDots() throws Exception {
        assertNotNull(arbiter.getDots(creds.getAddress(), subscriber, endpoint).send());
    }

    @Test
    void testArbiterGetBlockStart() throws Exception {
        assertNotNull(arbiter.getBlockStart(creds.getAddress(), subscriber, endpoint).send());
    }

    @Test
    void testArbiterGetPreBlockEnd() throws Exception {
        assertNotNull(arbiter.getPreBlockEnd(creds.getAddress(), subscriber, endpoint).send());
    }

    @Test
    void testArbiterGetDataPurchaseEvents() {
        assertNotNull(arbiter.getDataPurchaseEvents(txReceipt));
    }

    @Test
    void testArbiterDataPurchaseEventFlowable() {
        EthFilter filter =  new EthFilter(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST, coordinator.getContractAddress());
        assertNotNull(arbiter.dataPurchaseEventFlowable(filter));
    }

    @Test
    void testArbiterDataPurchaseEventFlowableBlocks() {
        assertNotNull(arbiter.dataPurchaseEventFlowable(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST));
    }

    @Test
    void testArbiterGetDataSubscriptionEndEvents() {
        assertNotNull(arbiter.getDataSubscriptionEndEvents(txReceipt));
    }

    @Test
    void testArbiterDataSubscriptionEndEventFlowable() {
        EthFilter filter =  new EthFilter(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST, coordinator.getContractAddress());
        assertNotNull(arbiter.dataSubscriptionEndEventFlowable(filter));
    }

    @Test
    void testArbiterParamsPassedEventFlowable() {
        EthFilter filter =  new EthFilter(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST, coordinator.getContractAddress());
        assertNotNull(arbiter.paramsPassedEventFlowable(filter));
    }

    @Test
    void testArbiterParamsPassedEventFlowableBlocks() {
        assertNotNull(arbiter.paramsPassedEventFlowable(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST));
    }

    @Test
    void testArbiterEndSubscriptionSubscriber() throws Exception {
        assertNotNull(arbiter.endSubscriptionSubscriber(creds.getAddress(), endpoint).send());
    }

    @Test
    void testArbiterEndSubscriptionProvider() throws Exception {
        assertNotNull(arbiter.endSubscriptionProvider(subscriber, endpoint).send());
    }
}