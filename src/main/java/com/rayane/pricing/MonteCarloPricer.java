package com.rayane.pricing;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.random.RandomGenerator;


public class MonteCarloPricer{


    public double callPrice(PricingContext pc, int nSimulations, RandomGenerator rng){

        if (nSimulations <= 0){
            throw new IllegalArgumentException("nSimulations must be greater than zero.");
        }

        if (pc == null){
            throw new NullPointerException("...");
        }

        if (rng == null){
            throw new NullPointerException("...");
        }

        double r = pc.r();
        double K = pc.K();
        double S0 = pc.S0();
        double sigma = pc.sigma();
        double T = pc.T();


            

        NormalDistribution normalDistribution = new NormalDistribution(rng,0.0,1.0);
        double sum = 0;
        for (int i = 0; i < nSimulations; i++) {
            double z = normalDistribution.sample();
            double ST = S0 * Math.exp((r - 0.5 * sigma * sigma)*T + sigma * Math.sqrt(T) * z);
            double payoff = Math.max(ST-K, 0.0);
            sum += payoff;
        }

        double res = Math.exp(-r * T) * sum/nSimulations;

        if (res <=0 || !Double.isFinite(res)){
            throw new IllegalStateException("Call price must be greather than zero and finite value.");
        }
        return res;

    }
    
}
