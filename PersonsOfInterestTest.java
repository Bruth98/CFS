/*
PersonsOfInterest tested by Brady Ruth
*/
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class PersonsOfInterestTest {
    private PersonsOfInterest poi = PersonsOfInterest.getInstance();
    private ArrayList<PersonOfInterest> poiList = poi.getPerson();
    
    // Setup the User ArrayList to have two User objects every time
    @BeforeEach
    public void setup() {
        poiList.clear();
        poiList.add(new PersonOfInterest("Name", "address", 01012000, 21, "description", "male",
        "caucasian","brown", 5.10, 185, "tattooDescription", false));
        poiList.add(new PersonOfInterest("Second", "address2", 01012001, 20, "description2", "female",
        "caucasian","blonde", 5.06, 135, "tattooDescription2", true));
        DataWriter.savePersonOfInterest();
    }

    // Tear down the User ArrayList after each test
    @AfterEach
    public void tearDown() {
        PersonsOfInterest.getInstance().getPerson().clear();
        DataWriter.saveUsers();
    }
    
    // Testing for valid first POI in ArrayList
    @Test
    public void testHaveValidFirstPOI() {
        boolean hasFirst = poi.havePersonOfInterest("Name", "address", 01012000, "description");
        assertTrue(hasFirst);
    }

    // Testing for valid second POI in ArrayList
    @Test
    public void testHaveValidSecondPOI() {
        boolean hasLast = poi.havePersonOfInterest("Second", "address2", 01012001, "description2");
        assertTrue(hasLast);
    }

    // Testing for invalid POI in ArrayList
    @Test
    public void testHaveInvalidPOI() {
        boolean hasInvalid = poi.havePersonOfInterest("invalid", "invalid", 11111111, "invalid");
        assertFalse(hasInvalid);
    }

    // Testing adding a POI to the ArrayList
    @Test
    public void testAddPOI() {
        poi.addPersonOfInterest("testName", "testAddress", 11111111, 22, "testDesc", "testGender", "testRace", "testHair", 1.0, 1.0, "testTat", false);
        boolean hasPOI = poi.havePersonOfInterest("testName", "testAddress", 11111111, "testDesc");
        assertTrue(hasPOI);
    }
}