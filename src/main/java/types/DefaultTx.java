import java.math.BigDecimal;

public class DefaultTx {
	// byte[20] vs. org.we3j.abi.dataypes.generated.Bytes32
	private byte[] from;
	// BigDecimal is recommended for currency in docs - else Number is viable
	private BigDecimal gas;
	private BigDecimal gasPrice;	
	
	public DefaultTx(byte[] from, BigDecimal gas, BigDecimal gasPrice) {
		this.from = from;
		this.gas = gas;
		this.gasPrice = gasPrice;
	}
	
	public byte[] getFrom() {
		return from;
	}
	
	public void setFrom(byte[] from) {
		this.from = from;
	}
	
	public BigDecimal getGas() {
		return gas;
	}
	
	public void setGas(BigDecimal gas) {
		this.gas = gas;
	}
	
	public BigDecimal getGasPrice() {
		return gasPrice;
	}
	
	public void setGasPrice(BigDecimal gasPrice) {
		this.gasPrice = gasPrice;
	}
}
