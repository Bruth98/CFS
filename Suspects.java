/* 
This is functionally the same file as Cases, Crimes, Persons, Witnesses, and Victims.
It both reads and writes to our JSON Database
*/
import java.util.ArrayList;
public class Suspects {
    private static Suspects suspects = null;
    private static ArrayList<Suspect> suspectList = new ArrayList<Suspect>();

    /*
    Load the list of saved suspects from the JSON database
    */
    private Suspects() {
        //suspectList = DataLoader.loadSuspect();
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
    
    /*
   Adds a suspect to the list if they are not already in the database
    */
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
    /*
    Checks to see if the suspect is alreadu in the database\
    */
      public boolean haveSuspect(String name, int dob) {
          for (Suspect suspect : suspectList) {
              if (suspect.getName().equals(name) && suspect.getDOB() == dob) {
                  return true;
              }
          }
          return false;
      }
    /*
    Save the new list of Suspects in JSON format to our database
    */
      public void saveSuspects() {
          DataWriter.saveSuspects();
      }
}
