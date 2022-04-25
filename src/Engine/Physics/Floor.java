package Engine.Physics;

public class Floor {
    private double rateOfSlowDown;
    private boolean passableWhenMovingUp;
    private boolean passableWhenMovingDown;

    private int xPos;
    private int yPos;

    private int xSize;
    private int ySize;


    /**
     * Gets the rateOfSlowdown attribute
     *
     * @return double of rateOfSlowDown
     */
    public double getRateOfSlowDown() {
        return rateOfSlowDown;
    }

    /**
     * Sets the rateOfSlowdown attribute
     *
     * @param rateOfSlowDown a double of rateOfSlowDown
     */
    public void setRateOfSlowDown(double rateOfSlowDown) {
        this.rateOfSlowDown = rateOfSlowDown;
    }

    /**
     * Gets the passableWhenMovingUp attribute
     *
     * @return boolean of passableWhenMovingUp
     */
    public boolean getPassableWhenMovingUp() {
        return passableWhenMovingUp;
    }

    /**
     * Sets the passableWhenMovingUp attribute
     *
     * @param passableWhenMovingUp a boolean of passableWhenMovingUp
     */
    public void setPassableWhenMovingUp(boolean passableWhenMovingUp) {
        this.passableWhenMovingUp = passableWhenMovingUp;
    }

    /**
     * Gets the passableWhenMovingDown attribute
     *
     * @return boolean of passableWhenMovingDown
     */
    public boolean getPassableWhenMovingDown() {
        return passableWhenMovingDown;
    }

    /**
     * Sets the passableWhenMovingDown attribute
     *
     * @param passableWhenMovingDown a boolean of passableWhenMovingDown
     */
    public void setPassableWhenMovingDown(boolean passableWhenMovingDown) {
        this.passableWhenMovingDown = passableWhenMovingDown;
    }

    /**
     * Gets the xPos of the floor
     *
     * @return an int xPos
     */
    public int getFloorXDimension(){
        return xPos;
    }

    /**
     * Gets the yPos of the floor
     *
     * @return an int yPos
     */
    public int getFloorYDimension(){
        return yPos;
    }

    /**
     * Gets the xSize of the floor
     *
     * @return an int xSize
     */
    public int getFloorXSize(){
        return xSize;
    }

    /**
     * Gets the ySize of the floor
     *
     * @return an int ySize
     */
    public int getFloorYSize(){
        return ySize;
    }

    /**
     * A blank constructor
     */
    public Floor() {

    }


    /**
     * A constructor that sets the rateOfSlowDown, passableWhenMovingUp and passableWhenMovingDown
     *
     * @param rateOfSlowDown A double that represents how much an object slows down
     * @param passableWhenMovingUp A boolean to dictate if an object can move up through the floor
     * @param passableWhenMovingDown A boolean to dictate if an object can move down through the floor
     */
    public Floor(double rateOfSlowDown, boolean passableWhenMovingUp, boolean passableWhenMovingDown){
        this.rateOfSlowDown = rateOfSlowDown;
        this.passableWhenMovingUp = passableWhenMovingUp;
        this.passableWhenMovingDown = passableWhenMovingDown;
    }
}