package io.github.zapproject.jzap.types;

import java.math.BigInteger;

interface InitProvider extends DefaultTx {
    public void setPublicKey (String public_key);
    public void setTitle (String title);
}

interface InitCurve extends DefaultTx {
    public void setEndpoint (String endpoint);
    public void setTerm (Number[] term);
    public void SetAddress (byte[] address);
}

interface InitDotToken extends DefaultTx {
    public void setSymbol (String symbol);
}

interface UnsubscribeListen extends DefaultTx {
    public void setSubscriber (byte[] provider);
    public void setTerminator (byte[] terminator);
    public void setFromBlock (BigInteger fromBlock);
}

interface ListenQuery extends DefaultTx {
    public void setQueryId (String queryId);
    public void setSubscriber (byte[] subscriber);
    public void setFromBlock (BigInteger fromBlock);
}

interface Respond extends DefaultTx {
    public void setQueryId (String queryId);
    public void setResponseParams(String[] responseParams);
    public void setDynamic (boolean dynamic);
}

interface SetProviderParams extends DefaultTx {
    public void setKey (String key);
    public void setValue (String value);
}

interface SetProviderTitle extends DefaultTx {
    public void setTitle (String title);
}

interface EndpointMethods extends DefaultTx {
    public void setEndpoint (String endpoint);
}