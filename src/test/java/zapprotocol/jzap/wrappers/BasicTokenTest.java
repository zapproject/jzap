package zapprotocol.jzap.wrappers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BasicTokenTest {
    static private BasicToken basicToken;

    @BeforeAll
    static void testDeployBasicToken() throws Exception {
        Web3j web3j = Web3j.build(new HttpService());
        Credentials creds = Credentials.create("0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80");
        ContractGasProvider gasPro = new DefaultGasProvider();
        basicToken = BasicToken.deploy(web3j, creds, gasPro).send();
    }

    @Test
    void test() {
        
    }
    // @Test
    // void testTransfer() throws Exception {
    //     basicToken.transfer("0x959922be3caee4b8cd9a407cc3ac1c251c2007b1", BigInteger.valueOf(1)).send();
    // }

    // @Test
    // void testBalanceOf() throws Exception {
    //     basicToken.balanceOf("0xe7f1725e7734ce288f8367e1bb143e90bb3f0512").send();
    // }
}