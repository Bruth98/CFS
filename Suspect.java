import java.util.ArrayList;
public class Suspect extends PersonOfInterest{
    //public ArrayList<String> family;
    int phoneNum;
    public Suspect() {
        super();
        //this.family = null;
    }
    
    public Suspect(String name, String address, int dob, String description, String gender, String race, String hairColor, double weight, double height, String tattoo, boolean criminalRecord, int age, int phoneNum) {
        super();
    }
    
    public String toString(){
        return "";
    }

    public boolean getCriminalRecord(){
        return this.criminalRecord;
    }

    public String getTattoo(){
        return this.tattoo;
    }

    public int getAge(){
        return this.age;
    }

    public int getPhoneNum(){
        return this.phoneNum;
    }
}
