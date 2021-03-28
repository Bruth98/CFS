import java.util.ArrayList;
public class Witness extends Person{
    //private ArrayList<String> incidentReport;
    private boolean relationToVictim;

    public Witness(){
        super();
        //this.incidentReport = null;
        this.relationToVictim = false;
    }

    public Witness(String name, String address, String description, int dob, boolean relationToVictim){
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
}
