package Engine.Physics;

public class Floor {
    private double rateOfSlowDown;
    private boolean passableWhenMovingUp;
    private boolean passableWhenMovingDown;

    private int xPos;
    private int yPos;

    private int xSize;
    private int ySize;


    public double getRateOfSlowDown() {
        return rateOfSlowDown;
    }

    public void setRateOfSlowDown(double rateOfSlowDown) {
        this.rateOfSlowDown = rateOfSlowDown;
    }

    public boolean getPassableWhenMovingUp() {
        return passableWhenMovingUp;
    }

    public void setPassableWhenMovingUp(boolean passableWhenMovingUp) {
        this.passableWhenMovingUp = passableWhenMovingUp;
    }

    public boolean getPassableWhenMovingDown() {
        return passableWhenMovingDown;
    }

    public void setPassableWhenMovingDown(boolean passableWhenMovingDown) {
        this.passableWhenMovingDown = passableWhenMovingDown;
    }

    public int getFloorXDimension(){
        return xPos;
    }

    public int getFloorYDimension(){
        return yPos;
    }

    public int getFloorXSize(){
        return xSize;
    }

    public int getFloorYSize(){
        return ySize;
    }

    public Floor() {

    }

    public Floor(double rateOfSlowDown, boolean passableWhenMovingUp, boolean passableWhenMovingDown){
        this.rateOfSlowDown = rateOfSlowDown;
        this.passableWhenMovingUp = passableWhenMovingUp;
        this.passableWhenMovingDown = passableWhenMovingDown;
    }
}