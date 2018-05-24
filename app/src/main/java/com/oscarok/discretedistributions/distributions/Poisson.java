package com.oscarok.discretedistributions.distributions;

import java.lang.*;

public class Poisson {

    double x,t, lamnda;

    public Poisson(double x, double t, double lamnda) {
        this.x = x;
        this.t = t;
        this.lamnda = lamnda;
    }

    public double resu(){
        double u = lamnda*t;
        double resu = (java.lang.Math.exp(-u)* java.lang.Math.pow(u,x))/(factorial(x));
        return resu;
    }

    public double factorial(double x){
        double fact=1;
        for(int i=1; i<=x;i++){
            fact*=i;
        }
        return fact;

    }
}