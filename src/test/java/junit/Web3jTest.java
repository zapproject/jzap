package zapprotocol.jzap;

import org.web3j.protocol.Web3j;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

class Web3jTest {	
	@Test
	void mockWeb3j() {
		Web3j web3j = mock(Web3j.class);
		
		/*
		 * Nothing to do yet as there are no compiled contracts. 
		 * Otherwise continue as such:
		 * 
		 * when(web3j.functions(dummy params)).thenReturn(RETURN_VALUE);
		 * Contract contract = Contract.deploy(web3js);
		 */
	}
}