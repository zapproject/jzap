package io.github.zapproject.jzap.types.typesInterfaces;

import java.math.BigInteger;

public interface FilterInterface {
    BigInteger fromBlock;
    BigInteger toBlock;
    String provider;
    String subscriber;
    String terminator;
    String endpoint;
    BigInteger id;
}
