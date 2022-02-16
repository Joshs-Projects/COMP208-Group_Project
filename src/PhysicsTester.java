import Engine.Physics.CharacterPhysics;

public class PhysicsTester {

    private double xInitialPosition;
    private double yInitialPosition;
    private double xInitialVelocity;
    private double yInitialVelocity;
    private double xInitialAcceleration;
    private double yInitialAcceleration;
    private double mass;

    private void PrintAllPropertiesOfClassPhysics(CharacterPhysics testPhysics){
        System.out.println("Position X: " + testPhysics.getPositionX());
        System.out.println("Position Y: " + testPhysics.getPositionY());
        System.out.println("Velocity X: " + testPhysics.getCurrentXVelocity());
        System.out.println("Velocity Y: " + testPhysics.getCurrentYVelocity());
        System.out.println("Acceleration X: " + testPhysics.getCurrentXAcceleration());
        System.out.println("Acceleration Y: " + testPhysics.getCurrentYAcceleration());
        System.out.println("Mass: " + testPhysics.getCurrentMass());

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
        PhysicsTester test = new PhysicsTester();
        test.PhysicsTester();

    }
}
