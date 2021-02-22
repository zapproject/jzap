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
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class RegistryTest {
    private static Registry registry;
    private static Web3j web3j;
    private static Credentials creds;
    private static ContractGasProvider gasPro;
    private TransactionReceipt txReceipt;
    private static Registry reg1;
    private static ZapCoordinator coordinator;
    private static Database database;

    static byte[] title = new byte[32];
    static byte[] endpoint = new byte[32];
    String emptyBroker = "0x0000000000000000000000000000000000000000";

    @BeforeAll
    static void testRegistrySetUp() throws Exception {
        web3j = Web3j.build(new HttpService());
        creds = Credentials.create("0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80");
        gasPro = new DefaultGasProvider();
        database = Database.load("0xdc64a140aa3e981100a9beca4e685f962f0cf6c9" , web3j, creds, gasPro);
        coordinator = ZapCoordinator.load("0xe7f1725e7734ce288f8367e1bb143e90bb3f0512", web3j, creds, gasPro);
        registry = Registry.load("0xa513e6e4b8f2a923d98304ec87f64353c4d5c853", web3j, creds, gasPro);
        reg1 = Registry.deploy(web3j, creds, gasPro, coordinator.getContractAddress()).send();
        
        System.arraycopy("testProvider".getBytes(), 0, title, 0, 12);
        System.arraycopy("testEndpoint".getBytes(), 0, endpoint, 0, 12);
        // System.arraycopy("Slothrop".getBytes(), 0, title, 0, 8);
        // System.arraycopy("Ramanujan".getBytes(), 0, endpoint, 0, 9);
    }

    // endpoint: 'Ramanujan',
    // curve: [ 3, 0, 0, 1, 122 ],
    // address: '0xf39Fd6e51aad88F6F4ce6aB8827279cffFb92266'

//     title: 'Slothrop',
//   address: '0xf39Fd6e51aad88F6F4ce6aB8827279cffFb92266',
//   publicKey: 100,
//   status: true

    
    @Disabled
    void testRegistryTransferOwnership() throws Exception {
        assertNotNull(reg1.transferOwnership(coordinator.getContractAddress()).send());
    }

    @Disabled
    @Order(1)
    void testRegistryInitiateProvider() throws Exception {
        assertNotNull(registry.initiateProvider(BigInteger.valueOf(100), title).send());
    }

    @SuppressWarnings("unchecked")
    @Test
    @Order(2)
    void testRegistryInitiateProviderCurve() throws Exception {
        List curve = new ArrayList<BigInteger>();
        curve.add(BigInteger.valueOf(3));
        curve.add(BigInteger.valueOf(0));
        curve.add(BigInteger.valueOf(2));
        curve.add(BigInteger.valueOf(1));
        curve.add(BigInteger.valueOf(100));
        assertNotNull(registry.initiateProviderCurve(endpoint, curve, emptyBroker).send());
    }

    @Test
    @Order(3)
    void testRegistryStringToBytes32() throws Exception {
        assertNotNull(registry.stringToBytes32("Test").send());
    }

    @Test
    @Order(4)
    void testRegistrySetProviderParameter() throws Exception {
        byte[] key = new byte[32];
        byte[] value = new byte[32];
        System.arraycopy("key".getBytes(), 0, key, 0, 3);
        System.arraycopy("value".getBytes(), 0, value, 0, 5);
        assertNotNull(registry.setProviderParameter(key, value).send());
    }

    @Test
    @Order(7)
    void testRegistrygetProviderParameter() throws Exception {
        byte[] key = new byte[32];
        System.arraycopy("key".getBytes(), 0, key, 0, 3);
        assertNotNull(registry.getProviderParameter(creds.getAddress(), key).send());
    }

    @Test
    @Order(8)
    void testRegistryGetAllProviderParams() throws Exception {
        assertNotNull(registry.getAllProviderParams(creds.getAddress()).send());
    }

    @SuppressWarnings("unchecked")
    @Test
    @Order(5)
    void testRegistrySetEndpointParams() throws Exception {
        byte[] param1 = new byte[32];
        byte[] param2 = new byte[32];
        System.arraycopy("param1".getBytes(), 0, param1, 0, 6);
        System.arraycopy("param2".getBytes(), 0, param2, 0, 6);
        List params = new ArrayList<byte[]>();
        params.add(param1);
        params.add(param2);
        assertNotNull(registry.setEndpointParams(endpoint, params).send());
    }

    @Test
    @Order(6)
    void testRegistrySetProviderTitle() throws Exception {
        assertNotNull(txReceipt = registry.setProviderTitle(title).send());
    }

    @Disabled
    void testRegistryClearEndPoint() throws Exception {
        assertNotNull(registry.clearEndpoint(title).send());
    }

    @Test
    void testRegistryGetProviderPublicKey() throws Exception {
        assertNotNull(registry.getProviderPublicKey(creds.getAddress()).send());
    }

    @Test
    void testRegistryGetProviderTitle() throws Exception {
        assertNotNull(registry.getProviderTitle(creds.getAddress()).send());
    }

    @Test
    void testRegistryGetProviderCurve() throws Exception {
        assertNotNull(registry.getProviderCurve(creds.getAddress(), endpoint).send());
    }

    @Test
    void testRegistryGetProviderCurveLength() throws Exception {
        assertNotNull(registry.getProviderCurveLength(creds.getAddress(), endpoint).send());
    }

    @Test
    void testRegistryIsProviderInitiated() throws Exception {
        assertNotNull(registry.isProviderInitiated(creds.getAddress()).send());
    }

    @Test
    void testRegistryGetPublicKey() throws Exception {
        assertNotNull(registry.getPublicKey(creds.getAddress()).send());
    }

    @Test
    void testRegistryGetProviderEndpoints() throws Exception {
        assertNotNull(registry.getProviderEndpoints(creds.getAddress()).send());
    }

    @Test
    void testRegistryGetEndpointParams() throws Exception {
        assertNotNull(registry.getEndpointParams(creds.getAddress(), title).send());
    }

    @Test
    void testRegistryGetEndpointBroker() throws Exception {
        assertNotNull(registry.getEndpointBroker(creds.getAddress(), title).send());
    }

    @Test
    void testRegistryGetCurveUnset() throws Exception {
        assertNotNull(registry.getCurveUnset(creds.getAddress(), title).send());
    }

    @Test
    void testRegistryGetOracleAddress() throws Exception {
        assertNotNull(registry.getOracleAddress(BigInteger.valueOf(1)).send());
    }

    @Test
    void testRegistryGetAllOracles() throws Exception {
        assertNotNull(registry.getAllOracles().send());
    }

    @Disabled
    void testRegistrySelfDestruct() throws Exception {
        assertNotNull(registry.selfDestruct().send());
    }

    @Disabled
    void testRegistryGetNewCurveEvents() {
        assertNotNull(registry.getNewCurveEvents(txReceipt));
    }

    @Test
    void testRegistryNewCurveEventFlowable() {
        EthFilter filter =  new EthFilter(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST, coordinator.getContractAddress());
        assertNotNull(registry.newCurveEventFlowable(filter));
    }

    @Test
    void testRegistryNewCurveEventFlowableBlocks() {
        assertNotNull(registry.newCurveEventFlowable(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST));
    }

    @Disabled
    void testRegistryGetNewProviderEvents() {
        assertNotNull(registry.getNewCurveEvents(txReceipt));
    }

    @Test
    void testRegistryNewProviderEventFlowable() {
        EthFilter filter =  new EthFilter(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST, coordinator.getContractAddress());
        assertNotNull(registry.newProviderEventFlowable(filter));
    }

    @Test
    void testRegistryNewProviderEventFlowableBlocks() {
        assertNotNull(registry.newCurveEventFlowable(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST));
    }

    @Test
    void testRegistryOwnershipTransferredEventFlowable() {
        EthFilter filter =  new EthFilter(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST, coordinator.getContractAddress());
        assertNotNull(registry.ownershipTransferredEventFlowable(filter));
    }

    @Test
    void testRegistryOwnershipTransferredEventFlowableBlocks() {
        assertNotNull(registry.ownershipTransferredEventFlowable(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST));
    }
}