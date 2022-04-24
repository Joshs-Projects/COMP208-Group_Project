package Engine.Physics;

import java.util.ArrayList;

//The shapes the hitbox may have
enum Shapes {
    Rectangle,
    Triangle,
    Circle
}

public class Movement extends Physics{
    protected double xVelocity;
    protected double yVelocity;

    protected double xTerminalVelocity;
    protected double yTerminalVelocity;

    protected double xAcceleration;
    protected double yAcceleration;

    protected double mass;

    private Shapes shape;

    private double radius;

    //An array that contains 3 other arrays with each array providing information about a line
    private ArrayList<ArrayList<Double>> triangleCollisionInfo;

    /**
     * Gets the xVelocity attribute
     *
     * @return double xVelocity
     */
    public double getxVelocity() {
        return xVelocity;
    }

    /**
     * Sets the xVelocity attribute
     *
     * @param xVelocity a double representing the
     */
    public void setxVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

    /**
     * Gets the yVelocity attribute
     *
     * @return double yVelocity
     */
    public double getyVelocity() {
        return yVelocity;
    }

    /**
     * Sets the yVelocity attribute
     *
     * @param yVelocity a double representing the
     */
    public void setyVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }

    /**
     * Gets the xAcceleration attribute
     *
     * @return double xAcceleration
     */
    public double getxAcceleration() {
        return xAcceleration;
    }

    /**
     * Sets the xAcceleration attribute
     *
     * @param xAcceleration a double representing the
     */
    public void setxAcceleration(double xAcceleration) {
        this.xAcceleration = xAcceleration;
    }

    /**
     * Gets the yAcceleration attribute
     *
     * @return double yAcceleration
     */
    public double getyAcceleration() {
        return yAcceleration;
    }

    /**
     * Sets the yAcceleration attribute
     *
     * @param yAcceleration a double representing the
     */
    public void setyAcceleration(double yAcceleration) {
        this.yAcceleration = yAcceleration;
    }

    /**
     * Gets the mass attribute
     *
     * @return double mass
     */
    public double getMass() {
        return mass;
    }

    /**
     * Sets the mass attribute
     *
     * @param mass a double representing the
     */
    public void setMass(double mass) {
        this.mass = mass;
    }

    /**
     * Gets the xTerminalVelocity attribute
     *
     * @return double xTerminalVelocity
     */
    public double getXTerminalVelocity() {
        return xTerminalVelocity;
    }

    /**
     * Sets the xTerminalVelocity attribute
     *
     * @param xTerminalVelocity a double representing the
     */
    public void setXTerminalVelocity(double xTerminalVelocity) {
        this.xTerminalVelocity = xTerminalVelocity;
    }

    /**
     * Gets the yTerminalVelocity attribute
     *
     * @return double yTerminalVelocity
     */
    public double getYTerminalVelocity() {
        return yTerminalVelocity;
    }

    /**
     * Sets the yTerminalVelocity attribute
     *
     * @param yTerminalVelocity a double representing the
     */
    public void setYTerminalVelocity(double yTerminalVelocity) {
        this.yTerminalVelocity = yTerminalVelocity;
    }

    /**
     * Calculates the velocity in the horizontal direction
     */
    protected void CalculateXVelocity() {
        xVelocity = xVelocity + (xAcceleration * timePerTick);
        //Gives a terminal velocity to the object
        if (xVelocity > xTerminalVelocity){
            xVelocity = xTerminalVelocity;
        }
    }

    /**
     * Calculates the velocity in the vertical direction
     */
    protected void CalculateYVelocity() {
        yVelocity = yVelocity + ((yAcceleration + gravity) * timePerTick);
        yAcceleration = yAcceleration + gravity;
        //Gives a terminal velocity to the object
        if (yVelocity > yTerminalVelocity){
            yVelocity = yTerminalVelocity;
        }
    }

    /**
     * Calculates the distance moved in the horizontal direction
     *
     * @return double representing the distance change in the horizontal direction
     */
    protected double CalculateXDistance() {
        return (xVelocity * timePerTick) + (0.5 * xAcceleration * (timePerTick * timePerTick));
    }

    /**
     * Calculates the distance moved in the vertical direction
     *
     * @return double representing the distance change in the vertical direction
     */
    protected double CalculateYDistance() {
       return (yVelocity * timePerTick) + (0.5 * yAcceleration + gravity * (timePerTick * timePerTick));
    }

    /**
     * Changes the xPos and yPos with the change in distance taken into account
     */
    protected void CalculateDistance() {
        xPos = xPos + CalculateXDistance();
        //CalculateYDistance();
        yPos = yPos + CalculateYDistance();
    }

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

    public void UpdateMovement(){
        //Must be done
        //Position -> Velocity
        //Otherwise the acceleration will be doubled because the velocity will increase and
        //then the position will be updated with the faster velocity and the acceleration
        UpdatePosition();

        UpdateVelocities();
    }

    //x is the position horizontally
    //y is the position vertically
    //r is the radius of the circle

    /**
     * Sets the hitbox type to a circle and takes in any additional parameters required to compute the hitbox
     *
     * @param radius A double representing the radius of the circle
     */
    public void setHitBoxCircle(double radius){
        this.shape = Shapes.Circle;
        this.radius = radius;
    }

    /**
     * Sets the hitbox type to a rectangle
     */
    public void setHitBoxRectangle(){
        this.shape = Shapes.Rectangle;
    }

    /**
     * Sets the hitbox type to a triangle and takes in additional parameters required to compute the hitbox
     *
     * @param line1 An arraylist of double where the first element is y, the second is m (the gradient) and the third is x
     * @param line2 An arraylist of double where the first element is y, the second is m (the gradient) and the third is x
     * @param line3 An arraylist of double where the first element is y, the second is m (the gradient) and the third is x
     */
    public void setHitBoxTriangle(ArrayList<Double> line1, ArrayList<Double> line2, ArrayList<Double> line3){
        this.shape = Shapes.Triangle;
        triangleCollisionInfo.add(line1);
        triangleCollisionInfo.add(line2);
        triangleCollisionInfo.add(line3);

    }

    /**
     * Gets the shape attribute
     *
     * @return Shape representing the hitbox shape
     */
    public Shapes getHitBoxShape(){
        return this.shape;
    }

    public ArrayList<ArrayList<Double>> getRangeOfCoordinatesForCollision(){
        //First ArrayList is for coordinates greaterThan or equal to
        //Second ArrayList if for coordinates greaterThan
        //Third ArrayList is for coordinates lessThan or equal to
        //Fourth ArrayList if for coordinates lessThan
        ArrayList<ArrayList<Double>> collisionCoordinates = new ArrayList<>(4);

        if (this.shape == Shapes.Rectangle){
            ArrayList<Double> greaterThanEqualTo = new ArrayList<>();
            greaterThanEqualTo.add(this.xPos);
            greaterThanEqualTo.add(this.yPos);
            ArrayList<Double> lessThanEqualTo = new ArrayList<>();
            lessThanEqualTo.add(this.xPos+this.xSize);
            lessThanEqualTo.add(this.yPos+this.ySize);
            collisionCoordinates.set(0, greaterThanEqualTo);
            collisionCoordinates.set(2, lessThanEqualTo);
        }

        return collisionCoordinates;

    }

    //Used when only one collision
    /*public void Collision(Movement objectCollidedWith){
        //Handle the collision with the single object
    }*/

    /**
     * Called when a collision occurs and can be overridden to allow for different behaviour
     *
     * @param objectsCollidedWith An arraylist with every object that it has collided with
     */
    public void Collision(ArrayList<Movement> objectsCollidedWith){
        //Handle the collision with objects
    }

    /**
     * A blank constructor
     */
    public Movement(){

    }

    /**
     * A constructor that sets the xVelocity, yVelocity, xAcceleration, yAcceleration and mass
     *
     * @param xVelocity A double that represents the horizontal velocity
     * @param yVelocity A double that represents the vertical velocity
     * @param xAcceleration A double that represents the horizontal acceleration
     * @param yAcceleration A double that represents the vertical acceleration
     * @param mass A double the represents the mass
     */
    public Movement(double xVelocity, double yVelocity, double xAcceleration, double yAcceleration, double mass){
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.xAcceleration = xAcceleration;
        this.yAcceleration = yAcceleration;
        this.mass = mass;
    }

}
