package Engine.Physics;

public class Physics {
    protected double gravity;

    protected int timePerTick = 1;

    public Physics(){

    }

    public Physics(double gravity, int timePerTick){
        this.gravity = gravity;
        this.timePerTick = timePerTick;
    }
}
