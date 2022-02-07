package Engine;

import java.awt.*;

public class Assets {
    private Image representation;

    private String imageName;

    private int imageXSize;
    private int imageYSize;

    private Toolkit t = Toolkit.getDefaultToolkit();

    public Image getImage(){
        return representation;
    }

    private void loadImage(String ImageName){
        representation = t.getImage(ImageName);
    }

    public Assets(String imageName, int imageXSize, int imageYSize){

    }


}
