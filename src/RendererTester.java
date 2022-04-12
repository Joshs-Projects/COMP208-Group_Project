import Engine.Rendering.Renderer;

import java.awt.*;

public class RendererTester {

    public RendererTester(){
        Renderer display = new Renderer(1200, 720, "A New Game");

        display.Window();
        display.addImage("stingRay.png",20,0, 256,256);
        display.addButton(500,300, 50,50);
        display.addCustomButton(500,300, 256,256,"seaBackground.jpg","Shoot !");
        display.pauseMenu();

    }

    public static void main(String args[]){
        RendererTester test = new RendererTester();
    }


}
