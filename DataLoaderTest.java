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
    private static Users users = Users.getInstance();
    private static ArrayList<User> userList = users.getUsers();

    @BeforeClass
    public static void oneTimeSetUp(){

    }

    @AfterClass
    public static void oneTimeTearDown(){

    }

    @BeforeEach
    public static void setup(){
        //runs before each test
        userList.clear();
        userList.add(new User(00, "abcd"));
        userList.add(new User(01, "efgh"));
        DataWriter.saveUsers();


    }   

    @AfterEach
    public static void teardown(){
        //runs at the end of each test
        Users.getInstance().getUsers().clear();
        DataWriter.saveUsers();
    }
    //assertEquals(val1,val2)
    //assertFalse(val)
    //assertTrue(val)
    //assertSame(val1,val2)
    //assertNotSame(val1,val2)
    //asserNull(val)
    //assertNotNull(val)

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
}
