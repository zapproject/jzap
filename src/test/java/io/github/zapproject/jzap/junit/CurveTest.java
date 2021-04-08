package io.github.zapproject.jzap.junit;

import io.github.zapproject.jzap.wrappers.Curve;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CurveTest {
    static Curve curve;
    static List<BigInteger> curv;

    @BeforeAll
    static void init() {
        curv = new ArrayList<BigInteger>();
        curv.add(BigInteger.valueOf(2));
        curv.add(BigInteger.valueOf(1));
        curv.add(BigInteger.valueOf(2));
        curv.add(BigInteger.valueOf(100000));
        curve = new Curve(curv);
    }

    @Test
    void getPriceTest() {
        assertEquals(3, curve.getPrice(BigInteger.valueOf(1)));
    }

    @Test
    void getZapRequiredTest() {
        assertEquals(5, curve.getZapRequired(2, 1));
    }

    @Test
    void toStringTest() {
        assertEquals("[2, 1, 2, 100000]", curve.valuesToString().toString());
        assertEquals("x^0+2*x^1; limit = 100000", Curve.curveToString(curv));
    }
}
