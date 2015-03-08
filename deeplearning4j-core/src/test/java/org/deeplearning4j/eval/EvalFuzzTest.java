package org.deeplearning4j.eval;

import static org.junit.Assert.*;

import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.util.FeatureUtil;

import java.util.Random;

/**
 * Created by agibsonccc on 12/22/14.
 */
public class EvalFuzzTest {

    @Test
    public void testEvalFuzz() {
        Random rand = new Random();
        rand.setSeed(123456789);
        int max = 7;
        int min = 3;

        int randomInt = rand.nextInt((max - min) + 1) + min;

        Evaluation eval = new Evaluation();
        INDArray trueOutcome = FeatureUtil.toOutcomeVector(0,randomInt);
        INDArray test = FeatureUtil.toOutcomeVector(0,randomInt);
        eval.eval(trueOutcome,test);
        assertEquals(1.0,eval.f1(),1e-1);
        assertEquals(1,eval.classCount(0));

        randomInt = rand.nextInt((max - min) + 1) + min;

        INDArray one = FeatureUtil.toOutcomeVector(1,randomInt);
        INDArray miss = FeatureUtil.toOutcomeVector(0,randomInt);
        eval.eval(one,miss);
        assertTrue(eval.f1() < 1);
        assertEquals(1,eval.classCount(0));
        assertEquals(1,eval.classCount(1));

        assertEquals(2.0,eval.positive(),1e-1);
        assertEquals(1.0,eval.negative(),1e-1);



    }


}
