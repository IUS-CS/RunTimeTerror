package RunTimeTerror.Entities;

import RunTimeTerror.Game;

import java.awt.*;
import java.util.Iterator;


public class Koopa extends GameObject {

    public Handler floor = Game.floors;

    public int startx,endx,starty,endy;

    public Koopa(int x, int y, int width, int height, ID id){
        super(x,y,width, height, id);

        velX = -1;
        velY = 2;
    }

    public void tick(){
        x += velX;
        y += velY;

        //if(y<=0 || y >= Game.HEIGHT-50) velY *= -1;
        updateMovement();
    }

    public void render(Graphics g){
        g.setColor(Color.blue);

       g.fillRect(x,y,width,height);
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
}//end Koopa
