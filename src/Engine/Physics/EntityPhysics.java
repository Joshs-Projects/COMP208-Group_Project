package Engine.Physics;

public class EntityPhysics extends Movement {
    private boolean isMovable;

    public EntityPhysics() {
    }

    public EntityPhysics(double mass, double xPos, double yPos, double xSize, double ySize, boolean isMoveable){
        this.mass = mass;

        this.xPos = xPos;
        this.yPos = yPos;

        this.xSize = xSize;
        this.ySize = ySize;

        this.isMovable = isMoveable;
    }

    public EntityPhysics(double mass, double xPos, double yPos, double xSize, double ySize, double xVelocity, double yVelocity, boolean isMoveable){
        this.mass = mass;

        this.xPos = xPos;
        this.yPos = yPos;

        this.xSize = xSize;
        this.ySize = ySize;

        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;

        this.isMovable = isMoveable;
    }

    public EntityPhysics(double mass, double xPos, double yPos, double xSize, double ySize, double xVelocity, double yVelocity, double xAcceleration, double yAcceleration, boolean isMoveable){
        this.mass = mass;

        this.xPos = xPos;
        this.yPos = yPos;

        this.xSize = xSize;
        this.ySize = ySize;

        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;

        this.xAcceleration = xAcceleration;
        this.yAcceleration = yAcceleration;

        this.isMovable = isMoveable;
    }

    //Need a setter and getter for movable

}