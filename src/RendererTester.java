import Engine.Rendering.Renderer;
import Engine.Rendering.buttonRendering;
import Engine.Rendering.imageRendering;
import Engine.Rendering.textRendering;

import javax.swing.*;
import java.awt.*;

/**
 * To check the functions written in the classes associated with rendering perform correctly.
 *
 * @author Ethan Myles.
 */
public class RendererTester {

    /**
     * Assess the results of the rendering.
     */
    public RendererTester(){
        Renderer display = new Renderer(1200, 720, "A New Game");

        display.Window();

        display.clearScreen();

        JFrame frame = display.getFrame();

        textRendering text = new textRendering(frame);

        text.addCustomText("Game Over...", 0,0, 20,"Arial",0, Color.BLUE, true, false);

    }
    /**
     * main method used to view the results.
     */
    public static void main(String args[]){
        RendererTester test = new RendererTester();
    }
}
