package io.github.zapproject.jzap;

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
