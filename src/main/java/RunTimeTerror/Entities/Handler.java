package RunTimeTerror.Entities;


import RunTimeTerror.Game;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;

public class Handler {

    public LinkedList<GameObject> object = new LinkedList<>();
    public boolean running = true;

    public void tick(){
        Iterator<GameObject> iter = object.iterator();
        while(iter.hasNext()){
           GameObject tempObject = iter.next();
           tempObject.tick();
        }//for loop
        isDead();
    }//tick

    public void render(Graphics g){
        Iterator<GameObject> iter = object.iterator();
        while(iter.hasNext()){
            GameObject tempObject = iter.next();

            tempObject.render(g);
        }

    }

    public void addObject(GameObject object){
        this.object.add(object);
    }

    public void removeObject(GameObject object){
        this.object.remove(object);
    }

    public void isDead(){
        Iterator<GameObject> iter = object.iterator();
        while(iter.hasNext()) {
            GameObject tempObject = iter.next();
            if (!tempObject.isAlive() && tempObject.getY() > Game.HEIGHT) {
                if(tempObject.id == ID.Player){
                    running=false;
                }
                removeObject(tempObject);
                return;
            }
        }
    }



}
