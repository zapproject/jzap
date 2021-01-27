import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.Web3j;
import static org.mockito.Mockito.mock;

class Web3jTest {	
	protected Web3j mockWeb;

	@Test
	@DisplayName("Initializing mock web3j")
	void init() {
		mockWeb = mock(Web3j.class);
	}
}
