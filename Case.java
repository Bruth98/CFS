import java.util.ArrayList;
public class Case {
    private Crime crime;
    private ArrayList<Suspect> suspects;
    private ArrayList<Witness> witnesses;
    private ArrayList<Victim> victims; 
    private ArrayList<Evidence> evidence;
    private int caseID;
    private String date;
    private String location;

    public Case () {
        this.crime = null;
        this.suspects = null;
        this.witnesses = null;
        this.victims = null;
        this.evidence = null;
        this.caseID = 0;
        this.date = "Never";
        this.location = "Nowhere";
    }

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

    public String getDate(){
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
