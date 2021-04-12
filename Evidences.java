import java.util.ArrayList;
public class Evidences {
    private static Evidences evidences;
    private static ArrayList<Evidence> evidenceList = new ArrayList<Evidence>();


    private Evidences(){
        // evidenceList = DataLoader.loadEvidence();
    }

    public static Evidences getInstance(){
        if(evidences == null){
            evidences = new Evidences();
        }
        return evidences;
    }

    public ArrayList<Evidence> getEvidence(){
        return evidenceList;
    }

    public Evidence getEvidenceID(int evidenceID){
        for(Evidence evidence : evidenceList){
            if(evidence.getEvidenceID() == (evidenceID)){
                return evidence;
            }
        }      
    return null;
    }


    public boolean haveEvidence(int evidenceID){
        for(Evidence evidence : evidenceList){
            if(evidence.getEvidenceID() == evidenceID){
                return true;
            }
        }
        return false;
    }

    public void saveEvidence(){
        DataWriter.saveEvidence();
    }
}


