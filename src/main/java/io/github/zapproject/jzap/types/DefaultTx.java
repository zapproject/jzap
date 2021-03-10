package io.github.zapproject.jzap;

import org.web3j.crypto.Credentials;
import org.web3j.tx.gas.ContractGasProvider;


public abstract class DefaultTx {
	// public String from;
	// public BigInteger gas;
	// public BigInteger gasPrice;
	public Credentials credentials;
	public ContractGasProvider contractGasProvider;
}
