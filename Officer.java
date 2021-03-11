import java.util.ArrayList;
public class Officer extends User{
    public Officer() {
        super();
    }
    
    public Officer(String firstName, String lastName) {
        super();
    }

    public String getName() {
        return "";
    }

    public int getEmployeeID() {
        return 0;
    }

    public void addSuspect(String name, String address, int age, int dob, String description,
                           String gender, String race, String hairColor, double height, double weight,
                           boolean tattoo, boolean criminalRecord, ArrayList<String> familyMembers) {

                           }

    public void addWitness(String name, String address, int age, int dob, String description, 
                           ArrayList<String> incidentReport, boolean relationToVictim) {

    }

    public void addVictim(String name, String address, int age, int dob, String description,
                          ArrayList<String> incidentReport, boolean alive, int phoneNum) {

    }

    public void addCase(Crime crime, ArrayList<Suspect> suspects, ArrayList<Witness> witnesses, 
    ArrayList<Victim> victims, ArrayList<Evidence> evidence, int caseID, int date, String location) {

    }

    public void addEvidence(String description, boolean fingerprints, boolean weapon, boolean drugs, String location, ArrayList<String> witnesses) {

    }
}
