package RunTimeTerror.Entities;


import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;

public class Handler {

    LinkedList<GameObject> object = new LinkedList<>();

    public void tick(){
        Iterator<GameObject> iter = object.iterator();
        while(iter.hasNext()){
           GameObject tempObject = iter.next();

           tempObject.tick();
        }//for loop
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



}
