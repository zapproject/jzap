package io.github.zapproject.jzap.wrappers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


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

    public int getPrice(int total_x) {
        if (total_x <= 0 || total_x > this.max) {
            throw new ArithmeticException("Invalid curve supply position");
        }
        
        if (this.values.size() == 0) {
            throw new ArithmeticException("Curve is now initialized");
        }

        int index = 0;
        while (index < this.values.size()) {
            int len = this.values.get(index);
            int end = this.values.get(index+len+1);

            if (total_x > end) {
                index += len + 2;
                continue;
            }

            int sum = 0;
            for(int i = 0; i<len;i++) {
                int coeff = this.values.get(index+i+1);
                sum += coeff * Math.pow(total_x, i);
            }

            return sum;
        }

        return -1;
    }

    public int getZapRequired(int a, int n) {
        int sum = 0;
        for(int i=0;i<a+n;i++) {
            sum += this.getPrice(i);
        }
        return sum;
    }

    public void convertToBNArrays() {
        this.values.stream().map(number -> {
            BigInteger num = new BigInteger(Integer.toString(number));
            return num;
        });
    }

    public List<String> valuesToString() {
        List<String> myList = new ArrayList<String>();
        this.values.forEach(n -> myList.add(Integer.toString(n)));
        return myList;
    }

    public static String curveToString(List<Integer> values) {
        List<List<Integer>> items = Curve.splitCurveToTerms(values);
        List<String> stringItems = new ArrayList<String>();

        items.stream().map(term -> {
            return stringItems.add(Curve.termToString(term));
        });

        return String.join(" & ", stringItems);
    }

    private static List<List<Integer>> splitCurveToTerms(List<Integer> curve) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (curve.size() <= 0) {
            return res;
        }

        int startIndex = 0;
        int currentLength = curve.get(0);
        int endIndex = currentLength + 2;

        while(startIndex < curve.size()) {
            res.add(curve.subList(startIndex, endIndex));
            startIndex += 2;
            currentLength = curve.get(endIndex);
            endIndex = startIndex + currentLength + 2;
        }

        return res;
    }

    public static String termToString(List<Integer> term) {
        int limit = term.get(term.size() - 1);
        List<String> parts = new ArrayList<String>();

        for(int i =1; i <= term.get(0); i++) {
            if(term.get(i) == 0) {
                continue;
            }

            if(term.get(i) == 1) {
                parts.add("x^" + (i-1));
            } else {
                parts.add(term.get(i) + "*" + "x^" + (i-1));
            } 
        }

        return String.join("+", parts) + "; limit = " + limit;
    }

    public static List<Integer> converToCurve(int end, String curve) {
        return new ArrayList();
    }

}