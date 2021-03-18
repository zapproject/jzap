package io.github.zapproject.jzap;

import java.math.BigInteger;
import java.util.List;


public class SubscribeType {
    public String provider;
    public byte[] endpoint;
    public BigInteger dots;
    public List<byte[]> endpointParams;
}