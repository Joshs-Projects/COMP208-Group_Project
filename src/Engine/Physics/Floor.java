package Engine.Physics;

public class Floor {
    private double rateOfSlowDown;
    private boolean passableWhenMovingUp;
    private boolean passableWhenMovingDown;


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

    public Floor() {

    }

    public Floor(double rateOfSlowDown, boolean passableWhenMovingUp, boolean passableWhenMovingDown){
        this.rateOfSlowDown = rateOfSlowDown;
        this.passableWhenMovingUp = passableWhenMovingUp;
        this.passableWhenMovingDown = passableWhenMovingDown;
    }
}