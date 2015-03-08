package org.deeplearning4j.util;

import java.util.List;
import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import static org.junit.Assert.assertEquals;

import java.util.Random;
import java.lang.Math;

/**
 * Created by agibsonccc on 6/11/14.
 */
public class MovingWindowMatrixFuzzTest {

    @Test
    public void testMovingWindowFuzz() {
        Random rand = new Random();
        rand.setSeed(123456789);

        int max = 10;
        int min = 4;

        int randomInt = rand.nextInt((max - min) + 1) + min;
        int min = 2;
        int randomInt2 = rand.nextInt((max - min) + 1) + min;

        INDArray ones = Nd4j.ones(randomInt, randomInt);
        MovingWindowMatrix m = new MovingWindowMatrix(ones,randomInt2,randomInt2);
        List<INDArray> windows = m.windows();
        assertEquals(Math.max(randomInt,randomInt2),windows.size());


    }



}
