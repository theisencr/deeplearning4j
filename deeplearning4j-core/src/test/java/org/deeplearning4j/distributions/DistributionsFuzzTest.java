package org.deeplearning4j.distributions;

import org.apache.commons.math3.distribution.RealDistribution;
import org.apache.commons.math3.random.MersenneTwister;
import org.apache.commons.math3.random.RandomGenerator;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Random;
import java.lang.Math;

/**
 * @author Adam Gibson
 */
public class DistributionsFuzzTest {

    private RandomGenerator rng = new MersenneTwister(123);
    private static final Logger log = LoggerFactory.getLogger(DistributionsTest.class);
    @Test
    public void uniformFuzzTest() {

        Random rand = new Random();
        rand.setSeed(123456789);

        int max = 100;
        int min = 10;
        int randomInt = rand.nextInt((max - min) + 1) + min;
        max = 8;
        min = 2;
        int randomInt2 = rand.nextInt((max - min) + 1) + min;


        RealDistribution dist = Distributions.uniform(rng,randomInt2);
        int numSamples = randomInt;
        double avg = 0.0;
        for(int i = 0;i < numSamples; i++)
            avg += dist.sample();

       avg /= numSamples;

        log.info("Avg " + avg);


    }

}
