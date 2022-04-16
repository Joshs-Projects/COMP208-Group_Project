import Engine.Physics.*;
import Engine.Rendering.*;

import static java.lang.Thread.sleep;

public class PhysicsTester {

    private double xInitialPosition;
    private double yInitialPosition;
    private double xInitialVelocity;
    private double yInitialVelocity;
    private double xInitialAcceleration;
    private double yInitialAcceleration;
    private double mass;

    private void PrintAllPropertiesOfClassPhysics(CharacterPhysics testPhysics){
        System.out.println("Position X: " + testPhysics.getxPos());
        System.out.println("Position Y: " + testPhysics.getyPos());
        System.out.println("Velocity X: " + testPhysics.getxVelocity());
        System.out.println("Velocity Y: " + testPhysics.getyVelocity());
        System.out.println("Acceleration X: " + testPhysics.getxAcceleration());
        System.out.println("Acceleration Y: " + testPhysics.getyAcceleration());
        System.out.println("Mass: " + testPhysics.getMass());

        System.out.println("---------------------------------------------------------");
    }

    public void PhysicsTester(){
        this.xInitialPosition = 5;
        this.yInitialPosition = 7;
        this.xInitialVelocity = 0;
        this.yInitialVelocity = 3;
        this.xInitialAcceleration = 0;
        this.yInitialAcceleration = 0;
        this.mass = 10;
        CharacterPhysics testPhysics = new CharacterPhysics(mass, xInitialPosition, yInitialPosition, xInitialVelocity, yInitialVelocity, xInitialAcceleration, yInitialAcceleration);
        PrintAllPropertiesOfClassPhysics(testPhysics);

        testPhysics.PushInX(10);
        PrintAllPropertiesOfClassPhysics(testPhysics);

        testPhysics.Update();
        PrintAllPropertiesOfClassPhysics(testPhysics);

        testPhysics.PushInY(7);
        PrintAllPropertiesOfClassPhysics(testPhysics);

        testPhysics.Update();
        PrintAllPropertiesOfClassPhysics(testPhysics);

        testPhysics.slowXToZero(3);
        PrintAllPropertiesOfClassPhysics(testPhysics);

        testPhysics.Update();
        PrintAllPropertiesOfClassPhysics(testPhysics);

        //Update this file to run some more indepth testing

        //Create some JUnit tests.


    }

    public static void main(String args[]) {
        //PhysicsTester testPhysics = new PhysicsTester();
        //testPhysics.PhysicsTester();

        CharacterPhysics character = new CharacterPhysics();
        character.setxPos(1000);
        character.setyPos(1000);
        character.setxSize(100);
        character.setySize(100);
        Renderer testRender = new Renderer(1200, 720, "Phyiscs Test");

        testRender.Window();
        testRender.addImage("TestAsset.png", character.getxPos(), character.getyPos(), character.getxSize(), character.getySize());

        /*for (int i = 0; i < 100; i++){

            testRender.addImage("TestAsset.png", character.getxPos(), character.getyPos(), character.getxSize(), character.getySize());
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            testRender.clearScreen();
            character.Update();

        }*/

        testRender.addImage("TestAsset.png", character.getxPos(), character.getyPos(), character.getxSize(), character.getySize());


    }
}
