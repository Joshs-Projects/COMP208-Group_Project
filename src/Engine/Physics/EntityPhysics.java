package Engine.Physics;

public class EntityPhysics extends Movement {
    //Create a bool for is the entity movable.
    //Create a constructor that takes in: (Most of this can be found in the CharacterPhysics)
    //Size
    //Position
    //Velocity
    //Mass
    //Make setters and getters for all relevant attributes.
    //THIS EXCLUDES ATTRIBUTES THAT WERE INHERITED AS THEY SHOULD HAVE PRE-EXISTING SETTERS AND GETTERS
    private boolean movable;



    //default Construtor
    public EntityPhysics() {
    }

    //2nd construtor
    public  EntityPhysics(double mass){
        this.mass = mass;
    }

}