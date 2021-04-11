import java.util.ArrayList;
public class Witnesses {
    private static Witnesses witnesses = null;
    private static ArrayList<Witness> witnessList = new ArrayList<Witness>();
    
    private Witnesses() {
        // witnessList = DataLoader.loadWitnesses(); 
    }

    public static Witnesses getInstance() {
        if (witnesses == null) {
            witnesses = new Witnesses();
        }
        return witnesses;
        }

    public ArrayList<Witness> getWitnesses() {
        return witnessList;
    }
    //add get user by ID
    public boolean addWitness(String name, String address, int dob, String description,boolean relationToVictim) {
        if(haveWitness(name, dob)) {
            return false;
        }
        witnessList.add(new Witness(name, address, dob, description, relationToVictim));
        return true;
    }

    public boolean haveWitness(String name, int dob) {
        for (Witness witness : witnessList) {
            if (witness.getName().equals(name) && witness.getDOB() == dob) {
                return true;
            }
        }
        return false;
    }

    public void saveWitness() {
        DataWriter.saveWitness(); 
    }
}

