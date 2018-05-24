package com.oscarok.discretedistributions.distributions;

import java.lang.*;
import java.math.BigDecimal;

public class Negative {
    private int numberTry;
    private int k;
    private double success;
    private double failure;

    public Negative(int numberTry, int k, double success) {
        this.numberTry = numberTry;
        this.k = k;
        this.success = success;
        this.failure = 1 - success;
    }

    public BigDecimal distribution() {
        return Math.pow(success, k).multiply(Math.pow(failure, numberTry - k)).multiply(BigDecimal.valueOf(Math.comb(numberTry - 1, k - 1).intValue()));
    }
}
