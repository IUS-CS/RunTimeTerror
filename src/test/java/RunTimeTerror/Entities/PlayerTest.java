package RunTimeTerror.Entities;

import RunTimeTerror.Test.TestFloor;
import RunTimeTerror.Test.TestPlayer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class PlayerTest {

    Handler floor, objects;
    TestFloor bottom;
    TestPlayer tester;
    Goomba enemy;
    int x,left,right;

    @Before
    public void setUp() throws Exception {
        tester = new TestPlayer(10,10,10,10,ID.Player);
        bottom = new TestFloor(10,20,30,20,ID.Floor);
        //floor.addObject(bottom);
        enemy = new Goomba(19,10,10,10,ID.Goomba);
        //objects.addObject(tester);
        //objects.addObject(enemy);
        enemy.setVelY(0);
        tester.setVelY(0);
        enemy.setVelX(0);
        //Collision.floor = floor;
        //Collision.handle = objects;
    }

    @After
    public void tearDown() throws Exception {
        tester = null;
        bottom = null;
        enemy = null;
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
    public void updateJump1() {
        tester.jumping = false;
        tester.collidingWithFloor = false;
        tester.updateJump();
        boolean results = tester.jumping;
        System.out.println("Object is not jumping and not on floor");
        assertEquals(false, results);
    }
    @Test
    public void updateJump2() {
        tester.jumping = false;
        tester.collidingWithFloor = true;
        tester.key = 88;
        tester.updateJump();
        boolean results = tester.jumping;
        System.out.println("Object is jumping and on floor, jumping bool check");
        assertEquals(true, results);
    }
    @Test
    public void updateJump3() {
        tester.jumping = false;
        tester.collidingWithFloor = true;
        tester.key = 88;
        tester.updateJump();
        int results = tester.getY();
        System.out.println("Object is jumping and on floor, change in y check");
        assertEquals(5, results);
    }
    @Test
    public void updateJump4() {
        tester.jumping = true;
        tester.collidingWithFloor = true;
        tester.key = 0;
        tester.updateJump();
        boolean results = tester.jumping;
        System.out.println("Object is not jumping and on floor, jumping bool check");
        assertEquals(false, results);
    }
    @Test
    public void updateJump5() {
        tester.jumping = true;
        tester.collidingWithFloor = true;
        tester.key = 88;
        tester.updateJump();
        boolean results = tester.keyConsumed;
        System.out.println("Object is not jumping and on floor, keyconsumed bool check");
        assertEquals(true, results);
    }
    @Test
    public void updateJump6() {
        tester.jumping = true;
        tester.collidingWithFloor = false;
        tester.key = 88;
        tester.updateJump();
        int results = tester.jumpingCount;
        System.out.println("Object is jumping and at max height, jumpingcount value check");
        assertEquals(tester.MAX_JUMPING_COUNT, results);
    }

    @Test
    public void updateJump7() {
        tester.jumping = true;
        tester.collidingWithFloor = false;
        tester.key = 88;
        tester.jumpingCount=0;
        tester.setY(40);
        tester.updateJump();
        int results = tester.getVelY();
        System.out.println("Object is jumping, velY value check");
        assertEquals(-5, results);
    }
    @Test
    public void updateJump8() {
        tester.jumping = true;
        tester.collidingWithFloor = false;
        tester.key = 88;
        tester.jumpingCount=0;
        tester.setY(40);
        tester.updateJump();
        int results = tester.jumpingCount;
        System.out.println("Object is jumping, jumpingcount value check");
        assertEquals(1, results);
    }

    @Test
    public void checkImpactwhileJumping() {
    }

    @Test
    public void checkCollision() {
    }
}