import java.util.ArrayList;
public class Suspects {
    private static Suspects suspects = null;
    private static ArrayList<Suspect> suspectList;

    private Suspects() {
        suspectList = DataLoader.loadSuspect();
    }

    public static Suspects getInstance() {
        if (suspects == null) {
            suspects = new Suspects();
        }
        return suspects;
    }

    public ArrayList<Suspect> getSuspects() {
        return suspectList;
    }
    
    public boolean addSuspect(String name, String address, int dob,
      int age, String description, String gender, String race, String hairColor,
      double height, double weight, String tattoo, boolean criminalRecord, long phoneNum) {
        if (haveSuspect(name, dob)) {
            return false;
        }
        suspectList.add(new Suspect(name, address, dob, description, gender, 
          race, hairColor, height, weight, tattoo, criminalRecord,age, phoneNum));
          return true;
      }

      public boolean haveSuspect(String name, int dob) {
          for (Suspect suspect : suspectList) {
              if (suspect.getName().equals(name) && suspect.getDOB() == dob) {
                  return true;
              }
          }
          return false;
      }

      public void saveSuspects() {
          DataWriter.saveSuspects();
      }
}
