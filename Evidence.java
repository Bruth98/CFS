/* 
This is the Evidence class, detailing everything required for a piece of Evidence.
It is very similar to Case, Suspect, Witness, and Victim
*/
import java.util.ArrayList;
//uml done
public class Evidence {
    private String description;
    private boolean fingerprints;
    //private Image image;
    private boolean weapon;
    private boolean drugs;
    private String location;
    private ArrayList<String> witnesses;
    private int evidenceID;


    public Evidence(String description, String location, boolean weapon, boolean drugs, boolean fingerprints){

    }
    public String getDescription(){
        return this.description;
    }

    public boolean hasFingerprints(){
        return this.fingerprints;
    }

    public boolean isWeapon(){
        return this.weapon;
    }

    public boolean isDrugs(){
        return this.drugs;
    }

    public String getLocation(){
        return this.location;
    }

    public ArrayList<String> getWitnesses(){
        return this.witnesses;
    }

    public String toString(){
        return "Is Weapon: "+this.weapon+"\nIs Drugs: "+this.drugs+"\nHas fingerprints: "+this.fingerprints+"\nDescription: "+this.description+"\nLocation Found: "+this.location;
    }

    public void setEvidenceID(int evidenceID){
        this.evidenceID = evidenceID;
    }

    public int getEvidenceID(){
        return this.evidenceID;
    }
}
