package com.oscarok.discretedistributions.distributions;

import java.lang.*;

public class Multinomial {
    private int[] Xn;
    private double[] Pn;

    public Multinomial(int[] Xn, double[] Pn){
        this.Pn = Pn;
        this.Xn = Xn;
    }

    public double getProbabilty() {
        return calculateProb();
    }

    private double calculateProb(){
        int n = 0;
        for(int i = 0; i < this.Xn.length; i++){
            n += Xn[i];
        }
        long div = 1;
        for(int i = 0; i < this.Xn.length; i++){
            div *= fact(Xn[i]);
        }
        double mult = 1;
        for(int i = 0; i < this.Pn.length; i++){
            mult *= java.lang.Math.pow(Pn[i], (double)Xn[i]);
        }
        return (fact(n) / div) * mult;

    }

    private long fact(int N){
        long multi = 1;
        for (int i = 1; i <= N; i++) {
            multi = multi * i;
        }
        return multi;
    }

}
