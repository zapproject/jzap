package io.github.zapproject.jzap;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DispatchTest {
    private static Dispatch dispatch;

    private static Web3j web3j;
    private static Credentials creds;
    private static ContractGasProvider gasPro;

    static BigInteger id;
    static byte[] endpoint = new byte[32];
    static List<byte[]> params = new ArrayList<byte[]>();

    TransactionReceipt txIncoming;
    String query = "query"; 

    @BeforeAll
    static void setup() throws Exception {
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
    // @Order(1)
    void testDispatchQuery() throws Exception {
        assertNotNull(txIncoming = dispatch.query(creds.getAddress(), query, endpoint, params).send());
        
        List <Dispatch.IncomingEventResponse> list = dispatch.getIncomingEvents(txIncoming);
        // System.out.println("##### EVENT #####: " + list.get(list.size()-1).id);
        id = list.get(0).id;
    }

    @SuppressWarnings("unchecked")
    @Disabled
    // @Order(2)
    void testDispatchResponseBytes32Array() throws Exception {
        List list = new ArrayList<byte[]>();
        byte[] rep = new byte[32];
        System.arraycopy("query".getBytes(), 0, rep , 0, 5);
        list.add(rep);
        
        assertNotNull(dispatch.respondBytes32Array(id, list).send());
    }

    @SuppressWarnings("unchecked")
    @Disabled
    // @Order(3)
    void testDispatchResponseIntArray() throws Exception {
        List list = new ArrayList<BigInteger>();
        list.add(new BigInteger("1"));

        assertNotNull(dispatch.respondIntArray(id, list).send());
    }

    @Test
    // @Order(2)
    void testDispatchResponse1() throws Exception {
        assertNotNull(dispatch.respond(id, "reponse1").send());
    }

    @Disabled
    // @Order(5)
    void testDispatchResponse2() throws Exception {
        assertNotNull(dispatch.respond(id, "reponse1", "response2").send());
    }
   
    @Disabled
    // @Order(6)
    void testDispatchResponse3() throws Exception {
        assertNotNull(dispatch.respond(id, "response1", "response2", "response3").send());
    }

    @Disabled
    // @Order(7)
    void testDispatchResponse4() throws Exception {
        assertNotNull(dispatch.respond(id, "response1", "response2", "response3", "response4").send());
    }

    @Disabled
    // @Order(8)
    void testDispatchGetProvider() throws Exception {
        assertNotNull(dispatch.getProvider(id).send());
    }

    @Test
    // @Order(9)
    void testDispatchGetSubscriber() throws Exception {
        assertNotNull(dispatch.getSubscriber(id).send());
    }

    @Disabled
    // @Order(10)
    void testDispatchGetEndpoint() throws Exception {
        assertNotNull(dispatch.getEndpoint(id).send());
        // System.out.println("##### ENDPOINT #####: " + new String(dispatch.getEndpoint(new BigInteger("0")).send(), StandardCharsets.UTF_8));
    }

    @Test
    // @Order(11)
    void testDispatchGetStatus() throws Exception {
        assertNotNull(dispatch.getStatus(id).send());
    }

    @Disabled
    // @Order(12)
    void testDispatchGetCancel() throws Exception {
        assertNotNull(dispatch.getCancel(id).send());
    }

    @Disabled
    // @Order(13)
    void testDispatchGetUserQuery() throws Exception {
        assertNotNull(dispatch.getUserQuery(id).send());
    }

    @Test
    // @Order(14)
    void testDispatchGetSubscriberOnchain() throws Exception {
        assertNotNull(dispatch.getSubscriberOnchain(id).send());
        // System.out.println("##### subONCHAIN #####: " + dispatch.getSubscriberOnchain(new BigInteger("0")).send());
    }

    @Disabled
    void testDispatchCancelQuery() throws Exception {
        assertNotNull(dispatch.cancelQuery(id).send());
    }
}
