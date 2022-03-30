package Engine.Physics;

public class Physics {
    protected double gravity;

    protected int timePerTick = 1;

    protected double xPos;
    protected double yPos;

    protected double xSize;
    protected double ySize;

    /**
     * Gets the gravity attribute
     *
     * @return double of gravity value
     */
    public double getGravity() {
        return gravity;
    }

    /**
     * Sets the gravity attribute.
     *
     * @param gravity A double representing the strength of gravity
     */
    public void setGravity(double gravity) {
        this.gravity = gravity;
    }

    /**
     * Gets the timePerTick attribute
     *
     * @return int of timePerTick
     */
    public int getTimePerTick() {
        return timePerTick;
    }

    /**
     * Sets the timePerTick attribute
     *
     * @param timePerTick An int representing the amount of time that will elapse per update
     */
    public void setTimePerTick(int timePerTick) {
        this.timePerTick = timePerTick;
    }

    /**
     * Gets the xPos attribute
     *
     * @return double of xPos
     */
    public double getxPos() {
        return xPos;
    }

    /**
     * Sets the xPos attribute
     *
     * @param xPos A double representing the horizontal position
     */
    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    /**
     * Gets the yPos attribute
     *
     * @return double of yPos
     */
    public double getyPos() {
        return yPos;
    }

    /**
     * Sets the yPos attribute
     *
     * @param yPos A double representing the horizontal position
     */
    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    /**
     * Gets the xSize attribute
     *
     * @return double of xSize
     */
    public double getxSize() {
        return xSize;
    }

    /**
     * Sets the xSize attribute
     *
     * @param xSize A double representing the horizontal position
     */
    public void setxSize(double xSize) {
        this.xSize = xSize;
    }

    public double getySize() {
        return ySize;
    }

    /**
     * Sets the ySize attribute
     *
     * @param ySize A double representing the horizontal position
     */
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
