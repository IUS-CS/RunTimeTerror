package RunTimeTerror.Entities;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    public boolean jumping;
    int jumpCount = 0;
    int maxJumpHeight = 15;

    public KeyInput(Handler handler){
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        System.out.println(key);


        for(int i = 0; i<handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player) {

                if (key == KeyEvent.VK_LEFT) {
                    tempObject.setVelX(-2);
                }

                if (key == KeyEvent.VK_RIGHT) {
                    tempObject.setVelX(2);
                }

                if (key == KeyEvent.VK_UP) {
                    //tempObject.setVelY(-2);
                    jumping = true;
                    jumpCount = 0;
                    updateJump(i);
                }

                if (key == KeyEvent.VK_DOWN) {
                    tempObject.setVelY(2);
                }


            }
        }
    }

    public void updateJump(int id){
        GameObject tempObject = handler.object.get(id);
        for(int i = 0; i<=maxJumpHeight; i+=5) {
            if (!jumping) {
                return;
            } else if (jumping && i == 0) {
                tempObject.setVelY(-5);
            } else if (jumping && i == maxJumpHeight) {
                //tempObject.setVelY(1);
                jumpCount = maxJumpHeight;
                jumping = false;
            }
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();
        for(int i = 0; i<handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (key == KeyEvent.VK_LEFT) {
                tempObject.setVelX(0);
            }

            if (key == KeyEvent.VK_RIGHT) {
                tempObject.setVelX(0);
            }
            /*if (key == KeyEvent.VK_UP) {
                tempObject.setVelY(0);
            }*/

            if (key == KeyEvent.VK_DOWN) {
                tempObject.setVelY(0);
            }
        }
    }
}
