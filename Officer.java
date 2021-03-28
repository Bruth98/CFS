import java.util.ArrayList;
public class Officer extends User{
    protected String firstName;
    protected String lastName;
    protected String department;
    public Officer() {
        super();
        this.firstName = "None";
        this.lastName = "None";
        this.department = "None";
    }
    
    public Officer(String firstName, String lastName, String department) {
        super();
        this.firstName= firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public int getEmployeeID() {
        return this.employeeID;
    }

    public String getDepartment(){
        return this.department;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void addSuspect(String name, String address, int age, int dob, String description,
                           String gender, String race, String hairColor, double height, double weight,
                           boolean tattoo, boolean criminalRecord, ArrayList<String> familyMembers) {
        //Suspect suspect = new Suspect(name, address, age, dob, description, gender, race, hairColor, height, weight, tattoo, criminalRecord, familyMembers);
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
