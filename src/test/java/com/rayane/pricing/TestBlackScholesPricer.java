package com.rayane.pricing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestBlackScholesPricer {
    
    @Test
    public void TestZeroFreeRate() throws Exception{
        PricingContext pc = new PricingContext(0.0f, 100.0f, 90.0f, 0.2f, 1.0f);
        BlackScholesPricer bsp = new BlackScholesPricer();
        double p = bsp.callPrice(pc);
        
        assertEquals(3.58, p, 0.01);
    }
}
