package Engine.Physics;

import java.util.ArrayList;

public class Movement extends Physics{
    protected double xVelocity;
    protected double yVelocity;

    protected double xAcceleration;
    protected double yAcceleration;

    protected double mass;

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
        CalculateYDistance();
        yPos = yPos + CalculateYDistance();
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
