package RunTimeTerror.Entities;

import RunTimeTerror.Game;

import java.awt.*;
import java.util.Iterator;

public class Goomba extends GameObject {

    public Handler floor = Game.floors;

    public int startx,endx,starty,endy;

    public Goomba(int x, int y, int width, int height, ID id){
        super(x,y,width,height,id);
        alive = true;
        velX = -1;
        velY = 2;
    }//end Goomba

    public void tick(){
        x += velX;
        y += velY;

        updateMovement();
    }//end tick

    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillOval(x,y,width,height);
    }//end render

    public void updateMovement(){
        if(alive) {
            if (x <= 0 || x >= Game.WIDTH - 32) velX *= -1;
            checkCollision();
            pipe();
            falling();
        }
        else if(!alive){
            setVelY(5);
        }
    }

    public void pipe(){
        if(getY() >= Game.HEIGHT-70){
            if(getX()>=Game.WIDTH-50 || getX()<=10) {
                setY(60);
            }
        }
    }

    public void falling(){
        if(iscollidingWithFloor()){
            velY=0;
        }
        else{
            velY = 1;
        }
    }

    public boolean iscollidingWithFloor(){
        return Collision.isOnFloor(this);
    }//end iscollidingWithFloor

    public void checkCollision(){
        if(Collision.isColliding(this)) {
            alive = true;
            velX *= -1;
            if(Collision.iscollidingTop()){
                alive = false;
                return;
            }
        }
    }
}//end Goomba
