package RunTimeTerror.Entities;




import RunTimeTerror.Game;

import java.awt.*;


public class Player extends GameObject{

    public Player(int x, int y, ID id){
        super(x, y, id);
        velY = 1;

    }

    @Override
    public void tick() {

        x += velX;
        y += velY;

        if(y> Game.HEIGHT - 70){
            velY = 0;
        }

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x,y,32,32);

    }



}
