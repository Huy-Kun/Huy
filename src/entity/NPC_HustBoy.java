package entity;

import java.util.Random;

import main.GamePanel;

public class NPC_HustBoy extends Entity {

    public NPC_HustBoy(GamePanel gp) {

        super(gp);
        direction = "down";
        speed = 1;
        getImage();

    }

    public void getImage() {

        up1 = setup("./res/npc/hust_boy/hust_boy_up_1");
        up2 = setup("./res/npc/hust_boy/hust_boy_up_2");
        down1 = setup("./res/npc/hust_boy/hust_boy_down_1");
        down2 = setup("./res/npc/hust_boy/hust_boy_down_2");
        left1 = setup("./res/npc/hust_boy/hust_boy_left_1");
        left2 = setup("./res/npc/hust_boy/hust_boy_left_2");
        right1 = setup("./res/npc/hust_boy/hust_boy_right_1");
        right2 = setup("./res/npc/hust_boy/hust_boy_right_2");

    }

    public void setAction() {

        actionLockCounter++;
        // change direction after 2s
        if (actionLockCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;
            if (i <= 25)
                direction = "up";
            else if (i <= 50)
                direction = "down";
            else if (i <= 75)
                direction = "left";
            else
                direction = "right";
            actionLockCounter = 0;
        }
    }
}