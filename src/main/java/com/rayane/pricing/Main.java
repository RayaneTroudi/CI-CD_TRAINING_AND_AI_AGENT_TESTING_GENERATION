package com.rayane.pricing;

import org.apache.commons.math3.random.MersenneTwister;
import org.apache.commons.math3.random.RandomGenerator;


public class Main {
    public static void main(String[] args) {

        PricingContext pc = new PricingContext(0.00f,100.0f,90.0f,0.2f,1.0f);

        // Pricing using close formula of BS
        RandomGenerator rng = new MersenneTwister(42L);
        BlackScholesPricer bsp = new BlackScholesPricer();
        double price_bsp = bsp.callPrice(pc);
        System.out.println("Price using BS Pricer = " + price_bsp);

        // Pricing using montecarlo simulation
        MonteCarloPricer mcp = new MonteCarloPricer();
        double price_mcp = mcp.callPrice(pc, 1000, rng);
        System.out.println("Price using MC Pricer = " + price_mcp);

    }
}