package RunTimeTerror.Entities;

import RunTimeTerror.Game;

import java.awt.*;

public class Goomba extends GameObject {

    public Goomba(int x, int y, ID id){
        super(x,y,id);

        velX = 5;
        velY = 5;
    }

    public void tick(){
        x += velX;
        y += velY;

        if(y<=0 || y >= Game.HEIGHT) velY *= -1;
    }

    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x,y,16,16);
    }
}
