package io.github.zapproject.jzap.types.ProviderTypes;

import java.math.BigInteger;
import java.util.List;


public class Response {
    public BigInteger queryId;
    public List<BigInteger> responseParams;
    public boolean dynamic;
}