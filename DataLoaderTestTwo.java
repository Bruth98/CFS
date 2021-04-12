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

    private Crimes crimes = Crimes.getInstance();
    private ArrayList<Crime> crimeList = crimes.getCrimes();

    @BeforeEach
    public void setup(){
        personList.clear();
        personList.add(new Person("Michael Sana", "105 Sandhurst Drive", 042601, 19,"white male"));
        personList.add(new Person("Brady Ruth", "Somewhere in Cola", 000000, 20, "White male"));
        DataWriter.savePersons();

        crimeList.clear();
        crimeList.add(new Crime("robbery", true));
        crimeList.add(new Crime("shooting", false));
        DataWriter.saveCrimes();
    }

    @AfterEach
    public void tearDown(){
        Persons.getInstance().getPerson().clear();
        DataWriter.savePersons();

        Crimes.getInstance().getCrimes().clear();
        DataWriter.saveCrimes();
    }
    
    @Test
    public void testGetPersonFirstPersonName(){
        personList = DataLoader.loadPersons();
        assertEquals("Michael Sana", personList.get(0).getName());
    }

    @Test
    public void testGetPersonSize(){
        personList = DataLoader.loadPersons();
        assertEquals(2, personList.size());
    }

    @Test
    public void testGetPersonSizeZero(){
        Persons.getInstance().getPerson().clear();
        DataWriter.savePersons();
        assertEquals(0, personList.size());
    }


    @Test
    public void testGetPersonFirstPersonDOB(){
        personList = DataLoader.loadPersons();
        assertEquals(042601, personList.get(2).getDOB());
    }

    @Test
    public void testGetPersonFirstPersonAge(){
        personList = DataLoader.loadPersons();
        assertEquals(19, personList.get(3).getAge());
    }

    @Test
    public void testGetPersonFirstPersonDescription(){
        personList = DataLoader.loadPersons();
        assertEquals("white male", personList.get(4).getDescription());
    }

    @Test
    public void testGetPersonFirstPersonAddress(){
        personList = DataLoader.loadPersons();
        assertEquals("105 Sandhurst Drive", personList.get(5).getAddress());
    }


    //second person

    @Test
    public void testGetPersonSecondPersonName(){
        personList = DataLoader.loadPersons();
        assertEquals("Brady Ruth", personList.get(6).getName());
    }
    @Test
    public void testGetPersonSecondPersonDOB(){
        personList = DataLoader.loadPersons();
        assertEquals(000000, personList.get(7).getDOB());
    }

    @Test
    public void testGetPersonSecondPersonAge(){
        personList = DataLoader.loadPersons();
        assertEquals(20, personList.get(8).getAge());
    }

    @Test
    public void testGetPersonSecondPersonDescription(){
        personList = DataLoader.loadPersons();
        assertEquals("white male", personList.get(9).getDescription());
    }

    @Test
    public void testGetPersonSecondPersonAddress(){
        personList = DataLoader.loadPersons();
        assertEquals("Somewhere in cola", personList.get(10).getAddress());
    }

    @Test
    public void testGetCrimeSize(){
        crimeList = DataLoader.loadCrime();
        assertEquals(2, crimeList.size());
    }

    @Test
    public void testGetCrimeSizeZero(){
        Crimes.getInstance().getCrimes().clear();
        DataWriter.saveCrimes();
        assertEquals(0, crimeList.size());
    }

    @Test
    public void testGetCrimeFirstCrimeType(){
        crimeList = DataLoader.loadCrime();
        assertEquals("robbery", crimeList.get(0).getType());
    }

    @Test
    public void testGetCrimeFirstCrimeFelony(){
        crimeList = DataLoader.loadCrime();
        assertEquals(true, crimeList.get(1).isFelony());
    }

    @Test
    public void testGetCrimeSecondCrimeType(){
        crimeList = DataLoader.loadCrime();
        assertEquals("shooting", crimeList.get(2).getType());
    }

    @Test
    public void testGetCrimeSecondCrimeFelony(){
        crimeList = DataLoader.loadCrime();
        assertEquals(false, crimeList.get(3).getType());
    }

}
