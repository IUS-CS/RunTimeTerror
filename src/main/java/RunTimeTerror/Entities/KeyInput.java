package RunTimeTerror.Entities;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Queue;

public class KeyInput implements KeyListener {


    public static boolean[] keyDown = new boolean[256];
    public static boolean[] keyDownConsumed = new boolean[256];
    /*Queue<boolean[]> timeline = new LinkedList<>();
    private boolean active = false;
    private boolean keyActive[] = new boolean[256];

    public void KeyInput(){
        if(active == true){
            System.out.println("There is already an instance created");
            return;
        }

        active = true;
    }*/

    public static boolean isKeyDown(int keyCode) {
        return keyDown[keyCode];
    }


    public static boolean isKeyPressed(int keyCode) {
        //keyDown[88] = true;
            if (!keyDownConsumed[keyCode] && keyDown[keyCode]) {
                keyDownConsumed[keyCode] = true;
                System.out.println(keyCode);
                return true;
            }
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        keyDown[e.getKeyCode()] = true;
        //timeline.add(keyDown);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyDown[e.getKeyCode()] = false;
        keyDownConsumed[e.getKeyCode()] = false;
    }
}
