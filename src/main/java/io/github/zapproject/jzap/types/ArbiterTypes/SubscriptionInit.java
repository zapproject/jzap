package io.github.zapproject.jzap;

import java.math.BigInteger;
import java.util.List;


public class SubscriptionInit {
	public String provider;
	public byte[] endpoint;
	public List<byte[]> endpointParams;
	public BigInteger blocks;
	public BigInteger pubKey;
}