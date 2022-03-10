package Engine.InputHandler;


import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Input {


    private ArrayList<Integer> keysPressed = new ArrayList<Integer>();
    private ArrayList<Integer> keysDown = new ArrayList<Integer>();

    private int mouseX, mouseY;
    private int scroll;

    public void keyReleased(KeyEvent event) {
        int key = event.getKeyCode();
    }

    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();
    }
}
