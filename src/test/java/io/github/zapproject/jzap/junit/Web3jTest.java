package io.github.zapproject.jzap.types;

import org.junit.jupiter.api.Test;
import org.web3j.protocol.Web3j;
import static org.mockito.Mockito.mock;

class Web3jTest {	
	protected Web3j mockWeb;

	@Test
	void testWeb3j() {
		mockWeb = mock(Web3j.class);
	}
}
