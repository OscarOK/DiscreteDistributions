package com.oscarok.discretedistributions.distributions;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class Math {

    public static BigDecimal pow(double base, int exponent) {
        return BigDecimal.valueOf(base).pow(exponent);
    }

    public static BigInteger comb(int n, int r) {
        if (n < r) {
            return null;
        }
        return fact(n).divide(fact(r).multiply(fact(n - r)));
    }

    public static BigInteger fact(int n) {
        BigInteger number = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            number = number.multiply(BigInteger.valueOf(i));
        }

        return number;
    }
}
