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

        //adminList.clear();
        adminList.add(new Admin("Michael", "Sana", "investigation", 00));
        adminList.add(new Admin("Brady", "Ruth", "cyber crimes", 01));
        DataWriter.saveAdmins();



    }   

    @AfterEach
    public void teardown(){
        //runs at the end of each test
        Users.getInstance().getUsers().clear();
        DataWriter.saveUsers();

        Admins.getInstance().getAdmins().clear();
        DataWriter.saveAdmins();
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
}
