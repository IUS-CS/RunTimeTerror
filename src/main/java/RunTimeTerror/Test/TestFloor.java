package RunTimeTerror.Test;

import RunTimeTerror.Entities.GameObject;
import RunTimeTerror.Entities.ID;

import java.awt.*;

public class TestFloor extends GameObject {


    public TestFloor(int x, int y, int width, int height, ID id){
        super(x,y,width,height,id);
    }


    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);

    }

}
