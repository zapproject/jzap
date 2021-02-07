package io.github.zapproject.jzap.Curve.src;

import java.util.*;

public class Curve {
    public List<Integer> values;
    public int max = 0;
    
    public Curve(List<Integer> curve) {
        this.values = curve;
        this.checkValidity();
    }

    private void checkValidity() {
        int prevEnd = 1;
        int index = 0;

        while(index < this.values.size()) {
            int len = this.values.size();
            if (len <= 0) {
                throw new ArithmeticException("Invalid curve length");
            }

            int endIndex = index + len + 1;
            if (endIndex >= this.values.size()) {
                throw new ArithmeticException("Piece is out of bounds");
            }

            int end = this.values.get(endIndex);
            if (end <= prevEnd) {
                throw new ArithmeticException("Piece domains are overlapping");
            }

            prevEnd = end;
            index += len + 2;
        }
        this.max = prevEnd;
    }
}
