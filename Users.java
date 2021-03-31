import java.util.ArrayList;

public class Users {
    private static Users users;
    private ArrayList<User> userList = new ArrayList<User>();
    
    private Users() {
        userList = DataLoader.loadUsers(); 
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
    //add get user by ID
    public boolean addUser(int userID, String password) {
        if(haveUser(userID, password)) {
            return false;
        }
        User user = new User(userID, password);
        userList.add(user);
        return true;
    }

    public boolean haveUser(int userID, String password) {
        if (userList == null) {
            return false;
        }
        for (User user : userList) {
            if (user.getUserID() == userID && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    public User getUser(int userID){
        for (User user : userList) {
            if(user.getUserID() == userID)
                return user;
        }
        return null;
    }
    public void saveUsers() {
        DataWriter.saveUsers(); 
    }
}

