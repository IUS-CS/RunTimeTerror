package RunTimeTerror.Entities;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class PlayerTest {

    Player tester;
    int x,left,right;

    @Before
    public void setUp() throws Exception {
        tester = new Player(10,10,10,10,ID.Player) {
            @Override
            public void tick() {

            }

            @Override
            public void render(Graphics g) {

            }
        };
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
        System.out.println("moving right for object");
        assertEquals(-2, results);
    }

    @Test
    public void iscollidingWithFloor() {
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