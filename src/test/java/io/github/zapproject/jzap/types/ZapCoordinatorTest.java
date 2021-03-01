package zapprotocol.jzap.wrappers;

import java.math.BigInteger;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
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
    private static Bondage bondage;
    private static TransactionReceipt txReceipt;
    private static Web3j web3j;
    private static Credentials creds;
    private static ContractGasProvider gasPro;

    @BeforeAll
    static void testDeployZapCoordinator() throws Exception {
        web3j = Web3j.build(new HttpService());
        creds = Credentials.create("0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80");
        gasPro = new DefaultGasProvider();
        database = Database.deploy(web3j, creds, gasPro).send();
        coord1 = ZapCoordinator.deploy(web3j, creds, gasPro).send();
        coord2 = ZapCoordinator.deploy(web3j, creds, gasPro).send();
        bondage = Bondage.deploy(web3j, creds, gasPro, coord2.getContractAddress()).send();
        coordinator = new ZapCoordinator("0xe7f1725e7734ce288f8367e1bb143e90bb3f0512", web3j, creds, gasPro);
    }

    @Test
    void testZapCoordinatorDB() throws Exception {
        assertEquals("0xdc64a140aa3e981100a9beca4e685f962f0cf6c9", coordinator.db().send(), "DB does not match - check contract address");
    }

    @Test
    void testZapCoordinatorOwner() throws Exception {
        assertEquals(creds.getAddress(), coordinator.owner().send(), "Owner address does not match to account 0.");
    }

    @Test
    void testZapCoordinatorTransferOwnership() throws Exception {
        txReceipt = coord1.transferOwnership(coord2.getContractAddress()).send();
        assertNotNull(txReceipt.getLogs());
        System.out.println("#### TRANSFER OWNERSHIP ####: " + txReceipt.getTransactionHash());
    }

    @Test 
    void testZapCoordinatorUpdateAllDependencies() throws Exception {
        assertNotNull(coordinator.updateAllDependencies());
    }
    
    @Test 
    void testZapCoordinatorUpdateContract() throws Exception {
        txReceipt = coordinator.updateContract("NewZapCoordinator", coord2.getContractAddress()).send();
        assertNotNull(txReceipt.getLogs());
        // System.out.println("#### UPDATECONTRACTS ####: " + coordinator.getContract("NewZapCoordinator").getResult());
    }
    
    @Test
    void testZapCoordinatorAddImmutableContract() throws Exception {
        // not using assertEquals as web3j deploy functions deploy unrecognized contracts
        assertNotNull(coordinator.addImmutableContract("NewDatabase", database.getContractAddress()));
    }

    @Test
    void testZapCoordinatorGetContractName() throws Exception {
        assertEquals("ARBITER", coordinator.getContractName(BigInteger.valueOf(0)).send());
        // System.out.println("#### GetContractNAME()####: " + coordinator.getContractName(BigInteger.valueOf(0)).send());
    }

    @Test
    void testZapCoordinatorGetContract() throws Exception {
        assertNotNull(coordinator.getContract("ZapCoordinator"));
        // System.out.println("#### GetContract()####: " + coordinator.getContract("ZapCoordinator").getTransactionHash());
    }

    @Test
    void testZapCoordinatorLoadedContracts() throws Exception {
        assertEquals("ARBITER", coordinator.loadedContracts(BigInteger.valueOf(0)).send());
        // System.out.println("#### LOADEDCONTRACTS ####: " + coordinator.loadedContracts(BigInteger.valueOf(0)).send());
    }

    @Test
    void testZapCoordinatorGetOwnershipTransferredEvents() {
        List eventResponse = coordinator.getOwnershipTransferredEvents(txReceipt);
        assertNotNull(eventResponse);
        // System.out.println("getOwnershipTransferredEvents(): " + eventResponse.size());
    }

    @Test
    void testZapCoordinatorOwnershipTransferredEventsFlowable() {
        assertNotNull(coordinator.ownershipTransferredEventFlowable(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST));
    }

    @Test
    void testZapCooridnatorGetUpdateContractEvents() {
        List eventResponse = coordinator.getUpdatedContractEvents(txReceipt);
        assertNotNull(eventResponse);
        // System.out.println("GetUpdateContractEvents(): " + eventResponse.size());
    }

    @Test
    void testZapCoordinatorUpdatedContractEventFlowable() {
        assertNotNull(coordinator.updatedContractEventFlowable(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST));
    }

    @Test
    void testZapCoordinatorGetUpdatedDependenciesEvents() {
        List eventResponse = coordinator.getUpdatedDependenciesEvents(txReceipt);
        assertNotNull(eventResponse);
    }

    @Test
    void testZapCoordinatorUpdateDependenciesEventFlowable() {
        assertNotNull(coordinator.updatedDependenciesEventFlowable(DefaultBlockParameterName.EARLIEST,
        DefaultBlockParameterName.LATEST));
    }
}