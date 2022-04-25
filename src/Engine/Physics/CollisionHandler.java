package Engine.Physics;

import java.util.ArrayList;

/**
 * This class defines methods that help to detect and handle collisions
 *
 * @author Joshua Dowlman
 */
public class CollisionHandler {
    //This is to keep track of which objects can collide.
    //The benefit of doing it this way is that you can have multiple planes/depths
    //The benefit of doing it this way is that you can have multiple planes/depths
    //As only the physics objects in a particular instance of this class can collide with one another.
    private ArrayList<Movement> allPhysicsObjects = new ArrayList<>();

    private ArrayList<Floor> floors = new ArrayList<>();

    //private ArrayList<ArrayList<Movement>> collisions = new ArrayList<>();

    /**
     * Adds a specified object to the objects to be checked
     *
     * @param newPhysicsObject an object derived from movement to add to checking
     */
    public void addPhysicsObject(Movement newPhysicsObject){
        allPhysicsObjects.add(newPhysicsObject);
    }

    /**
     * Removes a specified object from the objects to be checked
     *
     * @param removalPhysicsObject an object derived from Movement to remove from checking
     */
    public void removePhysicsObject(Movement removalPhysicsObject){
        allPhysicsObjects.remove(removalPhysicsObject);
    }

    /**
     * Adds a specified floor to the floors to be checked
     *
     * @param newFloor a floor to be added
     */
    public void addFloor(Floor newFloor){
        floors.add(newFloor);
    }

    /**
     * Removes a specified floor from the floors to be checked
     *
     * @param removalFloor a floor to be removed
     */
    public void removeFloor(Floor removalFloor){
        floors.remove(removalFloor);
    }

    //Deciding on the hitbox to use
    //Use this to set what shape the hitbox will have. Using this and the general equations for that hitbox.
    //Circle being x^2 + y^2 = r^2
    //Triangle being if the coords are within 3 lines.
    //Rectangle being if between 2 horizontal and 2 vertical lines
    //As an extra allow the rectangle to be rotated.

    /**
     * Call this function to find and handle collisions between the previously given floors and objects
     */
    public void findFloorCollisions(){
        for (int i = 0; i < allPhysicsObjects.size(); i++){
            int lowerY, upperY;
            for (int q = 0; q < floors.size(); q++) {
                lowerY = allPhysicsObjects.get(i).getyPos() + allPhysicsObjects.get(i).getySize();
                upperY = allPhysicsObjects.get(i).getyPos();
                if (lowerY <= floors.get(q).getFloorYDimension()){
                    if (floors.get(q).getPassableWhenMovingDown()){
                        //Then do nothing
                    } else {
                        allPhysicsObjects.get(i).setyVelocity(0);
                        allPhysicsObjects.get(i).setyAcceleration(0);
                        allPhysicsObjects.get(i).setxAcceleration(allPhysicsObjects.get(i).getxAcceleration() - floors.get(q).getRateOfSlowDown());
                        allPhysicsObjects.get(i).setyPos(lowerY + allPhysicsObjects.get(i).getySize());
                    }
                } else if (upperY >= (floors.get(q).getFloorYDimension() + floors.get(q).getFloorYSize())) {
                    if (floors.get(q).getPassableWhenMovingUp()) {
                        //Then do nothing
                    } else {
                        allPhysicsObjects.get(i).setyVelocity(0);
                        allPhysicsObjects.get(i).setyAcceleration(0);
                        allPhysicsObjects.get(i).setyPos(upperY);
                    }
                }
            }
        }
    }

    /**
     * Call this function to find all the collisions between the objects listed in it.
     */
    public void findCollisions(){
        //For every physics object against every other physics object
        for (int i = 0; i < allPhysicsObjects.size(); i++){
            ArrayList<Movement> collisionsWithI = new ArrayList<>();
            for (int q = 1; q < allPhysicsObjects.size(); q++){
                //if i and q are the same then ignore them as they are the same object
                if (i != q){
                    Shapes iShape = allPhysicsObjects.get(i).getHitBoxShape();
                    Shapes qShape = allPhysicsObjects.get(q).getHitBoxShape();
                    //Depending on the shapes it affects how to find collisions
                    if (iShape == qShape){
                        //Shapes are the same
                        if (iShape == Shapes.Rectangle){
                            if ((allPhysicsObjects.get(i).xPos > allPhysicsObjects.get(q).xPos) && (allPhysicsObjects.get(i).xPos + allPhysicsObjects.get(i).xSize < allPhysicsObjects.get(q).xPos)){
                                //Collision in xCoord
                                if ((allPhysicsObjects.get(i).yPos > allPhysicsObjects.get(q).yPos) && (allPhysicsObjects.get(i).xPos + allPhysicsObjects.get(i).xSize < allPhysicsObjects.get(q).yPos)){
                                    //Collision in xCoord and yCoord between entity number i and entity number q
                                    collisionsWithI.add(allPhysicsObjects.get(q));
                                }
                            }
                        }
                    } else {

                    }
                }

            }

            allPhysicsObjects.get(i).Collision(collisionsWithI);

        }

        //If a collision with the floor set the y velocity to 0


        //Check the allPhysicsObjects for any collisions
        //Could try to find a collision detection algorithm or could make one up.
        //If making one up you could use the xPos and the yPos + the xSize and the ySize to 'draw' a rectangle hitbox
        //Then check if any of the other objects boxes are within this box.
        //To save compute time you could keep this information saved either in the class or

        //Or could split screen up into individual parts and keep track of where an entity is on this grid.
        //This way you don't need to check for the

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
}
