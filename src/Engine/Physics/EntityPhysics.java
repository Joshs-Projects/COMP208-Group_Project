package Engine.Physics;

/**
 * This class defines methods that help to organise how objects behave in the physics simulation.
 * It is different to the CharacterPhysics class as these objects can be locked and can't be moved by the user
 *
 * @Author Joshua Dowlman
 */
public class EntityPhysics extends Movement {
    private boolean isMovable;

    /**
     * Gets the isMovable attribute
     *
     * @return boolean isMovable
     */
    public boolean getIsMovable() {
        return isMovable;
    }

    /**
     * Sets the isMovable attribute
     *
     * @param movable a boolean representing if the entity can be moved
     */
    public void setIsMovable(boolean movable) {
        this.isMovable = movable;
    }

    /**
     * A blank constructor
     */
    public EntityPhysics() {
    }

    /**
     * A constructor that sets the mass, xPos, yPos, xSize, ySize, isMovable
     *
     * @param mass A double representing the mass of the entity
     * @param xPos A double representing the horizontal position
     * @param yPos A double representing the vertical position
     * @param xSize A double representing the horizontal size
     * @param ySize A double representing the vertical size
     * @param isMovable A boolean representing whether the entity can be moved
     */
    public EntityPhysics(double mass, double xPos, double yPos, double xSize, double ySize, boolean isMovable){
        this.mass = mass;

        this.xPos = xPos;
        this.yPos = yPos;

        this.xSize = xSize;
        this.ySize = ySize;

        this.isMovable = isMovable;
    }

    /**
     * A constructor that sets the mass, xPos, yPos, xSize, ySize, isMovable
     *
     * @param mass A double representing the mass of the entity
     * @param xPos A double representing the horizontal position
     * @param yPos A double representing the vertical position
     * @param xSize A double representing the horizontal size
     * @param ySize A double representing the vertical size
     * @param xVelocity A double representing the velocity in the horizontal direction
     * @param yVelocity A double representing the velocity in the vertical direction
     * @param isMovable A boolean representing whether the entity can be moved
     */
    public EntityPhysics(double mass, double xPos, double yPos, double xSize, double ySize, double xVelocity, double yVelocity, boolean isMovable){
        this.mass = mass;

        this.xPos = xPos;
        this.yPos = yPos;

        this.xSize = xSize;
        this.ySize = ySize;

        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;

        this.isMovable = isMovable;
    }

    /**
     * A constructor that sets the mass, xPos, yPos, xSize, ySize, isMovable
     *
     * @param mass A double representing the mass of the entity
     * @param xPos A double representing the horizontal position
     * @param yPos A double representing the vertical position
     * @param xSize A double representing the horizontal size
     * @param ySize A double representing the vertical size
     * @param xVelocity A double representing the velocity in the horizontal direction
     * @param yVelocity A double representing the velocity in the vertical direction
     * @param xAcceleration A double representing the acceleration in the horizontal direction
     * @param yAcceleration A double representing the acceleration in the vertical direction
     * @param isMovable A boolean representing whether the entity can be moved
     */
    public EntityPhysics(double mass, double xPos, double yPos, double xSize, double ySize, double xVelocity, double yVelocity, double xAcceleration, double yAcceleration, boolean isMovable){
        this.mass = mass;

        this.xPos = xPos;
        this.yPos = yPos;

        this.xSize = xSize;
        this.ySize = ySize;

        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;

        this.xAcceleration = xAcceleration;
        this.yAcceleration = yAcceleration;

        this.isMovable = isMovable;
    }
}