package io.github.zapproject.jzap.types;

import java.math.BigInteger;

interface InitProvider extends DefaultTx {
    //setters and getters for InitProvider interface
    public void setPublicKey (String public_key);
    public void setTitle (String title);

    public String getPublicKey();
    public String getTitle();
}

interface InitCurve extends DefaultTx {
    //setters and getters for InitCurve interface
    public void setEndpoint (String endpoint);
    public void setTerm (BigInteger[] term);
    public void setAddress (byte[] address);

    public String getEndpoint();
    public BigInteger[] getTerm();
    public byte[] getAddress();
}

interface InitDotToken extends DefaultTx {
    //setter and getter for InitDotToken interface
    public void setSymbol (String symbol);
    
    public String getSymbol();
}

interface UnsubscribeListen extends DefaultTx {
    //setters and getters for UnsubcribeListen interface
    public void setSubscriber (byte[] provider);
    public void setTerminator (byte[] terminator);
    public void setFromBlock (BigInteger fromBlock);

    public byte[] getSubscriber();
    public byte[] getTerminator();
    public BigInteger getFromBlock();
}

interface ListenQuery extends DefaultTx {
    //setters and getters for ListenQuery interface
    public void setQueryId (String queryId);
    public void setSubscriber (byte[] subscriber);
    public void setFromBlock (BigInteger fromBlock);

    public String getQueryId();
    public byte[] getSubcriber();
    public BigInteger getFromBlock();
}

interface Respond extends DefaultTx {
    //setters and getters for Respond interface
    public void setQueryId (String queryId);
    public void setResponseParams(String[] responseParams);
    public void setDynamic (boolean dynamic);

    public String getQueryId();
    public String[] getResponseParams();
    public boolean getDynamic();
}

interface SetProviderParams extends DefaultTx {
    //setters and getters for SetProviderParams interface
    public void setKey (String key);
    public void setValue (String value);

    public String getKey();
    public String getValue();
}

interface SetProviderTitle extends DefaultTx {
    //setter and getter for SetProviderTitle interface
    public void setTitle (String title);

    public String getTitle();
}

interface EndpointMethods extends DefaultTx {
    //setter and gettersfor EndpointMethods interface
    public void setEndpoint (String endpoint);

    public String getEndpoint();
}