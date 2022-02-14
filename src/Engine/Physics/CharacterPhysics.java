package Engine.Physics;

public class CharacterPhysics extends Movement {
    private double mass;

    private double forcePushedInX;
    private double forcePushedInY;

    //Used to slow down body to zero velocity
    private boolean slowingXToZero;
    private int ticksXToZero;
    private boolean slowingYToZero;
    private int ticksYToZero;


    public void UpdatePosition() {
        CalculateDistance();
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
        xAcceleration = xVelocity / ticksToStop;
        slowingXToZero = true;
        ticksXToZero = ticksToStop;
    }

    public void slowYToZero(int ticksToStop){
        this.yAcceleration = this.yVelocity / ticksToStop;
        slowingYToZero = true;
        ticksYToZero = ticksToStop;
    }

    //Constructor
    public CharacterPhysics() {

    }

    public CharacterPhysics(double mass, double xInitialPosition, double yInitialPosition, double xInitialVelocity, double yInitialVelocity, double xInitialAcceleration, double yInitialAcceleration){
        this.mass = mass;
        this.xPos = xInitialPosition;
        this.yPos = yInitialPosition;
        this.xVelocity = xInitialVelocity;
        this.yVelocity = yInitialVelocity;
        this.xAcceleration = xInitialAcceleration;
        this.yAcceleration = yInitialAcceleration;
        this.slowingXToZero = false;
        this.slowingYToZero = false;

        //Add setting of the object size using xSize and ySize. These are protected attributes of the Physics class
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

    //These need moving to the Movement or Physics class
    //We also need Setters and Getters of any attributes that might want to be changed without doing so through "Conventional" Physics.
    //To allow the developer to use the mechanics however they would like for example move a person very quickly

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
