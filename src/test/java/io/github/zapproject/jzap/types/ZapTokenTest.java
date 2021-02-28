package zapprotocol.jzap.wrappers;

import io.reactivex.Flowable;
import java.math.BigInteger;
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

class ZapTokenTest {
    private static ZapToken token;
    private static Web3j web3j;
    private static Credentials creds;
    private static Credentials creds2;
    private static ContractGasProvider gasPro;
    TransactionReceipt txApprove;
    TransactionReceipt txMint;
    TransactionReceipt txFinish;

    @BeforeAll
    static void setup() {
        web3j = Web3j.build(new HttpService());
        creds = Credentials.create("0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80");
        creds2 = Credentials.create("0x7c852118294e51e653712a81e05800f419141751be58f605c371e15141b007a6");
        gasPro = new DefaultGasProvider();

        token = ZapToken.load("0x5fbdb2315678afecb367f032d93f642f64180aa3", web3j, creds, gasPro);
        
    }

    @Test
    @Order(1)
    void testZapTokenIncreaseApproval() throws Exception {
        assertNotNull(txApprove = token.increaseApproval(creds2.getAddress(), BigInteger.valueOf(1000)).send());
        // System.out.println("#### APPROVAL ####: " + txApprove.getLogs());

        assertNotNull(token.getApprovalEvents(txApprove));

        Flowable flow;
        assertNotNull(flow = token.approvalEventFlowable(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST));
    }

    @Disabled
    @Order(2)
    void testZapTokenFinishMinting() throws Exception {
        assertNotNull(txFinish = token.finishMinting().send());

        assertNotNull(token.getMintFinishedEvents(txFinish));

        assertNotNull(token.mintFinishedEventFlowable(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST));
    }

    @Test
    @Order(3)
    void testZapTokenAllocate() throws Exception {
        assertNotNull(txMint = token.allocate(creds.getAddress(), new BigInteger("100")).send());
    
        assertNotNull(token.getMintEvents(txMint));

        assertNotNull(token.mintEventFlowable(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST));
    }

    @Test
    @Order(4)
    void testZapTokenAllowance() throws Exception {
        assertNotNull(token.allowance(creds.getAddress(), creds2.getAddress()).send());
    }

    @Test
    @Order(5)
    void testZapTokenBalanceOf() throws Exception {
        assertNotNull(token.balanceOf(creds2.getAddress()).send());
    }

    @Test
    @Order(6)
    void testZapTokenDecreaseApproval() throws Exception {
        assertNotNull(txApprove = token.decreaseApproval(creds2.getAddress(), BigInteger.valueOf(1)).send());
    }

    @Test
    @Order(7)
    void testZapTokenTransfer() throws Exception {
        assertNotNull(token.transfer(creds2.getAddress(), BigInteger.valueOf(1)).send());
    }

    @Test
    @Order(8)
    void testZapTokenTransferFrom() throws Exception {
        assertNotNull(token.transferFrom(creds2.getAddress(), creds.getAddress(), BigInteger.valueOf(0)).send());
    }
}