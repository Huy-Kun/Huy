package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entity.Player;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, rightPressed, leftPressed, enterPressed;
    GamePanel gp;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        /// Title state
        if (gp.gameState == gp.titleState) {

            if (gp.ui.titleScreenState == 0) {
                if (code == KeyEvent.VK_W) {
                    gp.ui.commandNum--;
                    if (gp.ui.commandNum == -1)
                        gp.ui.commandNum = 2;
                }
                if (code == KeyEvent.VK_S) {
                    gp.ui.commandNum++;
                    if (gp.ui.commandNum == 3)
                        gp.ui.commandNum = 0;
                }
                if (code == KeyEvent.VK_ENTER) {
                    if (gp.ui.commandNum == 0)
                        gp.ui.titleScreenState = 1;
                    if (gp.ui.commandNum == 1)
                        gp.ui.titleScreenState = 2;
                    if (gp.ui.commandNum == 2)
                        System.exit(0);
                }
            } else if (gp.ui.titleScreenState == 1) {
                if (code == KeyEvent.VK_W) {
                    gp.ui.commandNum--;
                    if (gp.ui.commandNum == -1)
                        gp.ui.commandNum = 2;
                }
                if (code == KeyEvent.VK_S) {
                    gp.ui.commandNum++;
                    if (gp.ui.commandNum == 3)
                        gp.ui.commandNum = 0;
                }
                if (code == KeyEvent.VK_ENTER) {
                    if (gp.ui.commandNum == 0)
                        gp.gameState = gp.playState;
                    if (gp.ui.commandNum == 1) {
                        gp.playerGender = 1;
                        gp.player = new Player(gp, this);
                        gp.gameState = gp.playState;
                    }
                    if (gp.ui.commandNum == 2)
                        gp.ui.titleScreenState = 0;
                }
            } else if (gp.ui.titleScreenState == 2)
                if (code == KeyEvent.VK_ENTER)
                    gp.ui.titleScreenState = 0;
        }

        /// Play state
        else if (gp.gameState == gp.playState) {
            if (code == KeyEvent.VK_W)
                upPressed = true;
            if (code == KeyEvent.VK_D)
                rightPressed = true;
            if (code == KeyEvent.VK_S)
                downPressed = true;
            if (code == KeyEvent.VK_A)
                leftPressed = true;
            if (code == KeyEvent.VK_ENTER)
                enterPressed = true;
            if (code == KeyEvent.VK_P)
                gp.gameState = gp.pauseState;
        }

        /// Pause state
        else if (gp.gameState == gp.pauseState) {
            if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                if (gp.ui.commandNum == -1)
                    gp.ui.commandNum = 1;
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                if (gp.ui.commandNum == 2)
                    gp.ui.commandNum = 0;
            }
            if (code == KeyEvent.VK_ENTER) {
                if (gp.ui.commandNum == 0)
                    gp.gameState = gp.playState;
                if (gp.ui.commandNum == 1) {
                    gp.gameState = gp.titleState;
                    gp.ui.titleScreenState = 0;
                    gp.ui.commandNum = 0;
                }
            }
            if (code == KeyEvent.VK_P)
                gp.gameState = gp.playState;
        }

        /// Dialogue state
        else if (gp.gameState == gp.dialogueState) {
            if (code == KeyEvent.VK_ENTER)
                gp.gameState = gp.playState;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W)
            upPressed = false;
        if (code == KeyEvent.VK_D)
            rightPressed = false;
        if (code == KeyEvent.VK_S)
            downPressed = false;
        if (code == KeyEvent.VK_A)
            leftPressed = false;
        if (code == KeyEvent.VK_ENTER)
            enterPressed = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

}
