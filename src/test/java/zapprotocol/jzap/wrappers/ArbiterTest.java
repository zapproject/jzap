package zapprotocol.jzap.wrappers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ArbiterTest{
    private static Arbiter arbiter;
    private static ZapCoordinator coordinator;

    @BeforeAll
    static void testDeployArbiter() throws Exception {
        Web3j web3j = Web3j.build(new HttpService());
        Credentials creds = Credentials.create("0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80");
        ContractGasProvider gasPro = new DefaultGasProvider();
        coordinator = ZapCoordinator.deploy(web3j, creds, gasPro).send();
        arbiter = Arbiter.deploy(web3j, creds, gasPro, coordinator.getContractAddress()).send();
    }

    @Test
    void testInitiateSubscription() {
        // verify(arbiter).initiateSubscription(anyString(), new byte[]{anyByte()}, anyList(), any(BigInteger.class), any(BigInteger.class));
        // assertNotNull(arbiter.initiateSubscription("0x959922be3caee4b8cd9a407cc3ac1c251c2007b1", new byte[]{1}, new ArrayList<byte[]>(), BigInteger.valueOf(1), BigInteger.valueOf(1)));
    }
}
