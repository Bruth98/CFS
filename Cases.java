import java.util.ArrayList;
public class Cases {
    private static Cases cases;
    private static ArrayList<Case> caseList;
    
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

    public Case getCase(int caseID) {
        for (Case case2 : caseList) {
            if (case2.getCaseID() == (caseID)) {
                return case2;
            }
        }
        return null;
    }

    //add get user by ID
    public boolean addCase (Crime crime, ArrayList<Suspect> suspects, ArrayList<Witness> witnesses, ArrayList<Victim> victims, ArrayList<Evidence> evidence, int caseID, int date, String location) {
        if(haveCase(caseID)) {
            return false;
        }
        caseList.add(new Case(crime, suspects, witnesses, victims, evidence, caseID, date, location));
        return true;
    }

    public boolean haveCase(int caseID) {
        for (Case case2 : caseList) {
            if (case2.getCaseID() == caseID) {
                return true;
            }
        }
        return false;
    }

    public void saveCases() {
        DataWriter.saveCase(); 
    }
}



