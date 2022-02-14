package Engine.Physics;

public class Physics {
    protected double gravity;

    protected int timePerTick = 1;

    protected double xPos;
    protected double yPos;

    protected double xSize;
    protected double ySize;

    public Physics(){

    }

    public Physics(double gravity, int timePerTick){
        this.gravity = gravity;
        this.timePerTick = timePerTick;
    }

    //Create a setter and getter for xSize and ySize as well as move the xPos and yPos setter and getter from CharacterPhysics

}
