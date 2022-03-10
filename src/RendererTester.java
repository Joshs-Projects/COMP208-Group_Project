import Engine.Rendering.Renderer;

import java.awt.*;

public class RendererTester {

    public RendererTester(){
        Renderer display = new Renderer(1200, 720, "Testing");
        //ObjectDrawer object  = new ObjectDrawer("red");

        //Draw function allowing the user to draw x y size image image to display, user puts in an object.

        display.drawWindow();

        display.DrawObject(20,20,40,40, Color.red);

        return;
    }

    public static void main(String args[]){
        RendererTester test = new RendererTester();
    }


}
