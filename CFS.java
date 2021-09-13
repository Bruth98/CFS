/*
This class links our UI with the JSON database so that all the variables in a case can be properly loaded, checked against, and added if needed.
*/

public class CFS {
    private Users users;
    private Cases cases;
    private Suspects suspects;
    private Evidences evidence;
    private Witnesses witnesses;
    private Victims victims;
    private User currentUser;
    private static Database database;
    
    /*
    create an instance of the database
    */
    public CFS() {
        users = Users.getInstance();
        cases = Cases.getInstance();
        suspects = Suspects.getInstance();
        evidence = Evidences.getInstance();
        witnesses = Witnesses.getInstance();
        victims = Victims.getInstance();
    }

    /*
    Add a user to the database
    */
    public boolean createAccount(int userID, String password) {
        return users.addUser(userID, password);
    }

    /*
    Check to see if the entered log in information is stored in the database
    */
    public boolean login(int userID, String password) {
        if (!users.haveUser(userID, password)) {
            return false;
        }   
        return true;
    }

    /*
    Search the database to see if a specific case ID exists
    */
    public boolean findCases(int caseID) {
        return cases.haveCase(caseID);
    }
    
    /*
    Search the database to return a Case with a specific case ID
    */
    public Case getCase(int caseID) {
        return cases.getCase(caseID);
    }

    /*
    Saves all updates to the database
    */
    public void logout() {
        users.saveUsers();
        cases.saveCases();
        suspects.saveSuspects();
        evidence.saveEvidence();
        witnesses.saveWitness();
        victims.saveVictim();
    }



    
}
