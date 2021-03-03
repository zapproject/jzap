package io.github.zapproject.jzap.types;

import java.math.BigInteger;


abstract class Filter {
	BigInteger id;
	BigInteger fromBlock;
	BigInteger toBlock;
	String provider;
	String subscriber;
	String terminator;
	byte[] endpoint;
}
