package io.github.zapproject.jzap;

import java.math.BigInteger;
import java.util.List;


class ResponseArgs {
    public BigInteger queryID;
    public List<String> responseParams;
    public boolean dynamic;
}

class cancelQuery {
    public BigInteger queryId;
}

class QueryArgs {
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
