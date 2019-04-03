package RunTimeTerror.Entities;

import java.awt.*;

public class Floor extends GameObject{


    public Floor(int x, int y, int width, int height, ID id){
        super(x,y,width,height,id);
    }


    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);

    }

}
