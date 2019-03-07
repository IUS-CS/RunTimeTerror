package RunTimeTerror.Test;

import RunTimeTerror.Entities.ID;
import RunTimeTerror.Entities.object;

public class TestObject implements object {

    protected int x, y;
    protected ID id;
    protected int velX, velY;

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setId(ID id){
        this.id = id;
    }

    public ID getId(){
        return id;
    }

    public void setVelX(int velX){
        this.velX = velX;
    }

    public int getVelX(){
        return velX;
    }

    public void setVelY(int velY){
        this.velY = velY;
    }
    public int getVelY(){
        return velY;
    }
}
