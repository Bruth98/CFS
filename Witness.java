import java.util.ArrayList;
public class Witness extends Person{
    //private ArrayList<String> incidentReport;
    private boolean relationToVictim;

    public Witness(String name, String address, int dob, String description, boolean relationToVictim2) {
        super();
        //this.incidentReport = incidentReport;
        this.relationToVictim = relationToVictim;
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
