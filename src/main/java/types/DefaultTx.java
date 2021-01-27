package types;
import java.math.BigInteger;

public class DefaultTx {
	private String from;
	private BigInteger gas;
	private BigInteger gasPrice;	
	
	public DefaultTx(String from, BigInteger gas, BigInteger gasPrice) {
		this.from = from;
		this.gas = gas;
		this.gasPrice = gasPrice;
	}
	
	public String getFrom() {
		return from;
	}
	
	public void setFrom(String from) {
		this.from = from;
	}
	
	public BigInteger getGas() {
		return gas;
	}
	
	public void setGas(BigInteger gas) {
		this.gas = gas;
	}
	
	public BigInteger getGasPrice() {
		return gasPrice;
	}
	
	public void setGasPrice(BigInteger gasPrice) {
		this.gasPrice = gasPrice;
	}
}
