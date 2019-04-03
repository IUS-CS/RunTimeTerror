package RunTimeTerror.Entities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class GameObjectTest {
    GameObject tester;

    @Before
    public void setUp() throws Exception {
        tester = new GameObject(10,10,10,10,ID.Player) {
            @Override
            public void tick() {

            }

            @Override
            public void render(Graphics g) {

            }
        };
    }

    @Test
    public void setX() {
        tester.setX(15);
        int results = tester.getX();
        System.out.println("setting x for object");
        assertEquals(15, results);
    }

    @Test
    public void setY() {
        tester.setY(15);
        int results = tester.getY();
        System.out.println("setting y for object");
        assertEquals(15, results);
    }

    @Test
    public void getX() {
        int results = tester.getX();
        System.out.println("Getting X for object");
        assertEquals(10, results);
    }

    @Test
    public void getY() {
        int results = tester.getY();
        System.out.println("Getting Y for object");
        assertEquals(10, results);
    }

    @Test
    public void setId() {
        ID temp = ID.Enemy;
        tester.setId(temp);
        ID results = tester.getId();
        System.out.println("Setting the object ID");
        assertEquals(temp, results);
    }

    @Test
    public void getId() {
        ID temp = ID.Player;
        ID results = tester.getId();
        System.out.println("Getting the object ID");
        assertEquals(temp, results);
    }

    @Test
    public void setVelX() {
        tester.setVelX(5);
        int results = tester.getVelX();
        System.out.println("setting Velocity X of object");
        assertEquals(5, results);

    }

    @Test
    public void getVelX() {
        int results = tester.getVelX();
        System.out.println("getting Velocity X of object");
        assertEquals(0, results);
    }

    @Test
    public void setVelY() {
        tester.setVelY(5);
        int results = tester.getVelY();
        System.out.println("setting Velocity y of object");
        assertEquals(5, results);
    }

    @Test
    public void getVelY() {
        int results = tester.getVelY();
        System.out.println("getting Velocity X of object");
        assertEquals(0, results);
    }



    @After
    public void tearDown() throws Exception {
        tester = null;
    }
}