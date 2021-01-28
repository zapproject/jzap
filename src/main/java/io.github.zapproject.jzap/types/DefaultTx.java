package io.github.zapproject.types;
import java.math.BigInteger;

public class DefaultTx {
	private String from;
	private BigInteger gas;
	private BigInteger gasPrice;	
	
	/**
	 * Class constructor
	 * @param from The string representing the from address
	 * @param gas The BigInteger amount of gas
	 * @param gasPrice The BigInteger gas price
	 */
	public DefaultTx(String from, BigInteger gas, BigInteger gasPrice) {
		this.from = from;
		this.gas = gas;
		this.gasPrice = gasPrice;
	}
	
	/**
	 * Getter for from address
	 * @return A string representation of from address
	 */
	public String getFrom() {
		return from;
	}
	
	/**
	 * Setter for from address
	 * @param from The String representation for from address
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	
	/**
	 * Getter for gas amount
	 * @return A BigInteger representation of gas amount
	 */
	public BigInteger getGas() {
		return gas;
	}
	
	/**
	 * Setter for gas amount
	 * @param gas The BigInteger gas amount.
	 */
	public void setGas(BigInteger gas) {
		this.gas = gas;
	}
	
	/**
	 * Getter for gas price
	 * @return A BigInteger representation of gas price
	 */
	public BigInteger getGasPrice() {
		return gasPrice;
	}
	
	/**
	 * Setter for gas price
	 * @param gasPrice The BigInteger of gas price
	 */
	public void setGasPrice(BigInteger gasPrice) {
		this.gasPrice = gasPrice;
	}
}
