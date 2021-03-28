import java.util.ArrayList;
public class Suspect extends PersonOfIneterst{
    //public ArrayList<String> family;

    public Suspect() {
        super();
        //this.family = null;
    }
    
    public Suspect(String name,String address, int dob, String description, String gender,String race, String hairColor, double weight, double height, String tattoo, boolean criminalRecord) {
        super();
        //this.family = family;
    }
    
    public Suspect(ArrayList<String> family) {
        super();
       // this.family = family;
    }
/*
    public ArrayList<String> getFamily() {
        return this.family;
    }
  */  
    public String toString(){
        return "hello";
    }

    public boolean getCriminalRecord(){
        return this.criminalRecord;
    }

    public String getTattoo(){
        return this.tattoo;
    }
}
