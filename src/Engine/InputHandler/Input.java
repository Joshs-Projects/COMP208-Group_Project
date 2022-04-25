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

    public int getMouseX(){
        return mouseX;
    }
    public int getMouseY(){
        return mouseY;
    }


    public boolean isKeyPressed(int keyCode){
        return allKeys[keyCode];
    }

    public boolean isKeyJustDown(int keyCode){
        return allKeys[keyCode] && !keysLast[keyCode];

    }

}
