package RunTimeTerror.Entities;




import RunTimeTerror.Game;

import java.awt.*;
import java.awt.event.KeyEvent;


public class Player extends GameObject{


    public boolean jumping;
    public int jumpingCount = 0;
    public int MAX_JUMPING_COUNT = 15;
    public boolean pressingRight;
    public boolean pressingLeft;


    public Player(int x, int y, int width, int height, ID id){
        super(x,y,width,height,id);
        velY = 1;


    }

    @Override
    public void tick(){

        x += velX;
        y += velY;

        updateMovement();

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x,y,24,32);

    }

    public void updateMovement(){
        updateJump();
        UpdateHorizontal();
        checkImpactwhileJumping();
    }

    public void UpdateHorizontal(){
        pressingLeft = KeyInput.isKeyDown(KeyEvent.VK_LEFT);
        pressingRight = KeyInput.isKeyDown(KeyEvent.VK_RIGHT);
        if(pressingLeft){
            moveLeft();
        }
        else if(pressingRight){
            moveRight();
        }
        else{
            velX = 0;
        }
    }

    public void moveRight(){
        setVelX(2);
    }

    public void moveLeft(){
        setVelX(-2);
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
        //System.out.println(collidingWithFloor);
        if (!jumping && !collidingWithFloor) {
            //jumping = true;
            return;
        }
        else if (!jumping && KeyInput.isKeyPressed(KeyEvent.VK_X)) {
            y += -5;
            jumping = true;
            jumpingCount = 0;
            //Sound.play("jump");
        }
        else if (collidingWithFloor) {
            jumping = false;
            if (KeyInput.isKeyDown(KeyEvent.VK_X)) {
                KeyInput.keyDownConsumed[KeyEvent.VK_X] = true;
            }
        }
        else if (y<=32) {
            jumpingCount = MAX_JUMPING_COUNT;
        }
        else if (jumping && KeyInput.isKeyDown(KeyEvent.VK_X)
                && jumpingCount < MAX_JUMPING_COUNT) {

            velY = -5;
            jumpingCount++;
        }
        else {
            jumpingCount = MAX_JUMPING_COUNT;
        }

    }//updateJumping

    public void checkImpactwhileJumping(){
        boolean collied = false;
        if(jumpingCount == MAX_JUMPING_COUNT){
            velY = 2;
        }
        if(iscollidingWithFloor()){
            velY = 0;
        }
    }

}
