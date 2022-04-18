package Engine.Physics;

public class CharacterPhysics extends Movement {
    private double forcePushedInX;
    private double forcePushedInY;

    //Used to slow down body to zero velocity
    private boolean slowingXToZero;
    private int ticksXToZero;
    private boolean slowingYToZero;
    private int ticksYToZero;


    /**
     * Updates the internal attributes to the new x and y position.
     */
    public void UpdatePosition() {
        CalculateDistance();
    }

    /**
     * Updates the internal attributes for the x and y velocities.
     */
    public void UpdateVelocities() {
        CalculateXVelocity();
        CalculateYVelocity();
    }

    //How do we want to do this, instantaneous pushing or continuous pushing. Keep pushing until told to stop or push once and done.
    /**
     * Uses newtonian equation (F = ma) to update the acceleration in x.
     * The force applied is continuous.
     *
     * @param push a double that applies the force to push
     */
    public void PushInX(double push){
        this.forcePushedInX = push;
        //F = ma
        //Therefore a = F/M
        xAcceleration = xAcceleration + (forcePushedInX / mass);

    }

    /**
     * Uses newtonian equation (F = ma) to update the acceleration in y.
     * The force applied is continuous.
     *
     * @param push a double that applies the force to push
     */
    public void PushInY(double push){
        this.forcePushedInY = push;
        //F = ma
        //Therefore a = F/M
        yAcceleration = yAcceleration + (forcePushedInY / mass);

    }

    /**
     * Changes the acceleration in the x direction to slow the x velocity to 0 in a set amount of time.
     * This only changes the initial acceleration and is vulnerable to changing elsewhere
     *
     * @param ticksToStop an integer representing the amount of time to act upon
     */
    public void slowXToZero(int ticksToStop){
        xAcceleration = xVelocity / ticksToStop;
        slowingXToZero = true;
        ticksXToZero = ticksToStop;
    }

    /**
     * Changes the acceleration in the y direction to slow the y velocity to 0 in a set amount of time.
     * This only changes the initial acceleration and is vulnerable to changing elsewhere
     *
     * @param ticksToStop an integer representing the amount of time to act upon
     */
    public void slowYToZero(int ticksToStop){
        this.yAcceleration = this.yVelocity / ticksToStop;
        slowingYToZero = true;
        ticksYToZero = ticksToStop;
    }

    /**
     * A default constructor
     */
    public CharacterPhysics() {

    }

    //Create a new constructor that only requires mass, and the position of the object initialising other attributes to 0

    /**
     * A constructor that initialises the mass, position, velocity and acceleration of the object
     *
     * @param mass a double representing the characters mass
     * @param xInitialPosition a double representing the initial x position
     * @param yInitialPosition a double representing the initial y position
     * @param xInitialVelocity a double representing the initial x velocity
     * @param yInitialVelocity a double representing the initial y velocity
     * @param xInitialAcceleration a double representing the initial x acceleration
     * @param yInitialAcceleration a double representing the initial y acceleration
     */
    public CharacterPhysics(double mass, double xInitialPosition, double yInitialPosition, double xInitialVelocity, double yInitialVelocity, double xInitialAcceleration, double yInitialAcceleration, double xSize, double ySize){
        this.mass = mass;
        this.xPos = xInitialPosition;
        this.yPos = yInitialPosition;
        this.xVelocity = xInitialVelocity;
        this.yVelocity = yInitialVelocity;
        this.xAcceleration = xInitialAcceleration;
        this.yAcceleration = yInitialAcceleration;
        this.slowingXToZero = false;
        this.slowingYToZero = false;
        this.xSize = xSize;
        this.ySize = ySize;

        //Add setting of the object size using xSize and ySize. These are protected attributes of the Physics class
    }

    /**
     * Updates the current properties of the object.
     * Considers whether the object is being slowed to zero.
     * Calls the UpdatePosition() and UpdateVelocities() method
     */
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

}
