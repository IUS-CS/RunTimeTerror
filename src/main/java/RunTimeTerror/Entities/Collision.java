package RunTimeTerror.Entities;


import RunTimeTerror.Game;

import java.util.Iterator;

public class Collision {



    private static int posX, posY, tempX, tempY;
    private static boolean collidingFromTop;
    private static int startx,endx,starty,endy;
    public static Handler handle;
    public static Handler floor;

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

    public static boolean isOnFloor(GameObject thing){
        Iterator<GameObject> iter = floor.object.iterator();
        while(iter.hasNext()) {
            GameObject temp = iter.next();
            startx = temp.getX();
            endx = temp.getWidth()+startx;
            starty = temp.getY();
            endy = temp.getHeight()+starty;
            if (thing.y > starty - (thing.height+0) && thing.x+thing.width > startx && thing.x <= endx && thing.y<endy){
                thing.setVelY(0);
                // = Game.HEIGHT-70;
                return true;
            }//end if
        }//end while
        return false;
    }



}
