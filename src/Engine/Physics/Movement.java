package Engine.Physics;

public class Movement extends Physics{
    protected double xVelocity;
    protected double yVelocity;

    protected double xAcceleration;
    protected double yAcceleration;

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
}
