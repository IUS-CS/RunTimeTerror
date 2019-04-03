package RunTimeTerror.Entities;


import RunTimeTerror.Game;

import java.util.Iterator;

public class Collision {
    private static int posX;
    private static int posY;
    private static int tempX;
    private static int tempY;
    private static boolean collidingFromTop;

    private static Handler handle = Game.handler;

    public static boolean isColliding(GameObject object){
        posX = object.getX();
        posY = object.getY();
        Iterator<GameObject> iter = handle.object.iterator();
        while(iter.hasNext()){
            GameObject tempObject = iter.next();
            if(tempObject!=object) {
                tempX = tempObject.getX();
                tempY = tempObject.getY();
                if (tempX <= posX + object.width) {
                    if(tempX + tempObject.width >= posX){
                        if(tempY + tempObject.height >= posY){
                            if(tempY <= posY+object.height){
                                //System.out.println("colliding");
                                return true;
                            }
                        }
                    }
                    //System.out.println("colliding");
                    //return true;
                }
                if (tempX <= posX + object.width){
                    if(tempX + tempObject.width >= posX ){
                        if(tempY >= posY + object.height && tempY-6<=posY + object.height){
                            collidingFromTop = true;
                            //System.out.println("colliding");
                            return true;

                        }
                    }
                }
            }

        }

        return false;
    }

    public static boolean iscollidingTop(){
        return collidingFromTop;
    }



}
