import Engine.Rendering.Renderer;

import java.awt.*;

public class RendererTester {

    public RendererTester(){
        Renderer display = new Renderer(1200, 720, "A New Game");

        display.Window();
        display.addImage("stingRay.png", 500,500,256,256);
    }
    public static void main(String args[]){
        RendererTester test = new RendererTester();
    }


}
