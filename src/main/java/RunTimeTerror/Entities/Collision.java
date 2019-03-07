package RunTimeTerror.Entities;


import RunTimeTerror.Game;

import java.util.Iterator;

public class Collision {
    private int posX;
    private int posY;
    private int tempX;
    private int tempY;

    private Handler handle = Game.handler;

    public boolean isColliding(GameObject object){
        posX = object.getX();
        posY = object.getY();
        Iterator<GameObject> iter = handle.object.iterator();
        while(iter.hasNext()){
            GameObject tempObject = iter.next();
            tempX = tempObject.getX();
            tempY = tempObject.getY();
            if()
        }

        return false;
    }


}
