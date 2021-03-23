import java.util.ArrayList;

public class Users {
    private static Users users = null;
    private static ArrayList<User> userList = new ArrayList<User>();
    
    private Users() {
        userList = DataLoader.loadUsers(); //Try to fix and if not done ask in meeting
    }

    public static Users getInstance() {
        if (users == null) {
            users = new Users();
        }
        return users;
        }

    public ArrayList<User> getUsers() {
        return userList;
    }

    public boolean addUser(int userID, String password) {
        if(haveUser(userID, password)) {
            return false;
        }
        userList.add(new User(userID, password));
        return true;
    }

    public boolean haveUser(int userID, String password) {
        for (User user : userList) {
            if (user.getUserID() == userID && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void saveUsers() {
        DataWriter.saveUsers(); //Same as load
    }
}

