package Engine.Physics;

import java.util.ArrayList;

public class CollisionHandler {
    //This is to keep track of which objects can collide.
    //The benefit of doing it this way is that you can have multiple planes/depths
    //As only the physics objects in a particular instance of this class can collide with one another.
    private ArrayList<Movement> allPhysicsObjects = new ArrayList<>();

    private ArrayList<Floor> floors = new ArrayList<>();

    public void addPhysicsObject(Movement newPhysicsObject){
        allPhysicsObjects.add(newPhysicsObject);
    }

    public void removePhysicsObject(Movement removalPhysicsObject){
        allPhysicsObjects.remove(removalPhysicsObject);
    }

    public void addFloor(Floor newFloor){
        floors.add(newFloor);
    }

    public void removeFloor(Floor removalFloor){
        floors.remove(removalFloor);
    }

    public void findCollisions(){
        //Check the allPhysicsObjects for any collisions
        //Could try to find a collision detection algorithm or could make one up.
        //If making one up you could use the xPos and the yPos + the xSize and the ySize to 'draw' a rectangle hitbox
        //Then check if any of the other objects boxes are within this box.
        //To save compute time you could keep this information saved either in the class or

        /*
        If I have a class "A" and I want to use another class "Compute" to compute something over "A"
        by using some information that can be derived by 2 of "A's" attributes say "x" and "y",
        but not all objects of "A" will use be computed over by class "Compute" how should I do this.
        Should I make a child of class "A" say "AB" and then add an attribute "z" = f(x,y) where f is some computation.
        Or should I save this "z" in the class "Compute". Or maybe just give "A" the attribute "z".
        Or not save this "z" and just calculate f(x,y) when needed.
        Or is there some other solution I'm not thinking of and I'm over complicating it.

        I'm wasting system resources by keeping this calculation up to date and by storing its output.
        To minimise this I could create a child so only the objects derived from the child that need
        this info have it calculated and stored. For small projects it wouldn't matter but larger ones it might.
        And the brief is I'm creating code for someone else to use so I can't say if its a small project or a large one.
        An example of what I'm talking about is if I have a patient and 20% of the patients I dont need to know their BMI.
        But for 80% I do. The BMI could change due to weight and height. But I dont need the BMI for most patients.

        */

        //Post vs Pre
        //Implement both and leave it up to the developer and their purposes.

    }

    public void HandleCollisions(){
        //When a collision is found handle it on one of a few ways
        //If one of the colliding bodies is immovable set velocity of other body to 0
        //If one body is a character and the other is an entity movable calculate resulting movement.
            //This is similair to both bodies being an entity
        //If both are characters then use forces of characters to calculate resulting movement

        //Put a default handler in here then let this be overridden if a different behaviour is wanted?
        //Maybe this should just call objects collision methods with the objects it collides with.
    }
}
