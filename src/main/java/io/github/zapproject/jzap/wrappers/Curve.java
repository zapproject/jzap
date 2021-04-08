package io.github.zapproject.jzap.wrappers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class Curve {
    public List<BigInteger> values;
    public BigInteger max = BigInteger.valueOf(0);
    
    public Curve(List<BigInteger> curve) {
        this.values = curve;
        this.checkValidity();
    }

    private void checkValidity() {
        BigInteger prevEnd = BigInteger.valueOf(1);
        int index = 0;

        while(index < this.values.size()) {
            int len = this.values.get(index).intValue();
            if (len <= 0) {
                throw new ArithmeticException("Invalid curve length");
            }

            int endIndex = index + len + 1;
            if (endIndex >= this.values.size()) {
                throw new ArithmeticException("Piece is out of bounds");
            }

            BigInteger end = this.values.get(endIndex);
            if (end.intValue() <= prevEnd.intValue()) {
                throw new ArithmeticException("Piece domains are overlapping");
            }

            prevEnd = end;
            index += len + 2;
        }
        this.max = prevEnd;
    }

     /**
     * Gets the price of the nth dot. e.g. the price of a single dot to a curve with no dots issued would be calculated at n=1.
     * @param   total_x Where the new dot will be the nth dot to be bonded.
     * @returns Returns the price (in Zap) of the nth dot.
     */
    public int getPrice(BigInteger total_x) {
        if (total_x.intValue() <= 0 || total_x.intValue() > this.max.intValue()) {
            throw new ArithmeticException("Invalid curve supply position");
        }
        
        if (this.values.size() == 0) {
            throw new ArithmeticException("Curve is not initialized");
        }

        int index = 0;
        while (index < this.values.size()) {
            int len = this.values.get(index).intValue();
            int end = this.values.get(index+len+1).intValue();

            if (total_x.intValue() > end) {
                index += len + 2;
                continue;
            }

            int sum = 0;
            for(int i = 0; i<len;i++) {
                int coeff = this.values.get(index+i+1).intValue();
                sum += coeff * Math.pow(total_x.intValue(), i);
            }

            return sum;
        }

        return -1;
    }

    // n dots starting at the ath dot
    public int getZapRequired(int a, int n) {
        int sum = 0;
        for(int i=a;i<a+n;i++) {
            sum += this.getPrice(BigInteger.valueOf(i));
        }
        return sum;
    }

    // public void convertToBNArrays() {
    //     this.values.stream().map(number -> {
    //         BigInteger num = new BigInteger(Integer.toString(number));
    //         return num;
    //     });
    // }

    public List<String> valuesToString() {
        List<String> myList = new ArrayList<String>();
        this.values.forEach(n -> myList.add(n.toString()));
        return myList;
    }

    public static String curveToString(List<BigInteger> values) {
        List<List<BigInteger>> items = Curve.splitCurveToTerms(values);
        List<String> stringItems = new ArrayList<String>();

        items.stream().map(term -> 
            Curve.termToString(term)
        ).forEach(stringItems::add);

        return String.join(" & ", stringItems);
    }

    private static List<List<BigInteger>> splitCurveToTerms(List<BigInteger> curve) {
        List<List<BigInteger>> res = new ArrayList<List<BigInteger>>();

        if (curve.size() <= 0) {
            return res;
        }

        int startIndex = 0;
        int currentLength = curve.get(0).intValue();
        int endIndex = currentLength + 2;
        if (endIndex >= curve.size())
            endIndex = curve.size();

        while(startIndex < curve.size()) {
            res.add(curve.subList(startIndex, endIndex));
            if (endIndex >= curve.size())
                return res;
            startIndex += 2;
            currentLength = curve.get(endIndex).intValue();
            endIndex = startIndex + currentLength + 2;
        }
        
        return res;
    }

    public static String termToString(List<BigInteger> term) {
        int limit = term.get(term.size() - 1).intValue();
        List<String> parts = new ArrayList<String>();

        for(int i =1; i <= term.get(0).intValue(); i++) {
            if(term.get(i).intValue() == 0) {
                continue;
            }

            if(term.get(i).intValue() == 1) {
                parts.add("x^" + (i-1));
            } else {
                parts.add(term.get(i) + "*" + "x^" + (i-1));
            } 
        }

        return String.join("+", parts) + "; limit = " + limit;
    }
}