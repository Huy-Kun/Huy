package object;

import java.io.File;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Pencil extends SuperObject {

    GamePanel gp;

    public OBJ_Pencil(GamePanel gp) {
        this.gp = gp;
        name = "Pencil";
        try {

            File f = new File("./res/objects/pencil.png");
            image = ImageIO.read(f);
            uTool.scaledImage(image, gp.tileSize, gp.tileSize);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
