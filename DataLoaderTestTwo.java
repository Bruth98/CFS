import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class DataLoaderTestTwo {
    private Persons persons = Persons.getInstance();
    private ArrayList<Person> personList = persons.getPerson();

    @BeforeEach
    public void setup(){
        personList.clear();
        personList.add(new Person("Michael Sana", "105 Sandhurst Drive", 042601, 19,"white male"));
        personList.add(new Person("Brady Ruth", "Somewhere in Cola", 000000, 20, "White male"));
        DataWriter.savePersons();
    }

    @AfterEach
    public void tearDown(){
        Persons.getInstance().getPerson().clear();
        DataWriter.savePersons();
    }
    @Test
    void testGetPersonFirstPersonName(){
        personList = DataLoader.loadPersons();
        assertEquals("Michael Sana", personList.get(0).getName());
    }
}
