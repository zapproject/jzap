package io.github.zapproject.jzap.types.DispatchTypes;

import java.util.List;


public class QueryArgs {
    public String provider;
    public String query;
    public byte[] endpoint;
    public List<byte[]> endpointParams;
    public boolean onchainProvider;
    public boolean onchainSubscriber;
}