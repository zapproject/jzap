package io.github.zapproject.jzap.types.typesInterfaces;

import java.math.BigInteger;

public interface SubscribeTypeInterface extends DefaultTxInterface {
    String provider;
    String endpoint;
    BigInteger dots;
    String[] endpointParams;
}
