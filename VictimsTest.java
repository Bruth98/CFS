/*
Victims class tested by Brady Ruth
*/

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class VictimsTest {
    private Victims victims = Victims.getInstance();
    private ArrayList<Victim> victimList = victims.getVictims();

    // Setup the Victim ArrayList to have two Victim objects every time
    @BeforeEach
    public void setup() {
        victimList.clear();
        victimList.add(new Victim("name", "address", 01012000, "description", true, 1111111111));;
        victimList.add(new Victim("name2", "address2", 010120001, "description2", true, 1111112222));
        DataWriter.saveVictims();
    }

    // Tear down the victim ArrayList after each test
    @AfterEach
    public void tearDown() {
        Victims.getInstance().getVictims().clear();
        DataWriter.saveVictims();
    }

    // Testing for a valid first Victim in ArrayList
    @Test
    public void testHaveValidFirstVictim() {
        boolean hasFirst = victims.haveVictim("name", 01012000);
        assertTrue(hasFirst);
    }

    // Testing for a valid second Victim in ArrayList
    @Test
    public void testHaveValidSecondVictim() {
        boolean hasLast = victims.haveVictim("name2", 01012001);
        assertTrue(hasLast);
    }

    // Testing for an invalid Victim in ArrayList
    @Test
    public void testHaveInvalidVictim () {
        boolean hasInvalid = victims.haveVictim("test", 11111111);
        assertFalse(hasInvalid);
    }

    // Testing adding a Victim to the ArrayList
    @Test
    public void testAddVictim() {
        victims.addVictim("testName", "testAddress", 11111111, "testDescription", true, 1112222222);
        boolean hasVictim = victims.haveVictim("testName", 11111111);
        assertTrue(hasVictim);
    }
}
