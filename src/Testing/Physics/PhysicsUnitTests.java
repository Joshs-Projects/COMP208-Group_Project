package Physics;

import Engine.Physics.Physics;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class PhysicsTest {
    Queue<Double> testGravityValues = new LinkedList<Double>();
    Queue<Integer> testTimePerTickValues = new LinkedList<Integer>();
    Queue<Integer> testXCoord = new LinkedList<Integer>();
    Queue<Integer> testYCoord = new LinkedList<Integer>();
    Queue<Integer> testXSize = new LinkedList<Integer>();
    Queue<Integer> testYSize = new LinkedList<Integer>();
    double d_rangeMin = -100, d_rangeMax = 100;
    int i_rangeMin = -100, i_rangeMax = 100;
    int i_xRangeMin = 0, i_xRangeMax = 40000;
    int i_yRangeMin = 0, i_yRangeMax = 40000;
    int numberOfTests = 10;

    private static Physics physicsTestingObject;

    @BeforeAll
    //Make sure all methods are static for this
    public static void setup(){
        physicsTestingObject = new Physics(9.8, 1);
    }

    @BeforeEach
    public void generateTestData() {
        Random r = new Random();
        for (int i = 0; i < numberOfTests; i++) {
            testGravityValues.add(d_rangeMin + (d_rangeMax - d_rangeMin) * r.nextDouble());
            testTimePerTickValues.add(i_rangeMin + (i_rangeMax - i_rangeMin) * r.nextInt());
            testXCoord.add(i_rangeMin + (i_xRangeMax - i_xRangeMin) * r.nextInt());
            testYCoord.add(i_rangeMin + (i_yRangeMax - i_yRangeMin) * r.nextInt());
            testXSize.add(i_rangeMin + (i_xRangeMax - i_xRangeMin) * r.nextInt());
            testYSize.add(i_rangeMin + (i_yRangeMax - i_yRangeMin) * r.nextInt());
        }
    }


    @Test
    public void testTheConstructor(){
        assertEquals(9.8, physicsTestingObject.getGravity());
        assertEquals(1, physicsTestingObject.getTimePerTick());
    }

    @Test
    public void testTheSettersAndGetters(){
        int i_testValue;
        int i_xPosTestValue;
        int i_yPosTestValue;
        int i_xSizeTestValue;
        int i_ySizeTestValue;
        double d_testValue;
        for (int i = 0; i < numberOfTests; i++) {
            i_testValue = testTimePerTickValues.remove();
            d_testValue = testGravityValues.remove();
            i_xPosTestValue = testXCoord.remove();
            i_yPosTestValue = testYCoord.remove();
            i_xSizeTestValue = testXSize.remove();
            i_ySizeTestValue = testYSize.remove();


            physicsTestingObject.setTimePerTick(i_testValue);
            physicsTestingObject.setGravity(d_testValue);
            physicsTestingObject.setxPos(i_xPosTestValue);
            physicsTestingObject.setyPos(i_yPosTestValue);
            physicsTestingObject.setxSize(i_xSizeTestValue);
            physicsTestingObject.setySize(i_ySizeTestValue);

            assertEquals(i_testValue, physicsTestingObject.getTimePerTick());
            assertEquals(d_testValue, physicsTestingObject.getGravity());
            assertEquals(i_xPosTestValue, physicsTestingObject.getxPos());
            assertEquals(i_yPosTestValue, physicsTestingObject.getyPos());
            assertEquals(i_xSizeTestValue, physicsTestingObject.getxSize());
            assertEquals(i_ySizeTestValue, physicsTestingObject.getySize());
        }
    }
}