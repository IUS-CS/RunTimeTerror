package RunTimeTerror.Entities;




import RunTimeTerror.Game;

import java.awt.*;
import java.awt.event.KeyEvent;


public class Player extends GameObject{


    public boolean jumping;
    public int jumpingCount = 0;
    public int MAX_JUMPING_COUNT = 15;
    KeyInput Input = new KeyInput();


    public Player(int x, int y, ID id){
        super(x, y, id);
        velY = 1;

    }

    @Override
    public void tick(){

        x += velX;
        y += velY;

        updateJump();

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x,y,32,32);

    }

    public boolean iscollidingWithFloor(){
        if(y>Game.HEIGHT - 70){
            velY = 0;
            // = Game.HEIGHT-70;
            return true;
        }
        return false;
    }

    public void updateJump(){
        boolean collidingWithFloor = iscollidingWithFloor();
        System.out.println(collidingWithFloor);
        if (!jumping && !collidingWithFloor) {
            //jumping = true;
            return;
        }
        else if (!jumping && Input.isKeyPressed(KeyEvent.VK_X)) {
            y += -5;
            jumping = true;
            jumpingCount = 0;
            //Sound.play("jump");
        }
        else if (collidingWithFloor) {
            jumping = false;
            if (Input.isKeyDown(KeyEvent.VK_X)) {
                Input.keyDownConsumed[KeyEvent.VK_X] = true;
            }
        }
        /*else if (isCollidingWithCeil()) {
            jumpingCount = MAX_JUMPING_COUNT;
        }*/
        else if (jumping && Input.isKeyDown(KeyEvent.VK_X)
                && jumpingCount < MAX_JUMPING_COUNT) {

            velY = -5;
            jumpingCount++;
        }
        else {
            jumpingCount = MAX_JUMPING_COUNT;
        }

    }


}
