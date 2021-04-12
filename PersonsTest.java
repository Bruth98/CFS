/*
Persons class tested by Brady Ruth
*/
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
public class PersonsTest {
    private Persons persons = Persons.getInstance();
    private ArrayList<Person> personList = persons.getPerson();

    // Setup the Person ArrayList to include two People for every test
    @BeforeEach
    public void setup() {
        personList.clear();
        personList.add(new Person("name", "address", 01012000, 21, "description"));
        personList.add(new Person("name2", "address2", 010120001, 20, "description2"));
        DataWriter.savePersons();
    }

    // Tear down the Person ArrayList after each test
    @AfterEach
    public void tearDown() {
        Persons.getInstance().getPerson().clear();
        DataWriter.savePersons();
    }

    // Testing for a valid first Person in the ArrayList
    @Test
    public void testHaveValidFirstPerson() {
        boolean hasFirst = persons.havePerson("name", "address", 01012000, "description");
        assertTrue(hasFirst);
    }

    // Testing for a valid second Person in the ArrayList
    @Test
    public void testHaveValidSecondPerson() {
        boolean hasLast = persons.havePerson("name2", "address2", 01012001, "description2");
        assertTrue(hasLast);
    }

    // Testing for an invalid Person in the ArrayList
    @Test
    public void testHaveInvalidPerson() {
        boolean hasInvalid = persons.havePerson("test", "test", 01012002, "test");
        assertFalse(hasInvalid);
    }

    // Testing adding a Person to the ArrayList
    @Test
    public void testAddPerson() {
        persons.addPerson("testName", "testAddress", 11111111, 21, "testDescription");
        boolean hasPerson = persons.havePerson("testName", "testAddress", 11111111, "testDescription");
        assertTrue(hasPerson);
    }


}
