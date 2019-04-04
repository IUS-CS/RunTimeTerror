package RunTimeTerror.Entities;

import RunTimeTerror.Test.TestFloor;
import RunTimeTerror.Test.TestPlayer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class HandlerTest {

    TestPlayer temp;
    TestFloor floor;
    Handler tester;

    @Before
    public void setUp() throws Exception {
        temp = new TestPlayer(10,10,10,10,ID.Player);
        floor = new TestFloor(10,20,30,20,ID.Floor);
        tester = new Handler();
    }

    @After
    public void tearDown() throws Exception {
        temp = null;
        floor = null;
        tester = null;
    }

    @Test
    public void addObject() {
        tester.addObject(temp);
        GameObject results = tester.object.peek();
        System.out.println("Added temp to handler");
        assertEquals(temp, results);
    }
    @Test
    public void addObject2() {
        tester.addObject(temp);
        tester.addObject(floor);
        GameObject results = tester.object.get(1);
        System.out.println("Added temp to handler");
        assertEquals(floor, results);
    }

    @Test
    public void removeObject() {
        tester.addObject(temp);
        tester.removeObject(temp);
        GameObject results = tester.object.peek();
        System.out.println("removed temp from handler");
        assertEquals(null, results);
    }
    @Test
    public void removeObject2() {
        tester.addObject(temp);
        tester.addObject(floor);
        tester.removeObject(temp);
        GameObject results = tester.object.peek();
        System.out.println("removed temp from handler");
        assertEquals(floor, results);
    }
    @Test
    public void removeObject3() {
        tester.addObject(temp);
        tester.addObject(floor);
        tester.removeObject(floor);
        GameObject results = tester.object.getLast();
        System.out.println("removed floor from handler");
        assertEquals(temp, results);
    }

    @Test
    public void isDead() {
        tester.addObject(temp);
        tester.addObject(floor);
        temp.alive = false;
        temp.setY(500);
        tester.isDead();
        GameObject results = tester.object.peek();
        System.out.println("temp is dead and removed from handler");
        assertEquals(floor, results);
    }
}