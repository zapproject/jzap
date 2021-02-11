package io.github.zapproject.jzap.types.typesInterfaces;

import java.math.BigInteger;

public interface DelegateBondArgsInterface extends DefaultTxInterface {
    String provider;
    String endpoint;
    BigInteger dots;
    String subscriber;
}
