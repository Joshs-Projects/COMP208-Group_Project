package Engine.InputHandler;


import java.awt.event.*;
import java.util.ArrayList;

public class Input implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

    private final int keyAmount = 256;
    private ArrayList<Integer> keysPressed = new ArrayList<Integer>();
    private ArrayList<Integer> keysDown = new ArrayList<Integer>();

    private int mouseX, mouseY;
    private int scroll;

    public void keyReleased(KeyEvent event) {
        int key = event.getKeyCode();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

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

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }
}
