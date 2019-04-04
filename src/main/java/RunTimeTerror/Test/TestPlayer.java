package RunTimeTerror.Test;

import RunTimeTerror.Entities.Collision;
import RunTimeTerror.Entities.GameObject;
import RunTimeTerror.Entities.ID;
import RunTimeTerror.Entities.KeyInput;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TestPlayer extends GameObject{

    public boolean jumping;
    public int jumpingCount = 0;
    public int MAX_JUMPING_COUNT = 15;
    public boolean pressingRight, pressingLeft;
    public boolean collidingWithFloor, keyConsumed;
    public int key;
    private int i;


    public TestPlayer(int x, int y, int width, int height, ID id){
        super(x,y,width,height,id);

    }

    @Override
    public void tick(){
        collidingWithFloor = iscollidingWithFloor();
        updateMovement();

    }

    @Override
    public void render(Graphics g) {

    }//render

    public void updateMovement(){
        if(alive) {
            updateJump();
            UpdateHorizontal();
            checkImpactwhileJumping();
            checkCollision();
        }
        else if(!alive){
            velY=5;
        }
    }

    public void UpdateHorizontal(){
        pressingLeft = KeyInput.isKeyDown(37);
        pressingRight = KeyInput.isKeyDown(39);
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
        return Collision.isOnFloor(this);
    }//end iscollidingWithFloor

    public void updateJump(){
        //System.out.println(collidingWithFloor);
        if (!jumping && !collidingWithFloor) {
            //jumping = true;
            return;
        }
        else if (!jumping && key==88) {
            y += -5;
            jumping = true;
            jumpingCount = 0;
            //Sound.play("jump");
        }
        else if (collidingWithFloor) {
            jumping = false;
            if (key==88) {
                keyConsumed = true;
            }
        }
        else if (y<=32) {
            jumpingCount = MAX_JUMPING_COUNT;
        }
        else if (jumping && key==88 && jumpingCount < MAX_JUMPING_COUNT) {

            velY = -5;
            jumpingCount++;
        }
        else {
            jumpingCount = MAX_JUMPING_COUNT;
        }

    }//updateJumping

    public void checkImpactwhileJumping(){
        if(jumpingCount == MAX_JUMPING_COUNT){
            velY = 2;
        }
        if(iscollidingWithFloor()){
            velY = 0;
        }
    }

    public void checkCollision(){
        if(Collision.isColliding(this)) {
            alive = false;
        }
    }
}
