/*
Cases stores a list of every cases added to the database to be checked against when searching
*/
import java.util.ArrayList;
public class Cases {
    private static Cases cases;
    private static ArrayList<Case> caseList = new ArrayList<Case>();  // Establish a new ArrayList to hold all cases
    
    /*
    Load all stored cases in the JSON database to caseList
    */
    private Cases() {
        caseList = DataLoader.loadCase();
    }

    public static Cases getInstance() {
        if (cases == null) {
            cases = new Cases();
        }
        return cases;
        }

    public ArrayList<Case> getCases() {
        return caseList;
    }

    /*
    Searches the case list for a specific Case ID
    */
    public Case getCase(int caseID) {
        for (Case case2 : caseList) {
            if (case2.getCaseID() == (caseID)) {
                return case2;
            }
        }
        return null;
    }

    /*
    Checks to see if an identical case already exists in the system
    */
    public boolean addCase (Crime crime, ArrayList<Suspect> suspects, ArrayList<Witness> witnesses, ArrayList<Victim> victims, ArrayList<Evidence> evidence, int caseID, int date, String location) {
        if(haveCase(caseID)) {
            return false;
        }
        caseList.add(new Case(crime, suspects, witnesses, victims, evidence, caseID, date, location));
        return true;
    }

    /*
    Search for Cases with a specific Case ID
    */
    public boolean haveCase(int caseID) {
        for (Case case2 : caseList) {
            if (case2.getCaseID() == caseID) {
                return true;
            }
        }
        return false;
    }
 
    /*
    Save the ArrayList of Cases in JSON format
    */
    public void saveCases() {
        DataWriter.saveCase(); 
    }
}



