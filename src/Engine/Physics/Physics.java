package Engine.Physics;

/**
 * This class defines overall attributes common across all if not most attributes
 *
 * @author Joshua Dowlman
 */
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
    public int getxPos() {
        return (int) xPos;
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
    public int getyPos() {
        return (int) yPos;
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
    public int getxSize() {
        return (int) xSize;
    }

    /**
     * Sets the xSize attribute
     *
     * @param xSize A double representing the horizontal position
     */
    public void setxSize(double xSize) {
        this.xSize = xSize;
    }

    /**
     * Gets the ySize attribute
     *
     * @return double of ySize
     */
    public int getySize() {
        return (int) ySize;
    }

    /**
     * Sets the ySize attribute
     *
     * @param ySize A double representing the horizontal position
     */
    public void setySize(double ySize) {
        this.ySize = ySize;
    }

    /**
     * A blank constructor
     */
    public Physics(){

    }

    /**
     * A constructor that sets the gravity and timePerTick for the object.
     *
     * @param gravity A double representing the strength of gravity acting on that object.
     * @param timePerTick An int to represent how much time has passed between updates.
     */
    public Physics(double gravity, int timePerTick){
        this.gravity = gravity;
        this.timePerTick = timePerTick;
    }
}
