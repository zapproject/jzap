package io.github.zapproject.jzap.types;

import java.math.BigInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class TypesTest extends DefaultTx{
	TypesTest () {
		super("test address", new BigInteger("10"), new BigInteger("1"));
	}

	@Test
	@DisplayName("Testing DefaultTx Type") // @displayName is not working properly
	void defaultTxTest() {
		TypesTest test = new TypesTest();
		assertEquals(test.getGas().getClass().getSimpleName(), "BigInteger", "Number class type for gas is not matching");
	}

}
