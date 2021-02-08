package zapprotocol.jzap.wrappers;

import java.math.BigInteger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ERC20BasicTest {
    static private ERC20Basic erc20Basic;

    @BeforeAll
    static void testDeployERC20Basic() throws Exception {
        Web3j web3j = Web3j.build(new HttpService());
        Credentials creds = Credentials.create("0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80");
        ContractGasProvider gasPro = new DefaultGasProvider();
        erc20Basic = ERC20Basic.deploy(web3j, creds, gasPro).send();
    }

    @Test
    void testTotalSupply() throws Exception {
        assertNotNull(erc20Basic.totalSupply().send());
    }

    @Test
    void testBalanceOf() throws Exception {
        assertNotNull(erc20Basic.balanceOf("0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80").send());
    }

    @Test
    void testTransfer() throws Exception {
        erc20Basic.transfer("0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80", BigInteger.valueOf(1)).send();
    }
}