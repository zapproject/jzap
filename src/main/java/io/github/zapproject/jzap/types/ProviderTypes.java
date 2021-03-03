package io.github.zapproject.jzap.types;

import java.math.BigInteger;
import java.util.List;


class InitProvider extends DefaultTx {
    public String publicKey;
    public byte[] title;
}

class InitCurve extends DefaultTx {
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

class Response extends DefaultTx {
    public BigInteger queryId;
    public List<BigInteger> responseParams;
    public boolean dynamic;
}

class SetProviderParams extends DefaultTx {
    public byte[] key;
    public byte[] value;
}

class SetProviderTitle extends DefaultTx {
    public byte[] title;
}

class EndpointMethods extends DefaultTx {
    public byte[] endpoint;
}
