public class CFS {
    private Users users;
    private Cases cases;
    private Suspects suspects;
    private EvidenceList evidence;
    private Witnesses witnesses;
    private Victims victims;
    private User currentUser;
    
    public CFS() {
        users = Users.getInstance();
        cases = Cases.getInstance();
        suspects = Suspects.getInstance();
        criminals = Criminals.getInstance();
        evidence = evidenceList.getInstance();
        witnesses = Witnesses.getInstance();
        victims = Victims.getInstance();
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

    public boolean getCases(String keyword) {
        return cases.haveKeyword(keyword);
    }

    public boolean getEvidence(String keyword) {
        return evidence.haveKeyword(keyword);
    }

    public boolean getSuspects(String name, int dob) {
        return suspects.haveSuspect(name, dob);
    }

    public boolean getCriminal(String firstName, String lastName) {
        return criminals.haveName(firstName, lastName);
    }

    public boolean getWitnesses(String firstName, String lastName) {
        return witnesses.haveName(firstName, lastName);
    }

    public boolean getVictims(String firstName, String lastName) {
        return victims.haveName(firstName, lastName);
    }

    public void logout() {
        users.saveUsers();
    }



    
}
