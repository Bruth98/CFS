import java.util.ArrayList;

public class Database {

    public static ArrayList<User> getUsers() {
        return new ArrayList<User>();
    }

    public static ArrayList<Case> getCases() {
        return new ArrayList<Case>();
    }

    public static ArrayList<Evidence> getEvidence() {
        return new ArrayList<Evidence>();
    }

    public static ArrayList<Suspect> getSuspect() {
        return new ArrayList<Suspect>();
    }

    public static ArrayList<Criminal> getCriminals() {
        return new ArrayList<Criminal>();
    }

    public static ArrayList<Victim> getVictims() {
        return new ArrayList<Victim>();
    }

    public static ArrayList<Witness> getWitnesses() {
        return new ArrayList<Witness>();
    }

    public static ArrayList<Person> getFirst(String name) {
        for(int i=0; i < Persons.getInstance().getPerson().size();i++){
            if(Person.getName().equals(name)){
                return Persons.getInstance().getPerson();
            }
        }
        System.out.println("Sorry no suspects with that name.");
        return null;
    }

    public static ArrayList<Person> getAge(int age) {
        for(int i=0; i < Persons.getInstance().getPerson().size();i++){
            if(PersonOfIneterst.getAge() == age){
                return Persons.getInstance().getPerson();
            }
        }
        System.out.println("Sorry no suspects with that name.");
        return null;
    }

    public static ArrayList<Person> getHeight(double height) {
        for(int i=0; i < PersonsOfInterest.getInstance().getPerson().size();i++){
            if(PersonsOfInterest.getHeight() == height){
                return Persons.getInstance().getPerson();
            }
        }
        System.out.println("Sorry no suspects with that name.");
        return null;
    }

    public static ArrayList<Person> getWeight(double weight) {

    }

    public static ArrayList<Person> getGender(String gender) {

    }

    public static ArrayList<Person> getCrime(String type) {

    }

    public static ArrayList<Person> getTattooDescription(String tattoo) {

    }

    public static ArrayList<Person> getHairColor(String hairColor) {

    }


    
}
