import java.util.ArrayList;
public class Suspect extends PersonOfInterest{
    //public ArrayList<String> family;
    long phoneNum;
    public Suspect() {
        super();
        //this.family = null;
    }
    
    public Suspect(String name, String address, int dob, String description, String gender, String race, String hairColor, double weight, double height, String tattoo, boolean criminalRecord, int age, long phoneNum) {
        super();
    }
    
    public String toString(){
        return "Name: " + this.name + "\nAddress: " + this.address +"\nDOB: "+this.dob + "\nAge: "+this.age+"\nGender: " +this.gender+ "\nRace: " +this.race+ "\nHair Color: " +this.hairColor+ "\nWeight: " + this.weight+ "\nHeight: " + this.height + "\nTattoo Description: " +this.tattoo+ "\nCriminal Record? "+this.criminalRecord+"\nPhone Number: "+this.phoneNum+"\nDescription: "+this.description;
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

    public long getPhoneNum(){
        return this.phoneNum;
    }
}
