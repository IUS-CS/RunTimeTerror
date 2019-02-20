package RunTimeTerror.Entities;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public boolean[] keyDown = new boolean[256];
    public boolean[] keyDownConsumed = new boolean[256];

    public boolean isKeyDown(int keyCode) {
        return keyDown[keyCode];
    }


    public boolean isKeyPressed(int keyCode) {
        if (!keyDownConsumed[keyCode] && keyDown[keyCode]) {
            keyDownConsumed[keyCode] = true;
            return true;
        }
        return false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        keyDown[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyDown[e.getKeyCode()] = false;
        keyDownConsumed[e.getKeyCode()] = false;
    }
}
