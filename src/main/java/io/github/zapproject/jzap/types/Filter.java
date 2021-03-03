package io.github.zapproject.jzap.types;

import java.math.BigInteger;


abstract class Filter {
	public BigInteger id;
	public BigInteger fromBlock;
	public BigInteger toBlock;
	public String provider;
	public String subscriber;
	public String terminator;
	public byte[] endpoint;
}
