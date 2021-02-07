package io.github.zapproject.jzap.Curve;

import org.junit.jupiter.api.Test;
import io.github.zapproject.jzap.Curve.src.Curve;
import java.util.*;

public class curveTest {

    Curve testCurve;
    List<Integer> testValues = new ArrayList<Integer>();

    @Test
    void init() {
        testCurve = new Curve(testValues);
    }
    
}
