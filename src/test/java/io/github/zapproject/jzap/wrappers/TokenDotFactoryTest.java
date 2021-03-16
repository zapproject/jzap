package io.github.zapproject.jzap;

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
class TokenDotFactoryIntegrationTest {
    static TokenDotFactory dotFactory;

    static Web3j web3j;
    static Credentials creds;
    static ContractGasProvider gasPro;

    static byte[] title = new byte[32];
    static byte[] endpoint = new byte[32];
    static byte[] symbol = new byte[32];
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
        gasPro = new DefaultGasProvider();

        System.arraycopy("testProvider".getBytes(), 0, title, 0, 12);

        NetworkProviderOptions opt = new NetworkProviderOptions(31337, web3j, creds, gasPro);
        TokenFactory factory = TokenFactory.deploy(web3j, creds, gasPro).send();
        dotFactory = TokenDotFactory.deploy(web3j, creds, gasPro, "0xe7f1725e7734ce288f8367e1bb143e90bb3f0512", factory.getContractAddress(), new BigInteger("100"), title).send();

        System.arraycopy("Ramanujan".getBytes(), 0, endpoint, 0, 9);
        System.arraycopy("symbol".getBytes(), 0, symbol, 0, 6);

        curve = new ArrayList<BigInteger>();
        curve.add(BigInteger.valueOf(3));
        curve.add(BigInteger.valueOf(0));
        curve.add(BigInteger.valueOf(2));
        curve.add(BigInteger.valueOf(1));
        curve.add(BigInteger.valueOf(1000000));
    }

    @Test
    @Order(1)
    void testTokenDotFactoryInitializeCurve() throws Exception {
        assertNotNull(dotFactory.initializeCurve(endpoint, symbol, curve).send());
    }

    @Disabled
    @Order(2)
    void testTokenDotFactoryBond() throws Exception {
        assertNotNull(dotFactory.bond(endpoint, new BigInteger("999")).send());
    }

    @Disabled
    @Order(3)
    void testTokenDotFactoryUnbond() throws Exception {
        assertNotNull(dotFactory.unbond(endpoint, new BigInteger("1")).send());
    }

    @Test
    void testTokenDotFactoryGetTokenAddress() throws Exception {
        assertNotNull(dotFactory.getTokenAddress(endpoint).send());
    }

    @Test
    void testTokenDotFactoryGetEndpoints() throws Exception {
        assertNotNull(dotFactory.getEndpoints().send());
    }

    @Test
    void testTokenDotFactoryNewToken() throws Exception {
        assertNotNull(dotFactory.newToken("test-name", "test-symbol").send());
    }
}