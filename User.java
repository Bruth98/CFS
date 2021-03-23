import java.util.ArrayList;

public class User {
    protected int employeeID;
    protected String password;
    public User() {
        this.employeeID = 0;
        this.password = "password";
    }
    public User(int employeeID, String password) {
        this.employeeID = employeeID;
        this.password = password;
    }

    public String getSuspect(String firstName, String lastName) {
        return null;
    }

    public Evidence getEvidence(String keyword) {
        return null;
    }

    public Case getCase() {
        return null;
    }

    public Case getCaseBySuspect(String name) {
        return null;
    }

    public Case getCaseByCrime(String crime) {
        return null;

    }

    public int getUserID() {
        return this.employeeID;
    }

    public String getPassword() {
        return this.password;
    }

	public ArrayList<User> getUser() {
		return null;
	}
	public static User getInstance() {
		return null;
	}
	public static User getInstance() {
		return null;
	}
	public static User getInstance() {
		return null;
	}
}