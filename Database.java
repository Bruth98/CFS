public class Database {
    private Users users;
    private Cases cases;
    private evidenceList evidence;
    private User currentUser;
    
    public Database() {
        users = Users.getInstance();

    }

    public boolean createAccount(int userID, String password) {
        return users.addUser(userID, password);
    }

    public boolean login(int userID, String password) {
        if (!users.haveUser(userID, password)) {
            return false;
        }
        
        return true;
    }
    
}
