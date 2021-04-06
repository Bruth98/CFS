public class CFS {
    private Users users;
    private Cases cases;
    private Suspects suspects;
    private Evidences evidence;
    private Witnesses witnesses;
    private Victims victims;
    private User currentUser;
    private static Database database;
    
    public CFS() {
        users = Users.getInstance();
        cases = Cases.getInstance();
        suspects = Suspects.getInstance();
        evidence = Evidences.getInstance();
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

    public boolean findCases(int caseID) {
        return cases.haveCase(caseID);
    }

    public Case getCase(int caseID) {
        return cases.getCase(caseID);
    }

    public void logout() {
        users.saveUsers();
        cases.saveCases();
        suspects.saveSuspects();
        evidence.saveEvidence();
        witnesses.saveWitness();
        victims.saveVictim();
    }



    
}
