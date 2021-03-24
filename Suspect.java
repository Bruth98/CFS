import java.util.ArrayList;
public class Suspect extends PersonOfIneterst{
    public ArrayList<String> family;

    public Suspect() {
        super();
        this.family = null;
    }

    public Suspect(String gender,String race, String hairColor,double height,double weight,boolean tattoo,boolean criminalRecord, ArrayList<String> family) {
        super();
        this.family = family;
    }

    public Suspect(ArrayList<String> family) {
        super();
        this.family = family;
    }

    public ArrayList<String> getFamily() {
        return this.family;
    }
    
}
