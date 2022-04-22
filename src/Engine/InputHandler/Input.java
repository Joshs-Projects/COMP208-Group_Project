package Engine.InputHandler;


import java.awt.event.*;
import java.util.ArrayList;

public class Input implements KeyListener, MouseListener, MouseMotionListener{


    private final int KEY_AMOUNT = 256; //256 represents the keycodes for keyboard input.
    private boolean[] allKeys = new boolean[KEY_AMOUNT];  //keys during current frame
    private boolean[] keysLast = new boolean[KEY_AMOUNT]; //Keys from last frame.

    private int mouseX, mouseY; //Mouse coordinate variables
    private int scroll;

    private final int MOUSE_BUTTONS = 5;//Left click, right click, middle click, scroll press and so on.
    private boolean mouseInput[] = new boolean[MOUSE_BUTTONS]; //array to keep track of mouse clicks.

    @Override
    public void keyTyped(KeyEvent e) {

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

}
