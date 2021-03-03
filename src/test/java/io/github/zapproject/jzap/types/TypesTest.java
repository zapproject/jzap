package io.github.zapproject.jzap.types;

import java.math.BigInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class TypesTest extends DefaultTx{
	TypesTest () {
		super();
	}

	@Test
	@DisplayName("Testing DefaultTx Type") // @displayName is not working properly
	void defaultTxTest() {
		TypesTest test = new TypesTest();
		test.gas = new BigInteger("1");
		assertEquals(test.gas.getClass().getSimpleName(), "BigInteger");
	}


}
