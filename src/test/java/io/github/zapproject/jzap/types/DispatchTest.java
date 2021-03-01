package zapprotocol.jzap.wrappers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DispatchTest {
    private static Dispatch dispatch;

    private static Web3j web3j;
    private static Credentials creds;
    private static ContractGasProvider gasPro;

    String query = "query"; 

    static byte[] endpoint = new byte[32];
    static List<byte[]> params = new ArrayList<byte[]>();


    @BeforeAll
    static void setup() {
        web3j = Web3j.build(new HttpService());
        creds = Credentials.create("0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80");
        gasPro = new DefaultGasProvider();

        dispatch = Dispatch.load("0x5fc8d32690cc91d4c39d9d3abcbd16989f875707", web3j, creds, gasPro);
    
        System.arraycopy("Ramanujan".getBytes(), 0, endpoint, 0, 9);
        byte[] param1 = new byte[32];
        byte[] param2 = new byte[32];
        System.arraycopy("A".getBytes(), 0, param1, 0, 1);
        System.arraycopy("B".getBytes(), 0, param2, 0, 1);
        params.add(param1);
        params.add(param2);
    }

    @Test
    @Order(1)
    void testDispatchQuery() throws Exception {
        assertNotNull(dispatch.query(creds.getAddress(), query, endpoint, params).send());
    }

    @Test
    @Order(2)
    void testDispatchResponseBytes32Array() throws Exception {
        // assertNotNull(dispatch.respondBytes32Array().send());
    }


    @Disabled
    void testDispatchCancelQuery() throws Exception {
        assertNotNull(dispatch.cancelQuery(new BigInteger("0")).send());
    }
}