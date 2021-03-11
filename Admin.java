import java.util.ArrayList;
public class Admin extends User{
    public Admin() {
        super();
    }
    
    public Admin(String firstName, String lastName) {
        super();
    }

    public String getName() {
        return "";
    }

    public int getEmployeeID() {
        return 0;
    }


    public void editSuspect(String name, String address, int age, int dob, String description,
                           String gender, String race, String hairColor, double height, double weight,
                           boolean tattoo, boolean criminalRecord, ArrayList<String> familyMembers) {

                           }

    public void editWitness(String name, String address, int age, int dob, String description, 
                           ArrayList<String> incidentReport, boolean relationToVictim) {

    }

    public void editVictim(String name, String address, int age, int dob, String description,
                          ArrayList<String> incidentReport, boolean alive, int phoneNum) {

    }

    public void editCase(Crime crime, ArrayList<Suspect> suspects, ArrayList<Witness> witnesses, 
    ArrayList<Victim> victims, ArrayList<Evidence> evidence, int caseID, int date, String location) {

    }

    public void editEvidence(String description, boolean fingerprints, boolean weapon, boolean drugs, String location, ArrayList<String> witnesses) {

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