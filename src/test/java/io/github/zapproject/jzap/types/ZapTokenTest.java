package zapprotocol.jzap.wrappers;

import java.math.BigInteger;
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
    void testZapTokenAllowance() throws Exception {
        assertNotNull(token.allowance(creds.getAddress(), creds2.getAddress()).send());
    }

    @Test
    void testZapTokenApprove() throws Exception {
        assertNotNull(txApprove = token.approve(creds2.getAddress(), BigInteger.valueOf(10000)).send());
    }

    @Test
    void testZapTokenBalanceOf() throws Exception {
        assertNotNull(token.balanceOf(creds2.getAddress()).send());
    }

    @Test
    void testZapTokenDecimals() throws Exception {
        assertNotNull(token.decimals().send());
    }

    @Test
    void testZapTokenDecreaseApproval() throws Exception {
        assertNotNull(token.decreaseApproval(creds2.getAddress(), BigInteger.valueOf(1)).send());
    }

    @Test
    void testZapTokenIncreaseApproval() throws Exception {
        assertNotNull(token.increaseApproval(creds2.getAddress(), BigInteger.valueOf(1)).send());
    }

    @Test
    void testZapTokenMint() throws Exception {
        assertNotNull(txMint = token.mint(creds2.getAddress(), BigInteger.valueOf(1)).send());
    }

    @Test
    void testZapTokenFinishMinting() throws Exception {
        assertNotNull(txFinish = token.finishMinting().send());
    }
    @Test
    void testZapTokenMintingFinished() throws Exception {
        assertNotNull(token.mintingFinished().send());
    }

    @Test
    void testZapTokenName() throws Exception {
        assertNotNull(token.name().send());
    }

    @Test
    void testZapTokenOwner() throws Exception {
        assertNotNull(token.owner().send());
    }

    @Test
    void testZapTokenSymbol() throws Exception {
        assertNotNull(token.symbol().send());
    }

    @Test
    void testZapTokenTotalSupply() throws Exception {
        assertNotNull(token.totalSupply().send());
    }

    @Test
    void testZapTokenTransfer() throws Exception {
        assertNotNull(token.transfer(creds2.getAddress(), BigInteger.valueOf(1)).send());
    }

    @Test
    void testZapTokenTransferFrom() throws Exception {
        assertNotNull(token.transferFrom(creds2.getAddress(), creds.getAddress(), BigInteger.valueOf(100)).send());
    }

    @Test
    void testZapTokenAllocate() throws Exception {
        assertNotNull(token.allocate(creds.getAddress(), BigInteger.valueOf(10)).send());
    }

    @Test
    void testZapTokenGetApprovalEvents() {
        assertNotNull(token.getApprovalEvents(txApprove));
    }

    @Test
    void testZapTokenApprovalEventFlowable() {
        EthFilter filter =  new EthFilter(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST, token.getContractAddress());
        assertNotNull(token.approvalEventFlowable(filter));
    }

    @Test
    void testZapTokenApprovalEventFlowableBlock() {
        assertNotNull(token.approvalEventFlowable(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST));
    }

    @Test
    void testZapTokenGetMintEvents() {
        assertNotNull(token.getMintEvents(txMint));
    }

    @Test
    void testZapTokenMintEventFlowable() {
        EthFilter filter =  new EthFilter(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST, token.getContractAddress());
        assertNotNull(token.mintEventFlowable(filter));
    }

    @Test
    void testZapTokenMintEventFlowableBlock() {
        assertNotNull(token.mintEventFlowable(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST));
    }

    @Test
    void testZapTokenGetMintableFinishedEvents() {
        assertNotNull(token.getMintFinishedEvents(txFinish));
    }

    @Test
    void testZapTokenMintFinishedFlowable() {
        EthFilter filter =  new EthFilter(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST, token.getContractAddress());
        assertNotNull(token.mintFinishedEventFlowable(filter));
    }

    @Test
    void testZapTokenMintFinishedFlowableBlock() {
        assertNotNull(token.mintFinishedEventFlowable(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST));
    }
}