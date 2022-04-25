import Engine.Physics.*;
import Engine.Rendering.*;
import Engine.Rendering.Renderer;

import javax.swing.*;

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
        CharacterPhysics testPhysics = new CharacterPhysics(mass, xInitialPosition, yInitialPosition, xInitialVelocity, yInitialVelocity, xInitialAcceleration, yInitialAcceleration, 0, 0);
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
        CharacterPhysics character2 = new CharacterPhysics(10, 500, 100, -1, 0, 0, 0, 100, 100);

        character.setxPos(200);
        character.setGravity(0.5);
        character.setyPos(100);
        character.setxSize(100);
        character.setySize(100);
        character.setxVelocity(1);
        character.setyVelocity(-2);
        character.setyAcceleration(-5);
        //character.setGravity(1);
        character.setXTerminalVelocity(10);
        character.setYTerminalVelocity(10);

        CollisionHandler collisionDetection = new CollisionHandler();

        Renderer testRender = new Renderer(1200, 720, "Physics Test");

        testRender.Window();
        JFrame frame = testRender.getFrame();

        imageRendering image = new imageRendering(frame);


        image.addImage("TestAsset.png", character.getxPos(), character.getyPos(), character.getxSize(), character.getySize());
        image.addImage("TestAsset.png", character.getxPos()+300, character.getyPos(), character.getxSize(), character.getySize());


        for (int i = 0; i < 100; i++){

            image.addImage("TestAsset.png", character.getxPos(), character.getyPos(), character.getxSize(), character.getySize());
            image.addImage("TestAsset.png", character2.getxPos(), character2.getyPos(), character2.getxSize(), character2.getySize());

            try {
                sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            testRender.clearScreen();
            character.Update();
            character2.Update();

            collisionDetection.findCollisions();

        }

        image.addImage("TestAsset.png", character.getxPos(), character.getyPos(), character.getxSize(), character.getySize());
        image.addImage("TestAsset.png", character2.getxPos(), character2.getyPos(), character2.getxSize(), character2.getySize());

    }
}
