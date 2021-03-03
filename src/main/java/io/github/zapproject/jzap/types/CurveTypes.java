package io.github.zapproject.jzap.types;

import java.math.BigInteger;
import java.util.List;


class CurveType {
    public List<BigInteger> curve;
}

class CurveTerm {
    public BigInteger fn;
    public BigInteger power;
    public BigInteger coef;
}
