package com.rayane.pricing;

public record PricingContext(
    double r,
    double K, 
    double S0, 
    double sigma, 
    double T
    ){

    public PricingContext {

        if (S0 <= 0 || !Double.isFinite(S0) ){
            throw new IllegalArgumentException("S0 must be greater than 0 and finite value.");
        }

        if (K <=0 || !Double.isFinite(K)){
            throw new IllegalArgumentException("K must be greater than 0 and finite value.");
        }

        if (sigma <=0 || !Double.isFinite(sigma)){
            throw new IllegalArgumentException("sigma must be greater than 0 and finite value.");
        }

        if (T <=0 || !Double.isFinite(T)){
            throw new IllegalArgumentException("T must be greater than 0 and finite value.");
        }

    }
}