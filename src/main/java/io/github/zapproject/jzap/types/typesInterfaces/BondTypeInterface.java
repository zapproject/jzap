package io.github.zapproject.jzap.types.typesInterfaces;

import java.math.BigInteger;

public interface BondTypeInterface extends DefaultTxInterface {
    String subscriber;
    String provider;
    String endpoint;
    BigInteger dots;
}
