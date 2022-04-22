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

        imageRendering image = new imageRendering(frame);


        image.addImage("stingRay.png",0,0,256,256);
        image.addImage("stingRay.png",0,100,256,256);
        image.addImage("stingRay.png",0,200,256,256);
        image.addImage("stingRay.png",0,300,256,256);


    }
    /**
     * main method used to view the results.
     */
    public static void main(String args[]){
        RendererTester test = new RendererTester();
    }
}
