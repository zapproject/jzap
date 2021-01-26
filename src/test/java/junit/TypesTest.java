import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.math.BigDecimal;

class TypesTest {
	@Test
	@DisplayName("Testing DefaultTx Type") // @displayName is not working properly
	void defaultTxTest() {
		DefaultTx defaultx1 = new DefaultTx("test address".getBytes(), new BigDecimal(10), new BigDecimal(0.1));
		assertEquals(defaultx1.getGas().getClass().getSimpleName(), "BigDecimal", "Number class type for gas is not matching");
	}
}
