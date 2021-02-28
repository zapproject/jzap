package io.github.zapproject.jzap.types;

import java.math.BigInteger;

interface ResponseArgs extends DefaultTx {
    //setters and getters for ResponseArgs interface
    public void setQueryId (String queryId);
    public void setResponseParams (String[] responseParams);
    public void setDynamic (boolean dynamic);

    public String getQueryId();
    public String[] getResponseParams();
    public boolean getDynamic();
}

interface cancelQuery extends DefaultTx {
    //setter and getter for cancelQuery interface
    public void setQueryId (BigInteger queryId);

    public BigInteger getQueryId();
}

interface QueryArgs extends DefaultTx{
    //setters and getters for QueryArgs interface
    public void setProvider (byte[] provider);
    public void setEndpoint (String endpoing);
    public void setQuery (String query);
    public void setEndpointParams (String[] endpointParams);
    public void setOnchainProvider (boolean onchainProvider);
    public void setOnchainSubscriber (boolean onchainSubscriber);

    public byte[] getProvider();
    public String getEndpoint();
    public String getQuery();
    public String[] getEndpointParams();
    public boolean getOnchainProvider();
    public boolean getOnchainSubscriber();
}

interface OffchainResponse{
    //setters and getters for OffchainResponse interface
    public void setId (BigInteger id);
    public void setSubscriber (byte[] subscriber);
    public void setProvider (byte[] provider);
    public void setResponse (String[] response);
    public void setResponse1 (String response1);
    public void setResponse2 (String response2);
    public void setResponse3 (String response3);
    public void setResponse4 (String response4);

    public BigInteger getId();
    public byte[] getSubcriber();
    public byte[] getProvider();
    public String[] getResponse();
    public String getResponse1();
    public String getResponse2();
    public String getResponse3();
    public String getResponse4();
}