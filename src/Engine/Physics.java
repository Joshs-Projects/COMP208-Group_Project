package Engine;

public class Physics {

    //This determines how much time has passed between each physics update
    private int tickTimeElapsed = 1;

    private double mass;

    private double forcePushedInX;
    private double forcePushedInY;

    //Velocities +ve is up or right
    private double xVelocity;
    private double yVelocity;

    //Acceleration +ve is up or right
    private double xAcceleration;
    private double yAcceleration;

    //Distance
    private double xDistance;
    private double yDistance;

    //Position
    private double xPos;
    private double yPos;

    //Used to slow down body to zero velocity
    private boolean slowingXToZero;
    private int ticksXToZero;
    private boolean slowingYToZero;
    private int ticksYToZero;


    //Calculate Distance
    private void CalculateXDistance() {
        //distance = initialVelocity * time + (0.5 * acceleration * time^2)
        //distance = 0.5 * (initialVelocity + finalVelocity) * time //Often don't have final velocity
        //distance = (finalVelocity * time) - (0.5 * acceleration * time^2) //Often don't have final velocity
        xDistance = (xVelocity * tickTimeElapsed) + (0.5 * xAcceleration * (tickTimeElapsed * tickTimeElapsed));
    }

    private void CalculateYDistance() {
        //distance = initialVelocity * time + (0.5 * acceleration * time^2)
        //distance = 0.5 * (initialVelocity + finalVelocity) * time //Often don't have final velocity
        //distance = (finalVelocity * time) - (0.5 * acceleration * time^2) //Often don't have final velocity
        yDistance = (yVelocity * tickTimeElapsed) + (0.5 * yAcceleration * (tickTimeElapsed * tickTimeElapsed));
    }

    private void CalculateDistance() {
        CalculateXDistance();
        xPos = xPos + xDistance;
        CalculateYDistance();
        yPos = yPos + yDistance;
    }

    public void UpdatePosition() {
        CalculateDistance();

    }

    public void CalculateXVelocity() {
        xVelocity = xVelocity + (xAcceleration * tickTimeElapsed);
    }

    public void CalculateYVelocity() {
        yVelocity = yVelocity + (yAcceleration * tickTimeElapsed);
    }

    public void UpdateVelocities() {
        CalculateXVelocity();
        CalculateYVelocity();
    }

    //How do we want to do this, instantaneous pushing or continuous pushing. Keep pushing until told to stop or push once and done.
    public void PushInX(double push){
        this.forcePushedInX = push;
        //F = ma
        //Therefore a = F/M
        xAcceleration = xAcceleration + (forcePushedInX / mass);

    }

    public void PushInY(double push){
        this.forcePushedInY = push;
        //F = ma
        //Therefore a = F/M
        yAcceleration = yAcceleration + (forcePushedInY / mass);

    }

    public void slowXToZero(int ticksToStop){
        this.xAcceleration = this.xVelocity / ticksToStop;
        slowingXToZero = true;
        ticksXToZero = ticksToStop;
    }

    public void slowYToZero(int ticksToStop){
        this.yAcceleration = this.yVelocity / ticksToStop;
        slowingYToZero = true;
        ticksYToZero = ticksToStop;
    }

    //Constructor
    public Physics() {

    }

    public Physics(double mass, double xInitialPosition, double yInitialPosition, double xInitialVelocity, double yInitialVelocity, double xInitialAcceleration, double yInitialAcceleration){
        this.mass = mass;
        this.xPos = xInitialPosition;
        this.yPos = yInitialPosition;
        this.xVelocity = xInitialVelocity;
        this.yVelocity = yInitialVelocity;
        this.xAcceleration = xInitialAcceleration;
        this.yAcceleration = yInitialAcceleration;
        this.slowingXToZero = false;
        this.slowingYToZero = false;
    }

    public void Update(){
        if (slowingXToZero) {
            if (ticksXToZero == 1) {
                xAcceleration = 0;
                slowingXToZero = false;

            }
        }

        if (slowingYToZero) {
            if (ticksYToZero == 1) {
                yAcceleration = 0;
                slowingXToZero = false;

            }
        }

        //Must be done
        //Position -> Velocity
        //Otherwise the acceleration will be doubled because the velocity will increase and
        //then the position will be updated with the faster velocity and the acceleration
        UpdatePosition();

        UpdateVelocities();
    }

    public double getPositionX(){
        return this.xPos;
    }

    public double getPositionY(){
        return this.yPos;
    }

    public double getCurrentXAcceleration(){
        return this.xAcceleration;
    }

    public double getCurrentYAcceleration(){
        return this.yAcceleration;
    }

    public double getCurrentMass(){
        return this.mass;
    }

    public double getCurrentXVelocity(){
        return this.xVelocity;
    }

    public double getCurrentYVelocity() {
        return this.yVelocity;
    }

}
