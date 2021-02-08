package io.github.zapproject.jzap.Curve;

import org.junit.jupiter.api.Test;
import io.github.zapproject.jzap.Curve.src.Curve;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

public class curveTest {

    Curve testCurve;
    List<Integer> testValues = new ArrayList<Integer>();

    @Test
    void init() {
        testCurve = new Curve(testValues);
        testValues.add(5);
        testValues.add(3);
        testValues.add(12);
        assertEquals(testCurve.values.size(), 3);
    }
    
}
