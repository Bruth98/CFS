/*
Users Class tested by Austin Odell
*/
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
public class CasesTest {
    private Cases cases = Cases.getInstance();
    private ArrayList<Case> caseList = cases.getCases();
    
    
    // Setup the Case ArrayList to have two Case objects every time
    @BeforeEach
    public void setup() {
        caseList.clear();
        Crime crime = new Crime("Murder", true);
        Suspect suspect = new Suspect("name", "address", 01012000, "description", "gender", "race", "haircolor", 200.00, 6.0, "tattoo", false, 20, 8675309);
        ArrayList<Suspect> suspects = new ArrayList<Suspect>();
        suspects.add(suspect);
        Witness witness = new Witness("name", "address", 01012000, "description", false);
        ArrayList<Witness> witnesses = new ArrayList<Witness>();
        witnesses.add(witness);
        Victim victim = new Victim("name", "address", 01012000, "description", false, 8675309);
        ArrayList<Victim> victims = new ArrayList<Victim>();
        victims.add(victim);
        Evidence evidence = new Evidence("description", "location", false, false, false);
        ArrayList<Evidence> evidences = new ArrayList<Evidence>();
        evidences.add(evidence);
        caseList.add(new Case(crime, suspects, witnesses, victims, evidences, 001, 01012000, "location"));
        
        Crime crime2 = new Crime("Stealing your girl", false);
        Suspect suspect2 = new Suspect("name2", "address2", 01012001, "description2", "gender2", "race2", "haircolor2", 200.01, 6.1, "tattoo2", true, 21, 8675308);
        ArrayList<Suspect> suspects2 = new ArrayList<Suspect>();
        suspects.add(suspect2);
        Witness witness2 = new Witness("name2", "address2", 01012001, "description2", false);
        ArrayList<Witness> witnesses2 = new ArrayList<Witness>();
        witnesses.add(witness2);
        Victim victim2 = new Victim("name2", "address2", 01012001, "description2", true, 8675308);
        ArrayList<Victim> victims2 = new ArrayList<Victim>();
        victims.add(victim2);
        Evidence evidence2 = new Evidence("description2", "location2", true, true, true);
        ArrayList<Evidence> evidences2 = new ArrayList<Evidence>();
        evidences.add(evidence2);
        caseList.add(new Case(crime2, suspects2, witnesses2, victims2, evidences2, 002, 01012001, "location2"));
        DataWriter.saveUsers();
    }

    // Tear down the Case ArrayList after each test
    @AfterEach
    public void tearDown() {
        Cases.getInstance().getCases().clear();
        DataWriter.saveCase();
    }

    // Testing for valid first Case in ArrayList
    @Test
    public void testHaveValidFirstCase() {
        boolean hasFirst = cases.haveCase(001);
        assertTrue(hasFirst);
    }

    // Testing for valid last Case in ArrayList
    @Test
    public void testHaveValidLastCase() {
        boolean hasLast = cases.haveCase(002);
        assertTrue(hasLast);
    }

    // Testing for an invalid Case in ArrayList
    @Test
    public void testHaveInvalidCase() {
        boolean hasInvalid = cases.haveCase(420);
        assertFalse(hasInvalid);
    }

    // Testing adding a Case to ArrayList
    @Test
    public void testAddCase() {
        Crime crime3 = new Crime("Murder", true);
        Suspect suspect3 = new Suspect("name3", "address3", 01012002, "description3", "gender", "race", "haircolor", 200.00, 6.0, "tattoo", false, 20, 8675309);
        ArrayList<Suspect> suspects3 = new ArrayList<Suspect>();
        suspects3.add(suspect3);
        Witness witness3 = new Witness("name3", "address3", 01012002, "description3", false);
        ArrayList<Witness> witnesses3 = new ArrayList<Witness>();
        witnesses3.add(witness3);
        Victim victim3 = new Victim("name3", "address3", 01012002, "description3", false, 8675309);
        ArrayList<Victim> victims3 = new ArrayList<Victim>();
        victims3.add(victim3);
        Evidence evidence3 = new Evidence("description3", "location3", false, false, false);
        ArrayList<Evidence> evidences3 = new ArrayList<Evidence>();
        evidences3.add(evidence3);
        cases.addCase(crime3, suspects3, witnesses3, victims3, evidences3, 60, 01012003, "location4");
        boolean hasCase = cases.haveCase(50);
        assertTrue(hasCase);
    }

    // Testing getting a Case from ArrayList
    @Test
    public void testGetCase() {
        Crime crime = new Crime("Murder", true);
        Suspect suspect = new Suspect("name", "address", 01012000, "description", "gender", "race", "haircolor", 200.00, 6.0, "tattoo", false, 20, 8675309);
        ArrayList<Suspect> suspects = new ArrayList<Suspect>();
        suspects.add(suspect);
        Witness witness = new Witness("name", "address", 01012000, "description", false);
        ArrayList<Witness> witnesses = new ArrayList<Witness>();
        witnesses.add(witness);
        Victim victim = new Victim("name", "address", 01012000, "description", false, 8675309);
        ArrayList<Victim> victims = new ArrayList<Victim>();
        victims.add(victim);
        Evidence evidence = new Evidence("description", "location", false, false, false);
        ArrayList<Evidence> evidences = new ArrayList<Evidence>();
        evidences.add(evidence);
        Case test = new Case(crime, suspects, witnesses, victims, evidences, 001, 01012000, "location");
        Case case2 = cases.getCase(001);
        assertSame(test, case2);
    }


}
