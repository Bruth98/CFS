/*
Users Class tested by Brady Ruth
*/
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
public class UsersTest {
    private Users users = Users.getInstance();
    private ArrayList<User> userList = users.getUsers();
    
    // Setup the User ArrayList to have two User objects every time
    @BeforeEach
    public void setup() {
        userList.clear();
        userList.add(new User(1111, "abcd"));
        userList.add(new User(1234, "password"));
        DataWriter.saveUsers();
    }

    // Tear down the User ArrayList after each test
    @AfterEach
    public void tearDown() {
        Users.getInstance().getUsers().clear();
        DataWriter.saveUsers();
    }

    // Testing for valid first User in ArrayList
    @Test
    public void testHaveValidFirstUser() {
        boolean hasFirst = users.haveUser(1111, "abcd");
        assertTrue(hasFirst);
    }

    // Testing for valid last User in ArrayList
    @Test
    public void testHaveValidLastUser() {
        boolean hasLast = users.haveUser(1234, "password");
        assertTrue(hasLast);
    }

    // Testing for an invalid User in ArrayList
    @Test
    public void testHaveInvalidUser() {
        boolean hasInvalid = users.haveUser(4321, "test");
        assertFalse(hasInvalid);
    }

    // Testing adding a User to ArrayList
    @Test
C    public void testAddUser() {
        users.addUser(9999, "test");
        boolean hasUser = users.haveUser(9999, "test");
        assertTrue(hasUser);
    }

    // Testing getting a User from ArrayList
    @Test
    public void testGetUser() {
        User test = new User(1111, "abcd");
        User user = users.getUser(1111);
        assertSame(test, user);
    }


}
