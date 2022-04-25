package Engine.InputHandler;


import java.awt.event.*;
import java.util.ArrayList;

/**
 * This class defines methods for gathering data for Keyboard and Mouse input
 * It uses Event Listeners to wait for input.
 * It allows the user to implement features that listen for input.
 *
 * @author Daniel Dineen
 */
public class Input implements KeyListener, MouseListener, MouseMotionListener{


    private final int KEY_AMOUNT = 256; //256 represents the keycodes for keyboard input.
    private boolean[] allKeys = new boolean[KEY_AMOUNT];  //keys during current frame
    private boolean[] keysLast = new boolean[KEY_AMOUNT]; //Keys from last frame.

    private int mouseX, mouseY; //Mouse coordinate variables
    private int scroll;


    private final int MOUSE_BUTTONS = 5;//Left click, right click, middle click, scroll press and so on.
    private boolean mouseInput[] = new boolean[MOUSE_BUTTONS]; //array to keep track of mouse clicks.

    public Input(){
        mouseX = 0;
        mouseY = 0;
    }

    /**
     * Every frame, the current frame's key inputs are turned into the previous frames.
     * This is for the extra functionality later in the code.
     */
    public void KeyUpdate(){

        for(int x = 0; x < KEY_AMOUNT; x++){

            keysLast[x] = allKeys[x];
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        allKeys[e.getKeyCode()] = true; //This tells the user that the key is being pressed
    }

    public void keyPressed(KeyEvent e){
        allKeys[e.getKeyCode()] = true; //This tells the user that the key is being pressed

    }
    public void keyReleased(KeyEvent e) {
        allKeys[e.getKeyCode()] = false; //This tells the user that the key is not being pressed
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseInput[e.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseInput[e.getButton()] = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = (int)(e.getX());
        mouseY = (int)(e.getY());
    }
    /**
     * Returns the mouse X coordinate
     *
     * @return an integer of where the mouse X position is
     */
    public int getMouseX(){
        return mouseX;
    }

    /**
     * Returns the mouse Y coordinate
     *
     * @return an integer of where the mouse Y position is
     */
    public int getMouseY(){
        return mouseY;
    }


    /**
     * Returns either true or false depending on the inputted keycode has been pressed.
     *
     * @param keyCode An integer representing a character (A = 65, B = 66 etc.)
     * @return A boolean value representing whether the key has been pressed
     */
    public boolean isKeyPressed(int keyCode){
        return allKeys[keyCode];
    }

    /**
     * Returns a boolean depending on two conditions. The key has been pressed, and in the last frame the key wasn't pressed.
     * If both these conditions are true the return value is true.
     *
     * @param keyCode An integer representing a character (A = 65, B = 66 etc.)
     * @return A boolean value representing whether the key has been pressed, and that is wasn't previously pressed in the last frame
     */
    public boolean isKeyJustDown(int keyCode){
        return allKeys[keyCode] && !keysLast[keyCode];

    }

}
