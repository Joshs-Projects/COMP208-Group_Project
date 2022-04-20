import Engine.Rendering.Renderer;
import Engine.Rendering.imageRendering;

import javax.swing.*;
import java.awt.*;

public class RendererTester {

    public RendererTester(){
        Renderer display = new Renderer(1200, 720, "A New Game");

        display.Window();

        JFrame frame = display.getFrame();

        imageRendering image = new imageRendering(frame);

        /*
        display.Window();
        display.addCustomText("Blaise", 200,200,100,"Arial",0,Color.BLACK,true,false);
        display.addCustomText("Blaise", 200,200,100,"Arial",0,Color.BLACK,true,false);
         */
        image.addImage("stingRay.png",0,0,256,256);
    }
    public static void main(String args[]){
        RendererTester test = new RendererTester();
    }
}
