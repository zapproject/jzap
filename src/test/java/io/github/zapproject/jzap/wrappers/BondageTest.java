package io.github.zapproject.jzap;

import java.math.BigInteger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BondageTest {
    private static Bondage bondage;
    
    private static Web3j web3j;
    private static Credentials creds;
    private static Credentials creds2;
    private static ContractGasProvider gasPro;

    private TransactionReceipt txBound;
    private TransactionReceipt txEscrow;
    private TransactionReceipt txReleased;
    private TransactionReceipt txReturned;
    private TransactionReceipt txUnbound;

    private static byte[] endpoint = new byte[32];

    @BeforeAll
    static void setup() throws Exception {
        web3j = Web3j.build(new HttpService());
        creds = Credentials.create("0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80");
        creds2 = Credentials.create("0x7c852118294e51e653712a81e05800f419141751be58f605c371e15141b007a6");
        gasPro = new DefaultGasProvider();

        bondage = Bondage.load("0x8a791620dd6260079bf849dc5567adc3f2fdc318", web3j, creds2, gasPro);
        
        System.arraycopy("Ramanujan".getBytes(), 0, endpoint, 0, 9);
    }

    @Test
    @Order(1)
    void testBondageBond() throws Exception {
        assertNotNull(txBound = bondage.bond(creds.getAddress(), endpoint, new BigInteger("100")).send());

        assertNotNull(bondage.getBoundEvents(txBound));
    }

    @Test
    @Order(2)
    void testBondageUnbond() throws Exception {
        assertNotNull(txUnbound = bondage.unbond(creds.getAddress(), endpoint, new BigInteger("10")).send());
        
        assertNotNull(bondage.getUnboundEvents(txUnbound));
    }

    @Test
    @Order(3)
    void testBondageDelegateBond() throws Exception {
        assertNotNull(bondage.delegateBond(creds.getAddress(), creds.getAddress(), endpoint, new BigInteger("10")).send());
    }

    @Disabled
    @Order(4)
    void testBondageEscrowDots() throws Exception {
        assertNotNull(txEscrow = bondage.escrowDots(creds.getAddress(), creds.getAddress(), endpoint, new BigInteger("10")).send());

        assertNotNull(bondage.getEscrowedEvents(txEscrow));
    }

    @Disabled
    @Order(5)
    void testBondageReleaseDots() throws Exception {
        assertNotNull(txReleased = bondage.releaseDots(creds.getAddress(), creds.getAddress(), endpoint, new BigInteger("10")).send());
        
        assertNotNull(bondage.getReleasedEvents(txReleased));
    }

    @Disabled
    @Order(6)
    void testBondageReturnDots() throws Exception {
        assertNotNull(txReturned = bondage.returnDots(creds.getAddress(), creds.getAddress(), endpoint, new BigInteger("10")).send());
        
        assertNotNull(bondage.getReturnedEvents(txReturned));
    }

    @Test
    @Order(7)
    void testBondageZapForDots() throws Exception {
        assertNotNull(bondage.calcZapForDots(creds.getAddress(), endpoint, new BigInteger("1")).send());
        // System.out.println("#### ZAPFORDOTS #####: " + bondage.calcZapForDots(creds.getAddress(), endpoint, new BigInteger("1")).send());
    }

    @Test
    @Order(8)
    void testBondageCurrentCostOfDots() throws Exception {
        assertNotNull(bondage.currentCostOfDot(creds.getAddress(), endpoint, new BigInteger("100")).send());
        // System.out.println("##### COSTOFDOTS #####: " + bondage.currentCostOfDot(creds.getAddress(), endpoint, new BigInteger("100")).send());
    }

    @Test
    @Order(9)
    void testBondageGetZapBound() throws Exception {
        assertNotNull(bondage.getZapBound(creds.getAddress(), endpoint).send());
    }

    @Test
    @Order(10)
    void testBondageDotLimit() throws Exception {
        assertNotNull(bondage.dotLimit(creds.getAddress(), endpoint).send());
        // System.out.println("##### DOTLIMIT ####: " + bondage.dotLimit(creds.getAddress(), endpoint).send());
    }

    @Test
    @Order(11)
    void testBondageIsProviderInitiated() throws Exception {
        assertNotNull(bondage.isProviderInitialized(creds.getAddress(), creds2.getAddress()).send());
    }

    @Test
    @Order(12)
    void testBondageGetEndpointBroker() throws Exception {
        assertNotNull(bondage.getEndpointBroker(creds2.getAddress(), endpoint).send());
    }

    @Test
    @Order(13)
    void testBondageGetNumEscrow() throws Exception {
        assertNotNull(bondage.getNumEscrow(creds.getAddress(), creds2.getAddress(), endpoint).send());
    }

    @Test
    @Order(13)
    void testBondageGetNumZap() throws Exception {
        assertNotNull(bondage.getNumZap(creds2.getAddress(), endpoint).send());
    }

    @Test
    @Order(14)
    void testBondageGetDotsIssued() throws Exception {
        assertNotNull(bondage.getDotsIssued(creds2.getAddress(), endpoint).send());
    }

    @Test
    @Order(15)
    void testBondageGetBoundDots() throws Exception {
        assertNotNull(bondage.getBoundDots(creds.getAddress(), creds2.getAddress(), endpoint).send());
    }

    @Test
    @Order(16)
    void testBondageGetIndexSize() throws Exception {
        assertNotNull(bondage.getIndexSize(creds2.getAddress()).send());
    }

    @Test
    @Order(17)
    void testBondageGetOracleAddress() throws Exception {
        assertNotNull(bondage.getOracleAddress(creds2.getAddress(), new BigInteger("0")).send());
    }
}