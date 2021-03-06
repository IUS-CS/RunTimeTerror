package RunTimeTerror.Entities;




import RunTimeTerror.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Iterator;


public class Player extends GameObject{


    public boolean jumping;
    public int jumpingCount = 0;
    public int MAX_JUMPING_COUNT = 15;
    public boolean pressingRight, pressingLeft;
    private boolean collidingWithFloor;
    private int i;





    public Player(int x, int y, int width, int height, ID id){
        super(x,y,width,height,id);
        velY = 2;
        alive = true;

    }

    @Override
    public void tick(){

        x += velX;
        y += velY;
        collidingWithFloor = iscollidingWithFloor();
        updateMovement();

    }

    @Override
    public void render(Graphics g) {

        if(!alive){
                    g.setColor(Color.yellow);
                    g.fillRect(x, y, width, height);
        }//if character was hit
        else{
            g.setColor(Color.white);
            g.fillRect(x,y,width,height);
        }

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
        isOffScreen();
    }

    public void isOffScreen(){
        if(x > Game.WIDTH){
            setX(-5);
        }
        else if(x<-5){
            setX(Game.WIDTH);
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
        else if (!jumping && KeyInput.isKeyPressed(KeyEvent.VK_X)) {
            y += -5;
            jumping = true;
            jumpingCount = 0;
            //Sound.play("jump");
        }
        else if (collidingWithFloor) {
            jumping = false;
            velY = 2;
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

    public void checkCollision(){
        if(Collision.isColliding(this)) {
            if(Collision.iscollidingTop()){
                alive = true;
            }
            else {
                alive = false;
            }
        }
    }

}
