package Engine.Physics;

import java.util.ArrayList;

public class CollisionHandler {
    //This is to keep track of which objects can collide.
    //The benefit of doing it this way is that you can have multiple planes/depths
    //As only the physics objects in a particular instance of this class can collide with one another.
    private ArrayList<Physics> allPhysicsObjects = new ArrayList<>();

    public void AddPhysicsObject(Physics newPhysicsObject){
        allPhysicsObjects.add(newPhysicsObject);
    }

    public void findCollisions(){
        //Check the allPhysicsObjects for any collisions
        //Could try to find a collision detection algorithm or could make one up.
        //If making one up you could use the xPos and the yPos + the xSize and the ySize to 'draw' a rectangle hitbox
        //Then check if any of the other objects boxes are within this box.
        //To save compute time you could keep this information saved either in the class or

    }
}
