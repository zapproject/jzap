package io.github.zapproject.jzap;

import java.math.BigInteger;
import java.util.List;


class SubscriptionInit extends DefaultTx {
	public String provider;
	public byte[] endpoint;
	public List<byte[]> endpointParams;
	public BigInteger blocks;
	public BigInteger pubKey;
}


 class SubscriptionEnd extends DefaultTx {
	public String address;
    public String subscriber;
    public byte[] endpoint;
}


class SubscriptionType {
	public String provider;
	public String subscriber;
	public byte[] endpoint;
}


class SubscriptionParams extends DefaultTx {
	public String receiver;
	public byte[] endpoint;
	public List<byte[]> params;
}


class DataPurchaseEvent extends Filter {
	public BigInteger publicKey;
	public BigInteger amount;
	public byte[] endpoint;
	public List<byte[]> params;
}


class SubscriptionEndEvent extends Filter {
	public String terminator;
}


class ParamsPassedEvent {
	public String sender;
	public String receiver;
	public byte[] endpoint;
	public List<byte[]> params;
}