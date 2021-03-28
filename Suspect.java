import java.util.ArrayList;
public class Suspect extends PersonOfIneterst{
    //public ArrayList<String> family;

    public Suspect() {
        super();
        //this.family = null;
    }
    
    public Suspect(String name,String address,int dob, String gender,String race, String hairColor,String hairColor2,double weight,double weight2,boolean criminalRecord, boolean tattoo) {
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

    public boolean getTattoo(){
        return this.tattoo;
    }
}
