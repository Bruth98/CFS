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

    public Case(Crime crime, ArrayList<Suspect> suspects, ArrayList<Witness> witnesses, ArrayList<Victim> victims, ArrayList<Evidence> evidence, int caseID, int date, String location){

    }

    public Crime getCrime(){
        return null;
    }

    public ArrayList<Suspect> getSuspect(){
        return null;
    }

    public ArrayList<Witness> getWitnesses(){
        return null;
    }

    public ArrayList<Victim> getVictims(){
        return null;
    }

    public ArrayList<Evidence> getEvidence(){
        return null;
    }

    public void setCaseID(int caseID){
        this.caseID = caseID;
    }

    public int getCaseID(){
        return 0;
    }

    public int getDate(){
        return 0;
    }

    public String getLocation(){
        return "";
    }

    public String toString(){
        return "";
    }
}
