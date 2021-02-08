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

class ERC20Test {
    static private ERC20 erc20;

    @BeforeAll
    static void testDeployERC20() throws Exception {
        Web3j web3j = Web3j.build(new HttpService());
        Credentials creds = Credentials.create("0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80");
        ContractGasProvider gasPro = new DefaultGasProvider();
        erc20 = ERC20.deploy(web3j, creds, gasPro).send();
    }

    @Test
    void testBalanceOf() throws Exception {
        assertNotNull(erc20.balanceOf("0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80").send());
    }

    @Test
    void testDecimals() throws Exception{
        assertNotNull(erc20.decimals().send());
    }

    @Test
    void testName() throws Exception{
        assertNotNull(erc20.name().send());
    }

    @Test
    void testSymbol() throws Exception {
        assertNotNull(erc20.symbol().send());
    }

    @Test
    void testTotalSupply() throws Exception {
        assertNotNull(erc20.totalSupply().send());
    }

    @Test
    void testTransfer() throws Exception {
        erc20.transfer("0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80", BigInteger.valueOf(1)).send();
    }

    @Test
    void testAllowance() throws Exception {
        erc20.allowance("0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80", "0x59c6995e998f97a5a0044966f0945389dc9e86dae88c7a8412f4603b6b78690d").send();
    }

    @Test
    void testTransferFrom() throws Exception {
        erc20.transferFrom("0x59c6995e998f97a5a0044966f0945389dc9e86dae88c7a8412f4603b6b78690d", "0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80", BigInteger.valueOf(100)).send();
    }

    @Test
    void testApprove() throws Exception {
        erc20.approve("0x59c6995e998f97a5a0044966f0945389dc9e86dae88c7a8412f4603b6b78690d", BigInteger.valueOf(10)).send();
    }
}