package io.github.zapproject.jzap.types.DispatchTypes;

import java.math.BigInteger;
import java.util.List;


public class ResponseArgs {
    public BigInteger queryID;
    public List<String> responseParams;
    public boolean dynamic;
}