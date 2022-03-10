package Test.Physics;

//import Engine.Physics.Physics;
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
    int i_xSizeRangeMin = 0, i_xSizeMax = 40000;
    int i_ySizeRangeMin = 0, i_ySizeMax = 40000;
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
        int i_xTestValue;
        int i_yTestValue;
        int i_xSizeValue;
        int i_ySizeValue;
        double d_testValue;
        for (int i = 0; i < numberOfTests; i++) {
            i_testValue = testTimePerTickValues.remove();
            d_testValue = testGravityValues.remove();
            i_xTestValue = testXCoord.remove();
            i_yTestValue = testYCoord.remove();
            i_xSizeValue = testXSize.remove();
            i_ySizeValue = testYSize.remove();

            physicsTestingObject.setTimePerTick(i_testValue);
            physicsTestingObject.setGravity(d_testValue);
            physicsTestingObject.setxPos(i_xTestValue);
            physicsTestingObject.setyPos(i_yTestValue);
            physicsTestingObject.setxSize(i_xSizeValue);
            physicsTestingObject.setySize(i_ySizeValue);

            assertEquals(i_testValue, physicsTestingObject.getTimePerTick());
            assertEquals(d_testValue, physicsTestingObject.getGravity());
            assertEquals(i_xTestValue, physicsTestingObject.getxPos());
            assertEquals(i_yTestValue, physicsTestingObject.getyPos());
            assertEquals(i_xSizeValue, physicsTestingObject.getxSize());
            assertEquals(i_ySizeValue, physicsTestingObject.getySize());
        }
    }
}