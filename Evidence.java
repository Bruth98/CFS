import java.util.ArrayList;
public class Evidence {
    private String description;
    private boolean fingerprints;
    //private Image image;
    private boolean weapon;
    private boolean drugs;
    private String location;
    private ArrayList<String> witnesses;

    public String getDescription(){
        return "";
    }

    public boolean hasFingerprints(){
        return false;
    }

    /*
    public getImage(){

    }
    */

    public boolean isWeapon(){
        return false;
    }

    public boolean isDrugs(){
        return false;
    }

    public String getLocation(){
        return "";
    }

    public ArrayList<String> getWitnesses(){
        return null;
    }

    public String toString(){
        return "";
    }
}
