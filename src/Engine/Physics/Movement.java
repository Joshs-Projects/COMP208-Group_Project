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

    protected double xAcceleration;
    protected double yAcceleration;

    protected double mass;

    private Shapes shape;

    private double radius;

    //An array that contains 3 other arrays with each array providing information about a line
    private ArrayList<ArrayList<Integer>> triangleCollisionInfo;

    public double getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

    public double getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }

    public double getxAcceleration() {
        return xAcceleration;
    }

    public void setxAcceleration(double xAcceleration) {
        this.xAcceleration = xAcceleration;
    }

    public double getyAcceleration() {
        return yAcceleration;
    }

    public void setyAcceleration(double yAcceleration) {
        this.yAcceleration = yAcceleration;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    protected void CalculateXVelocity() {
        xVelocity = xVelocity + (xAcceleration * timePerTick);
    }

    protected void CalculateYVelocity() {
        yVelocity = yVelocity + ((yAcceleration + gravity) * timePerTick);
    }

    //Calculate Distance moved
    protected double CalculateXDistance() {
        return (xVelocity * timePerTick) + (0.5 * xAcceleration * (timePerTick * timePerTick));
    }

    protected double CalculateYDistance() {
       return (yVelocity * timePerTick) + (0.5 * yAcceleration + gravity * (timePerTick * timePerTick));
    }

    protected void CalculateDistance() {
        xPos = xPos + CalculateXDistance();
        //CalculateYDistance();
        yPos = yPos + CalculateYDistance();
    }

    //x is the position horizontally
    //y is the position vertically
    //r is the radius of the circle
    public void setHitBoxCircle(int radius){
        this.shape = Shapes.Circle;
        this.radius = radius;
    }

    public void setHitBoxRectangle(){
        this.shape = Shapes.Rectangle;
    }

    public void setHitBoxTriangle(ArrayList<Integer> line1, ArrayList<Integer> line2, ArrayList<Integer> line3){
        this.shape = Shapes.Triangle;
        triangleCollisionInfo.add(line1);
        triangleCollisionInfo.add(line2);
        triangleCollisionInfo.add(line3);

    }

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
    public void Collision(Movement objectCollidedWith){
        //Handle the collision with the single object
    }

    //Used when colliding with multiple objects
    public void Collision(ArrayList<Movement> objectsCollidedWith){
        //Handle the collision with multiple objects
    }

    //Required so the programmer can workout which objects are colliding
    //Make sure to always give the floor collision first
    //Return null if no collision with floor?
    public ArrayList<Movement> GetCollisions(){
        ArrayList<Movement> allCollisionsWithThis = new ArrayList<>();

        return allCollisionsWithThis;
    }

    public Movement(){

    }

    public Movement(double xVelocity, double yVelocity, double xAcceleration, double yAcceleration, double mass){
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.xAcceleration = xAcceleration;
        this.yAcceleration = yAcceleration;
        this.mass = mass;
    }

}
