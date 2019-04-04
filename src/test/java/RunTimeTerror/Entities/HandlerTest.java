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
    LinkedList<GameObject> object;

    @Before
    public void setUp() throws Exception {
        object = new LinkedList<>();
        temp = new TestPlayer(10,10,10,10,ID.Player);
        floor = new TestFloor(10,20,30,20,ID.Floor);
        tester = new Handler();
    }

    @After
    public void tearDown() throws Exception {
        temp = null;
        floor = null;
        tester = null;
        object = null;
    }

    @Test
    public void addObject() {
        tester.addObject(temp);
        
    }

    @Test
    public void removeObject() {
    }

    @Test
    public void isDead() {
    }
}