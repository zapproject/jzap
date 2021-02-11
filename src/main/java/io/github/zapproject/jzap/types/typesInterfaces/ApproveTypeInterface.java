package io.github.zapproject.jzap.types.typesInterfaces;

import java.math.BigInteger;

public interface ApproveTypeInterface extends DefaultTxInterface {
    String providerString;
    BigInteger zapNum;
}
