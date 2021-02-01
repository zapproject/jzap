package io.github.zapproject.types;

import java.math.BigInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.github.zapproject.types.DefaultTx;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class TypesTest {

	@Test
	@DisplayName("Testing DefaultTx Type") // @displayName is not working properly
	void defaultTxTest() {
		DefaultTx defaultx1 = new DefaultTx("test address", new BigInteger("10"), new BigInteger("1"));
		assertEquals(defaultx1.getGas().getClass().getSimpleName(), "BigInteger", "Number class type for gas is not matching");
	}

}
