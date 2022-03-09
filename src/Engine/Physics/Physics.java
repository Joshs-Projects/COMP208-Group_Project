package Engine.Physics;

public class Physics {
    protected double gravity;

    protected int timePerTick = 1;

    protected double xPos;
    protected double yPos;

    protected double xSize;
    protected double ySize;

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }

    public int getTimePerTick() {
        return timePerTick;
    }

    public void setTimePerTick(int timePerTick) {
        this.timePerTick = timePerTick;
    }

    public double getxPos() {
        return xPos;
    }

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    public double getxSize() {
        return xSize;
    }

    public void setxSize(double xSize) {
        this.xSize = xSize;
    }

    public double getySize() {
        return ySize;
    }

    public void setySize(double ySize) {
        this.ySize = ySize;
    }

    public Physics(){

    }

    public Physics(double gravity, int timePerTick){
        this.gravity = gravity;
        this.timePerTick = timePerTick;
    }

    //Create a setter and getter for xSize and ySize as well as move the xPos and yPos setter and getter from CharacterPhysics

}
