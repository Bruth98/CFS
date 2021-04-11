/*
Witness class tested by Brady Ruth
*/
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
public class WitnessTest {
    private Witnesses witnesses = Witnesses.getInstance();
    private ArrayList<Witness> witnessList = witnesses.getWitnesses();

    // Setup the Witness ArrayList to have two Witness objects every time
    @BeforeEach
    public void setup() {
        witnessList.clear();
        witnessList.add(new Witness("name", "address", 01012000, "description", true));
        witnessList.add(new Witness("name2", "address2", 01012001, "description2", true));
        DataWriter.saveWitness();
    }

    // Tear down the Witness ArrayList after each test
    @AfterEach
    public void tearDown() {
        Witnesses.getInstance().getWitnesses().clear();
        DataWriter.saveWitness();
    }

    // Testing for valid first Witness in ArrayList
    @Test
    public void testHaveValidFirstWitness() {
        boolean hasFirst = witnesses.haveWitness("name", 01012000);
        assertTrue(hasFirst);
    }

    // Testing for valid second Witness in ArrayList
    @Test
    public void testHaveValidSecondWitness() {
        boolean hasLast = witnesses.haveWitness("name2", 01012001);
        assertTrue(hasLast);
    }

    // Testing for invalid witness in the ArrayList
    @Test
    public void testHaveInvalidWitness() {
        boolean hasInvalid = witnesses.haveWitness("test", 11111111);
        assertFalse(hasInvalid);
    }

    // Testing adding a Witness to the ArrayList
    @Test
    public void testAddWitness() {
        witnesses.addWitness("testName", "testAddress", 11111111, "testDescription", true);
        boolean hasWitness = witnesses.haveWitness("testName", 11111111);
        assertTrue(hasWitness);
    }




}
