package RunTimeTerror.Entities;

import java.awt.*;

public abstract class GameObject implements object {

    protected int x, y;
    protected ID id;
    protected int velX, velY;

    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }//end GameObject

    public GameObject(int i, int i1, int i2, int i3, ID player) {
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public void setX(int x){
        this.x = x;
    }//end setx
    public void setY(int y){
        this.y = y;
    }//end sety

    public int getX(){
        return x;
    }//end getx

    public int getY(){
        return y;
    }//end gety

    public void setId(ID id){
        this.id = id;
    }//end setID

    public ID getId(){
        return id;
    }//end getID

    public void setVelX(int velX){
        this.velX = velX;
    } //end setVelX

    public int getVelX(){
        return velX;
    }//end getVelX

    public void setVelY(int velY){
        this.velY = velY;
    }//end setVelY
    public int getVelY(){
        return velY;
    }//end getVelY


}
