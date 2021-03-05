package io.github.zapproject.jzap;

import java.math.BigInteger;
import java.util.List;


class ResponseArgs extends DefaultTx {
    public BigInteger queryID;
    public List<BigInteger> responseParams;
    public boolean dynamic;
}

class cancelQuery extends DefaultTx {
    public BigInteger queryId;
}

class QueryArgs extends DefaultTx {
    public String provider;
    public String query;
    public byte[] endpoint;
    public List<byte[]> endpointParams;
    public boolean onchainProvider;
    public boolean onchainSubscriber;
}

class OffchainResponse {
    public BigInteger id;
    public String subscriber;
    public String provider;
    public List<String> response;
    public String response1;
    public String response2;
    public String response3;
    public String response4;
}
