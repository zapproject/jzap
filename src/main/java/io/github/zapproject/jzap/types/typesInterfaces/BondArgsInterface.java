package io.github.zapproject.jzap.types.typesInterfaces;

import java.math.BigInteger;

public interface BondArgsInterface extends DefaultTxInterface {
    String provider;
    String endpoint;
    BigInteger dots;
}
