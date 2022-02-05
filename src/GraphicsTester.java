import Engine.Renderer;

import java.awt.*;

public class GraphicsTester {

    public GraphicsTester(){
        Renderer display = new Renderer(1200, 720, "Testing");

        display.DrawWindow();

        return;
    }

    public static void main(String args[]){
        GraphicsTester test = new GraphicsTester();
    }
}
