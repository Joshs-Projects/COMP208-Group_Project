package Physics;

import Engine.Physics.Movement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovementTest {
    private static Movement movementTestingObject;

    Queue<Double> xVelocity = new LinkedList<>();
    Queue<Double> yVelocity = new LinkedList<>();
    Queue<Double> xAcceleration = new LinkedList<>();
    Queue<Double> yAcceleration = new LinkedList<>();
    Queue<Double> mass = new LinkedList<>();

    //Test Data Generation
    int numberOfTests = 10;
    double velocityMin = -10000, velocityMax = 10000;
    double accelerationMin = -10000, accelerationMax = 10000;
    double massMin = 0, massMax = 10000; //-ve mass for opposing gravity?


    @BeforeAll
    public static void setup(){
        movementTestingObject = new Movement(2,4,2,4,1);
    }

    @BeforeEach
    public void generateTestData(){
        Random r = new Random();
        for (int i = 0; i < numberOfTests; i++) {
            xVelocity.add(velocityMin + (velocityMax - velocityMin) * r.nextDouble());
            yVelocity.add(velocityMin + (velocityMax - velocityMin) * r.nextDouble());
            xAcceleration.add(accelerationMin + (accelerationMax - accelerationMax) * r.nextDouble());
            yAcceleration.add(accelerationMin + (accelerationMax - accelerationMin) * r.nextDouble());
            mass.add(massMin + (massMax - massMin) * r.nextDouble());
        }
    }

    @Test
    public void testTheConstructor(){
        assertEquals(2, movementTestingObject.getxVelocity());
        assertEquals(4, movementTestingObject.getyVelocity());
        assertEquals(2, movementTestingObject.getxAcceleration());
        assertEquals(4, movementTestingObject.getyAcceleration());
        assertEquals(1, movementTestingObject.getMass());
    }

    @Test
    public void testTheSettersAndGetters(){
        double xVelocityTestValue;
        double yVelocityTestValue;
        double xAccelerationTestValue;
        double yAccelerationTestValue;
        double massTestValue;
        for (int i = 0; i < numberOfTests; i++) {
            xVelocityTestValue = xVelocity.remove();
            yVelocityTestValue = yVelocity.remove();
            xAccelerationTestValue = xAcceleration.remove();
            yAccelerationTestValue = yAcceleration.remove();
            massTestValue = mass.remove();

            movementTestingObject.setxVelocity(xVelocityTestValue);
            movementTestingObject.setyVelocity(yVelocityTestValue);
            movementTestingObject.setxAcceleration(xAccelerationTestValue);
            movementTestingObject.setyAcceleration(yAccelerationTestValue);
            movementTestingObject.setMass(massTestValue);

            assertEquals(xVelocityTestValue, movementTestingObject.getxVelocity());
            assertEquals(yVelocityTestValue, movementTestingObject.getyVelocity());
            assertEquals(xAccelerationTestValue, movementTestingObject.getxAcceleration());
            assertEquals(yAccelerationTestValue, movementTestingObject.getyAcceleration());
            assertEquals(massTestValue, movementTestingObject.getMass());
        }
    }


}