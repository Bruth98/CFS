import java.util.ArrayList;
//uml done
import org.json.simple.JSONArray;
public class Case {
    private Crime crime;
    private ArrayList<Suspect> suspects;
    private ArrayList<Witness> witnesses;
    private ArrayList<Victim> victims; 
    private ArrayList<Evidence> evidence;
    private int caseID;
    private int date;
    private String location;

    public Case (Crime crime2, ArrayList<Suspect> suspects2, ArrayList<Witness> witnesses2, ArrayList<Victim> victims2, ArrayList<Evidence> evidence2, int caseID2, int date2, String location2) {
        this.crime = crime2;
        this.suspects = suspects2;
        this.witnesses = witnesses2;
        this.victims = victims2;
        this.evidence = evidence2;
        this.caseID = caseID2;
        this.date = date2;
        this.location = location2;
    }
/*
    public Case(Crime crime, ArrayList<Suspect> suspects, ArrayList<Witness> witnesses, ArrayList<Victim> victims, ArrayList<Evidence> evidence, int caseID, String date, String location){
        this.crime = crime;
        this.suspects = suspects;
        this.witnesses = witnesses;
        this.victims = victims;
        this.evidence = evidence;
        this.caseID = caseID;
        this.date = date;
        this.location = location;
    }
*/
    public Case(int caseID2, String date2, String location2, JSONArray agentIDS, JSONArray evidenceIDS) {
    }

    public Crime getCrime(){
        return this.crime;
    }

    public ArrayList<Suspect> getSuspect(){
        return this.suspects;
    }

    public ArrayList<Witness> getWitnesses(){
        return this.witnesses;
    }

    public ArrayList<Victim> getVictims(){
        return this.victims;
    }

    public ArrayList<Evidence> getEvidence(){
        return this.evidence;
    }

    public void setCaseID(int caseID){
        this.caseID = caseID;
    }

    public int getCaseID(){
        return this.caseID;
    }

    public int getDate(){
        return this.date;
    }

    public String getLocation(){
        return this.location;
    }

    public String toString(){
        System.out.println("Case ID: " + this.caseID);
        System.out.println("Crime: " + this.crime);
        for (Suspect suspect : suspects) {
            System.out.println("Suspect: " + this.suspects);
        }
        for (Witness witness : witnesses) {
            System.out.println("Witness: " + this.witnesses);
        }
        for (Victim victim : victims) {
            System.out.println("Victim: " + this.victims);
        }
        for (Evidence evi : evidence) {
            System.out.println("Evidence: " + this.evidence);
        }
        System.out.println("Date: " + this.date);
        System.out.println("Location: " + this.location);
        return "";
    }
}
