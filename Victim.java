import java.util.ArrayList;
public class Victim extends Person{
    //private ArrayList<String> incidentReport;
    private boolean alive;
    private long phoneNum;

    public Victim(){
        super();
        this.alive = true;
        this.phoneNum = 0000000000;
    }

    public Victim(String name, String address, int dob, String description, boolean alive, long phoneNum){
        super.name = name;
        super.address = address;
        super.dob = dob;
        super.description = description;
        this.alive = alive;
        this.phoneNum = phoneNum;
    }
/*
    public ArrayList<String> getIncidentReport(){
        return this.incidentReport;
    }
*/
    public boolean getStatus(){
        return this.alive;
    }

    public long getPhoneNum(){
        return this.phoneNum;
    }

    public String toString() {
        return "Name: " +this.name+"\nAddress: "+this.address+"\nD.O.B.: "+this.dob+"\nAre they alive? "+this.alive+"\nPhone Number: "+this.phoneNum+"\nDescription:"+this.description;
    }

    public Object isAlive() {
        return null;
    }
}
