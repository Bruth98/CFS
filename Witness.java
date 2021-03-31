import java.util.ArrayList;
public class Witness extends Person{
    //private ArrayList<String> incidentReport;
    private boolean relationToVictim;

    public Witness() {
        super();
        this.relationToVictim = false;
    }

    public Witness(String name, String address, int dob, String description, boolean relationToVictim2) {
        super.name = name;
        super.address = address;
        super.dob = dob;
        super.description = description;
        this.relationToVictim = relationToVictim2;
    }

    /*
    public ArrayList<String> getIncidentReport(){
        return this.incidentReport;
    }
*/
    public boolean getRelation(){
        return this.relationToVictim;
    }

    public String toString() {
        return "Name: " +this.name+"\nAddress: "+this.address+"\nD.O.B.: "+this.dob+"\nRelationship to Victim? "+this.relationToVictim+"\nDescription:"+this.description;
    }
}
