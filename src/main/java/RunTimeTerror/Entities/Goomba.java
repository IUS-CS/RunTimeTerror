package RunTimeTerror.Entities;

import RunTimeTerror.Game;

import java.awt.*;
import java.util.Iterator;

public class Goomba extends GameObject {

    public Handler floor = Game.floors;

    public int startx,endx,starty,endy;

    public Goomba(int x, int y, int width, int height, ID id){
        super(x,y,width,height,id);

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
        if(x<=0 || x >= Game.WIDTH-32) velX *= -1;
        checkCollision();
        falling();
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
        if(Collision.isColliding(this)){
            alive = false;
        }
        else{
            alive = true;
        }
    }
}//end Goomba
