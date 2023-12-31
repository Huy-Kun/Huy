package object;

import java.io.File;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Door extends SuperObject {

    GamePanel gp;

    public OBJ_Door(GamePanel gp) {
        this.gp = gp;
        name = "Door";
        try {

            File f = new File("./res/objects/door.png");
            image = ImageIO.read(f);
            uTool.scaledImage(image, gp.tileSize, gp.tileSize);

        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
        
    }
}
