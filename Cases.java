import java.util.ArrayList;
public class Cases {
    private static Cases cases;
    private static ArrayList<Case> caseList;
    
    private Cases() {
        caseList = DataLoader.loadCrime(); //Try to fix and if not done ask in meeting
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
        for (Case case : caseList) {
            if (case.getCaseID() == (caseID)) {
                return case;
            }
        }
        return null;
    }

    //add get user by ID
    public boolean addCase (Crime crime, ArrayList<Suspect> suspects, ArrayList<Witness> witnesses, ArrayList<Victim> victims, ArrayList<Evidence> evidence, int caseID, String date, String location) {
        if(haveCase(caseID)) {
            return false;
        }
        caseList.add(new Case(crime, suspects, witnesses, victims, evidence, caseID, date, location));
        return true;
    }

    public boolean haveCase(int caseID) {
        for (Case case : caseList) {
            if (case.getCaseID() == caseID) {
                return true;
            }
        }
        return false;
    }

    public void saveUsers() {
        DataWriter.saveUsers(); //Same as load
    }
}



