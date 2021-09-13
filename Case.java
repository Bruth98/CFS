/* 
This is the class for all of our Cases inside of our software. This is what a case should be filled out as in the UI
*/
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

    /*
    Construct a new case
    VSCode was being very weird the day we worked on this and was not allowing us to use our normal variable names inside of the constructor, so that is
    why each variable has a 2 attached to the end of it.
    */
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

    /*
    A chunk of code utilizing normal getters and setters
    */
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

    /*
    toString method that should print every detail attached to a Case, including each Suspect, Witness, Victim, and any and all Evidence. It also prints
    the location and time that the crime took place.
    */
    public String toString(){
        System.out.println("Case ID: " + this.caseID);
        System.out.println("Crime: " + this.crime.toString());
        int i = 0;
        for (Suspect suspect : suspects) {
            i++;
            System.out.println("Suspect: " +i+" "+suspect.toString());
        }
        i = 0;
        for (Witness witness : witnesses) {
            System.out.println("Witness: " +i+" "+ witness.toString());
        }
        i = 0;
        for (Victim victim : victims) {
            System.out.println("Victim: " +i+" "+ victim.toString());
        }
        i = 0;
        for (Evidence evi : evidence) {
            System.out.println("Evidence: " +i+" "+ evidence.toString());
        }
        System.out.println("Date: " + this.date);
        System.out.println("Location: " + this.location);
        return "";
    }
}
