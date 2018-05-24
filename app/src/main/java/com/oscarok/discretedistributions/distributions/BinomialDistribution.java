package com.oscarok.discretedistributions.distributions;

import java.lang.*;

public class BinomialDistribution {
    private int n;
    private int x;
    private double p;

    public BinomialDistribution(int x, int n, double p) {
        this.n = n;
        this.x = x;
        this.p = p;
    }

    public double getProb() {
        double prob;

        int comb = combination(this.n, this.x);

        prob = comb * java.lang.Math.pow(p, x) * java.lang.Math.pow(1 - p, n - x);

        return prob;
    }

    private int combination(int n, int k) {
        if (k == 0) {
            return 1;
        }
        if (k == n) {
            return 1;
        }
        return permutation(n) / (permutation(k) * permutation(n - k));
    }

    private int permutation(int i) {
        if (i == 1) {
            return 1;
        }
        return i * permutation(i - 1);
    }
}