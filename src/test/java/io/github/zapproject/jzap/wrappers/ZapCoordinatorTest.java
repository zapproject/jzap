package io.github.zapproject.jzap;

import java.math.BigInteger;
import java.util.List;
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
import static org.junit.jupiter.api.Assertions.assertEquals;

class ZapCoordinatorTest {
    private static ZapCoordinator coordinator;
    private static ZapCoordinator coord1;
    private static ZapCoordinator coord2;
    private static Database database;

    private static Web3j web3j;
    private static Credentials creds;
    private static Credentials creds2;
    private static ContractGasProvider gasPro;

    TransactionReceipt txTransfer;
    TransactionReceipt txUpdate;
    TransactionReceipt txDependencies;

    
    @BeforeAll
    static void setup() throws Exception {
        web3j = Web3j.build(new HttpService());
        creds = Credentials.create("0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80");
        creds2 = Credentials.create("0x47e179ec197488593b187f80a00eb0da91f1b9d0b13f8733639f19c30a34926a");
        gasPro = new DefaultGasProvider();

        coord1 = ZapCoordinator.deploy(web3j, creds, gasPro).send();
        coord2 = ZapCoordinator.deploy(web3j, creds, gasPro).send();
        coordinator = ZapCoordinator.load("0xe7f1725e7734ce288f8367e1bb143e90bb3f0512", web3j, creds, gasPro);
    }

    @Test
    @Order(1)
    void testZapCoordinatorDB() throws Exception {
        assertEquals("0xdc64a140aa3e981100a9beca4e685f962f0cf6c9", coordinator.db().send(), "DB does not match - check contract address");
    }

    @Test
    @Order(2)
    void testZapCoordinatorOwner() throws Exception {
        assertEquals(creds.getAddress(), coordinator.owner().send(), "Owner address does not match to account 0.");
    }

    @Disabled
    @Order(3)
    void testZapCoordinatorTransferOwnership() throws Exception {
        assertNotNull(txTransfer = coord1.transferOwnership(coord2.getContractAddress()).send());

        assertNotNull(coordinator.getOwnershipTransferredEvents(txTransfer));
    }

    @Disabled 
    @Order(4)
    void testZapCoordinatorUpdateAllDependencies() throws Exception {
        assertNotNull(coordinator.updateAllDependencies().send());
    }
    
    @Test 
    void testZapCoordinatorUpdateContract() throws Exception {
        assertNotNull(txUpdate = coordinator.updateContract("NewZapCoordinator", coord2.getContractAddress()).send());
        
        assertNotNull(coordinator.getUpdatedContractEvents(txUpdate));
    }
    
    @Test
    void testZapCoordinatorAddImmutableContract() throws Exception {
        database = Database.deploy(web3j, creds, gasPro).send();
        assertNotNull(coordinator.addImmutableContract("NewDatabase", database.getContractAddress()).send());
    }

    @Test
    void testZapCoordinatorGetContractName() throws Exception {
        assertEquals("ARBITER", coordinator.getContractName(BigInteger.valueOf(0)).send());
    }

    @Test
    void testZapCoordinatorGetContract() throws Exception {
        assertNotNull(coordinator.getContract("ARBITER").send());
    }

    @Test
    void testZapCoordinatorLoadedContracts() throws Exception {
        assertEquals("ARBITER", coordinator.loadedContracts(BigInteger.valueOf(0)).send());
    }

    @Disabled
    void testZapCoordinatorGetUpdatedDependenciesEvents() {
        List eventResponse = coordinator.getUpdatedDependenciesEvents(txDependencies);
        assertNotNull(eventResponse);
    }
}