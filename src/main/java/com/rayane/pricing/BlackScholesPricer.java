package com.rayane.pricing;
import org.apache.commons.math3.distribution.NormalDistribution;

public class BlackScholesPricer {

    public double callPrice(PricingContext pc){


        if (pc == null){
            throw new NullPointerException("...");
        }
        
        double r = pc.r();
        double K = pc.K();
        double S0 = pc.S0();
        double sigma = pc.sigma();
        double T = pc.T();

        
        NormalDistribution normalDistribution = new NormalDistribution();

        double d1 = (Math.log(S0/K) + (r + 0.5 * sigma * sigma) * T) / (sigma * Math.sqrt(T));
        double d2 = d1 - sigma * Math.sqrt(T);
        double res = S0 * normalDistribution.cumulativeProbability(d1) - K * Math.exp(-r * T) * normalDistribution.cumulativeProbability(d2);

        if (res <=0 || !Double.isFinite(res)){
            throw new IllegalStateException("Call price must be greather than zero and finite value.");
        }
        return res;
    }

}
