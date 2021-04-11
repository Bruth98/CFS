/*
DataLoader class tested by Michael Sana
*/

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class DataLoaderTest {
    //initalizations for User
    private static Users users = Users.getInstance();
    private static ArrayList<User> userList = users.getUsers();
    //initalizations for Admin
    private Admins admins = Admins.getInstance();
    private ArrayList<Admin> adminList = admins.getAdmins();
    //initalizations for Person
    private Persons persons = Persons.getInstance();
    private ArrayList<Person> personList = persons.getPerson();

    @BeforeClass
    public static void oneTimeSetUp(){

    }

    @AfterClass
    public static void oneTimeTearDown(){

    }

    @BeforeEach
    public void setup(){
        //runs before each test
        userList.clear();
        userList.add(new User(00, "abcd"));
        userList.add(new User(01, "efgh"));
        DataWriter.saveUsers();

       // adminList.clear();
        adminList.add(new Admin("Michael", "Sana", "investigation", 00));
        adminList.add(new Admin("Brady", "Ruth", "cyber crimes", 01));
        DataWriter.saveAdmins();

        personList.clear();
        personList.add(new Person("Michael Sana", "105 Sandhurst Drive", 042601, 19,"white male"));
        personList.add(new Person("Brady Ruth", "Somewhere in Cola", 000000, 20, "White male"));
        DataWriter.savePersons();


    }   

    @AfterEach
    public void teardown(){
        //runs at the end of each test
        Users.getInstance().getUsers().clear();
        DataWriter.saveUsers();

        Admins.getInstance().getAdmins().clear();
        DataWriter.saveAdmins();

        Persons.getInstance().getPerson().clear();
        DataWriter.savePersons();
    }
    //assertEquals(val1,val2)
    //assertFalse(val)
    //assertTrue(val)
    //assertSame(val1,val2)
    //assertNotSame(val1,val2)
    //asserNull(val)
    //assertNotNull(val)

    //All 'User' tests done by Michael Sana
    @Test
    void testGetUsersSize(){
        userList = DataLoader.loadUsers();
        assertEquals(2, userList.size());
    }

    @Test
    void testGetUsersSizeZero(){
        Users.getInstance().getUsers().clear();
        DataWriter.saveUsers();
        assertEquals(0,userList.size());
    }

    @Test
    void testGetUserFirstUserID(){
        userList = DataLoader.loadUsers();
        assertEquals(00, userList.get(0).getUserID());
}

    @Test
    void testGetUserFirstUserPassword(){
        userList = DataLoader.loadUsers();
        assertEquals("abcd", userList.get(1).getPassword());
    }

    @Test
    void testGetUserSecondUserID(){
        userList = DataLoader.loadUsers();
        assertEquals("01", userList.get(3).getUserID());
    }

    @Test
    void testGetUserSecondUserPassword(){
        userList = DataLoader.loadUsers();
        assertEquals("efgh", userList.get(4).getPassword());
    }

    @Test
    void testGetAdminsSize(){
        adminList = DataLoader.loadAdmins();
        assertEquals(2, adminList.size());
    }

    @Test
    void testGetAdminSizeZero(){
        Admins.getInstance().getAdmins().clear();
        DataWriter.saveAdmins();
        assertEquals(0,adminList.size());
    }

    @Test
    void testGetAdminFirstAdminFirstName(){
        adminList = DataLoader.loadAdmins();
        assertEquals("Michael", adminList.get(0).getFirstName());
    }

    @Test
    void testGetAdminFirstAdminLastName(){
        adminList = DataLoader.loadAdmins();
        assertEquals("Sana", adminList.get(1).getLastName());
    }    

    @Test
    void testGetAdminFirstAdminDepartment(){
        adminList = DataLoader.loadAdmins();
        assertEquals("investigation", adminList.get(2).getDepartment());
    }

    @Test
    void testGetAdminFirstAdminID(){
        adminList = DataLoader.loadAdmins();
        assertEquals(00, adminList.get(3).getUserID());
    }

    @Test
    void testGetAdminSecondAdminFirstName(){
        adminList = DataLoader.loadAdmins();
        assertEquals("Brady", adminList.get(4).getFirstName());
    }

    @Test
    void testgetAdminSecondAdminLastName(){
        adminList = DataLoader.loadAdmins();
        assertEquals("Ruth", adminList.get(5).getLastName());
    }

    @Test
    void testGetAdminSecondAdminDepartment(){
        adminList = DataLoader.loadAdmins();
        assertEquals("cyber crimes", adminList.get(6).getDepartment());
    }

    @Test
    void testGetAdminSecondAdminID(){
        adminList = DataLoader.loadAdmins();
        assertEquals(01, adminList.get(7).getUserID());
    }

}
