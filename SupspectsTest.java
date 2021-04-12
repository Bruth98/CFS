/*
Suspects class tested by Brady Ruth
*/
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class SupspectsTest {
    private Suspects suspects = Suspects.getInstance();
    private ArrayList<Suspect> susList = suspects.getSuspects();

    // Setup the Suspect ArrayList to have two Suspect objects for every test
    @BeforeEach
    public void setup() {
        susList.clear();
        susList.add(new Suspect("Name", "address", 01012000, "description", "male",
        "caucasian","brown", 5.10, 185, "tattooDescription", false, 21, 1111111111));
        susList.add(new Suspect("Second", "address2", 01012001, "description2", "female",
        "caucasian","blonde", 5.06, 135, "tattooDescription2", true, 20, 1111112222));
        DataWriter.saveSuspects();
    }

    // Tear down the Suspect ArrayList after each test
    @AfterEach
    public void tearDown() {
        Suspects.getInstance().getSuspects().clear();
        DataWriter.saveSuspects();
    }

    // Testing for a valid first Suspect in the ArrayList
    @Test
    public void testHaveValidFirstSuspect() {
        boolean hasFirst = suspects.haveSuspect("Name", 01012000);
        assertTrue(hasFirst);
    }

    // Testing for a valid second Suspect in the ArrayList
    @Test
    public void testHaveValidSecondSuspect() {
        boolean hasLast = suspects.haveSuspect("Second", 01012001);
        assertTrue(hasLast);
    }

    // Testing for invalid Suspect in the ArrayList
    @Test
    public void testHaveInvalidSuspect() {
        boolean hasInvalid = suspects.haveSuspect("Invalid", 1);
        assertFalse(hasInvalid);
    }

    // Testing the ability to add a suspect to the ArrayList
    @Test
    public void testAddSuspect() {
        suspects.addSuspect("testName", "testAddress", 11111111, 21, "testDescription", "testGender", "testRace", "testHairColor", 1.0, 1.0, "testTattoo", false, 1111111111);
        boolean hasSuspect = suspects.haveSuspect("testName", 11111111);
        assertTrue(hasSuspect);
    }
}
