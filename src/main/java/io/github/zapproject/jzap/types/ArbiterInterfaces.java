package io.github.zapproject.jzap.types;

import java.math.BigInteger;
import java.util.List;


class SubscriptionInit extends DefaultTx {
	String provider;
	byte[] endpoint;
	List<byte[]> endpointParams;
	BigInteger blocks;
	BigInteger pubKey;
}


 class SubscriptionEnd extends DefaultTx {
	String address;
    String subscriber;
    byte[] endpoint;
}


class SubscriptionType {
	String provider;
	String subscriber;
	byte[] endpoint;
}


class SubscriptionParams extends DefaultTx {
	String receiver;
	byte[] endpoint;
	List<byte[]> params;
}


class DataPurchaseEvent extends Filter {
	BigInteger publicKey;
	BigInteger amount;
	byte[] endpoint;
	List<byte[]> params;
}


class SubscriptionEndEvent extends Filter {
	String terminator;
}


class ParamsPassedEvent {
	String sender;
	String receiver;
	byte[] endpoint;
	List<byte[]> params;
}