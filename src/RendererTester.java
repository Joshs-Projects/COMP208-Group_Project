import Engine.Rendering.Renderer;

import java.awt.*;

public class RendererTester {

    public RendererTester(){
        Renderer display = new Renderer(1200, 720, "A New Game");

        display.Window();
        display.addText("Blaise likes salmon",0, 0,40);
    }
    public static void main(String args[]){
        RendererTester test = new RendererTester();
    }


}
