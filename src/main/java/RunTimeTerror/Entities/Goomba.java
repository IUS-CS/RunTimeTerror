package RunTimeTerror.Entities;

import RunTimeTerror.Game;

import java.awt.*;

public class Goomba extends GameObject {

    public Goomba(int x, int y, int width, int height, ID id){
        super(x,y,width,height,id);

        velX = -2;
        velY = 0;
    }//end Goomba

    public void tick(){
        x += velX;
        y += velY;

        if(y<=0|| y >= Game.HEIGHT-50) velY *= -1;
        if(x<=0 || x >= Game.WIDTH-32) velX *= -1;
    }//end tick

    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillOval(x,y,width,height);
    }//end render
}//end Goomba
