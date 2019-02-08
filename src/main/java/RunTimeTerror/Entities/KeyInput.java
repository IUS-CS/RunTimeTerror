package RunTimeTerror.Entities;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;

public class KeyInput extends KeyAdapter {

    private Handler handler;

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
                    tempObject.setX(tempObject.getX() - 2);
                }

                if (key == KeyEvent.VK_RIGHT) {
                    tempObject.setX(tempObject.getX() + 2);
                }

                if (key == KeyEvent.VK_UP) {
                    tempObject.setY(tempObject.getY() - 2);
                    ;
                }

                if (key == KeyEvent.VK_DOWN) {
                    tempObject.setY(tempObject.getY() + 2);
                }
            }
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();
        /*
        if (key == KeyEvent.VK_LEFT) {
            velX = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            velX = 0;
        }

        if (key == KeyEvent.VK_UP) {
            velY = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            velY = 0;
        }*/
    }
}
