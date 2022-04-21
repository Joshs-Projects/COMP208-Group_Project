/**
 * To check the functions written in the classes associated with rendering perform correctly.
 *
 * @author Ethan Myles.
 */

import Engine.Rendering.Renderer;
import Engine.Rendering.buttonRendering;
import Engine.Rendering.imageRendering;
import Engine.Rendering.textRendering;

import javax.swing.*;
import java.awt.*;

public class RendererTester {

    /**
     * Assess the results of the rendering.
     */
    public RendererTester(){
        Renderer display = new Renderer(1200, 720, "A New Game");

        display.Window();

        JFrame frame = display.getFrame();

        /*
        imageRendering image = new imageRendering(frame);
        image.addImage("stingRay.png",0,0,256,256);

        buttonRendering button = new buttonRendering(frame);
        button.addButton(200,30,50,50);

         */

        textRendering text = new textRendering(frame);
        text.addCustomText("Sting Rays are cool",300,0,20,"Arial",0, Color.BLACK,false,true);

    }
    /**
     * main method used to view the results.
     */
    public static void main(String args[]){
        RendererTester test = new RendererTester();
    }
}
