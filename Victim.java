import java.util.ArrayList;
public class Victim extends Person{
    private ArrayList<String> incidentReport;
    private boolean alive;
    private int phoneNum;

    public Victim(){
        super();
        this.incidentReport = null;
        this.alive = true;
        this.phoneNum = 0000000000;
    }

    public Victim(ArrayList<String> incidentReport, boolean alive, int phoneNum){
        super();
        this.incidentReport = incidentReport;
        this.alive = alive;
        this.phoneNum = phoneNum;
    }

    public ArrayList<String> getIncidentReport(){
        return this.incidentReport;
    }

    public boolean getStatus(){
        return this.alive;
    }

    public int getPhoneNum(){
        return this.phoneNum;
    }
}
