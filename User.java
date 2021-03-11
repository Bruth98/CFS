public class User {
    protected String userID;
    protected String password;
    public User() {

    }
    public User(String userID, String password) {

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
}