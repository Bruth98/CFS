import java.util.ArrayList;
public class Victims {
    private static Victims victims = null;
    private static ArrayList<Victim> victimList;
    
    private Victims() {
        victimList = DataLoader.loadVictim(); 
    }

    public static Victims getInstance() {
        if (victims == null) {
            victims = new Victims();
        }
        return victims;
        }

    public ArrayList<Victim> getVictims() {
        return victimList;
    }
    //add get user by ID
    public boolean addVictim(String name, String address, int dob, String description, boolean alive, long phoneNum) {
        if(haveVictim(name, dob)) {
            return false;
        }
        victimList.add(new Victim(name, address, dob, description,alive, phoneNum));
        return true;
    }

    public boolean haveVictim(String name, int dob) {
        for (Victim victim : victimList) {
            if (victim.getName().equals(name) && victim.getDOB() == dob) {
                return true;
            }
        }
        return false;
    }

    public void saveVictim() {
        DataWriter.saveVictims(); 
    }
}
