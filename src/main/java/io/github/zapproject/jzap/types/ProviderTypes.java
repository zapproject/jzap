package io.github.zapproject.jzap;

import java.math.BigInteger;
import java.util.List;


class InitProvider {
    public BigInteger publicKey;
    public byte[] title;
}

class InitCurve {
    public byte[] endpoint;
    public List<BigInteger> term;
    public String broker;
}

class InitDotTokenCurve extends InitCurve {
    public String symbol;
}

class UnsubscribeListen {
    public String subscriber;
    public String terminator;
    public BigInteger fromBlock;
}

class ListenQuery {
    public BigInteger queryId;
    public String subscriber;
    public BigInteger fromBlock;
}

class Response {
    public BigInteger queryId;
    public List<BigInteger> responseParams;
    public boolean dynamic;
}

class SetProviderParams {
    public byte[] key;
    public byte[] value;
}

class SetProviderTitle {
    public byte[] title;
}

class EndpointMethods {
    public byte[] endpoint;
}
