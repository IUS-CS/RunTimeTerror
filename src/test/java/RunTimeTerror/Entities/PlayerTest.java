package RunTimeTerror.Entities;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class PlayerTest {

    Handler floor, objects;
    Player tester;
    Goomba enemy;
    int x,left,right;

    @Before
    public void setUp() throws Exception {
        tester = new Player(10,10,10,10,ID.Player);
        floor.addObject(new Floor(10,20,30,20,ID.Floor));
        enemy = new Goomba(19,10,10,10,ID.Goomba);
        objects.addObject(tester);
        objects.addObject(enemy);
        enemy.setVelY(0);
        tester.setVelY(0);
        enemy.setVelX(0);
        Collision.floor = floor;
        Collision.handle = objects;
    }

    @Test
    public void UpdateHorizontal(){
    }

    @Test
    public void moveRight() {
        tester.setVelX(0);
        tester.moveRight();
        int results = tester.getVelX();
        System.out.println("moving right for object");
        assertEquals(2, results);
    }

    @Test
    public void moveLeft() {
        tester.setVelX(0);
        tester.moveLeft();
        int results = tester.getVelX();
        System.out.println("moving left for object");
        assertEquals(-2, results);
    }


    @Test
    public void updateJump() {
    }

    @Test
    public void checkImpactwhileJumping() {
    }

    @Test
    public void checkCollision() {
    }
}