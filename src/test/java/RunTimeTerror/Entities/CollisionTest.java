package RunTimeTerror.Entities;

import RunTimeTerror.Game;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CollisionTest {
     GameObject tester;
     GameObject enemy;
     boolean result;
     public Handler handler;

    @Before
    public void setUp() throws Exception {
        /*this.tester = new GameObject(int x, int y, int width, int height, ID id) {
            public void tick() {
            }

            public void render(Graphics g) {
            }
        };
        this.enemy = new GameObject(20,10,10,10,ID.Goomba) {
            @Override
            public void tick() {
                //velX = 1;

                //if(x<=0 || x >= 600-32) velX *= -1;
            }

            @Override
            public void render(Graphics g) {

            }
        };
        handler = new Handler();
        handler.addObject(new tester(10, 10, 10, 10, ID.Player));*/
    }

    @Test
    public void isColliding1() {
        result = Collision.isColliding(tester);
        //setup



    }

    @Test
    public void iscollidingTop() {
    }
}