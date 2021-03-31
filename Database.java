import java.util.ArrayList;
import java.util.Collection;

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
        ArrayList<Person> person = new ArrayList<Person>();
        for(int i=0; i < Persons.getInstance().getPerson().size();i++){
            Person names = Persons.getInstance().getPerson().get(i);
            if(names.getName().equals(name)){
                return Persons.getInstance().getPerson();
            }
        }
        System.out.println("Sorry no suspects with that name.");
        return null;
    }

    public static ArrayList<Person> getAge(int age) {
        ArrayList<Person> person = new ArrayList<Person>();
        for(int i=0; i < Persons.getInstance().getPerson().size();i++){
            Person names = Persons.getInstance().getPerson().get(i);
            if(names.getAge() == age){
                return Persons.getInstance().getPerson();
            }
        }
        System.out.println("Sorry no suspects with that age.");
        return null;
    }

    public static ArrayList<PersonOfInterest> getHeight(double height) {
        ArrayList<PersonOfInterest> person = new ArrayList<PersonOfInterest>();
        for(int i=0; i < PersonsOfInterest.getInstance().getPerson().size();i++){
            PersonOfInterest names = PersonsOfInterest.getInstance().getPerson().get(i);
            if(names.getHeight()== height){
                return PersonsOfInterest.getInstance().getPerson();
            }
        }
        System.out.println("Sorry no suspects with that height.");
        return null;
    }

    public static ArrayList<PersonOfInterest> getWeight(double weight) {
        ArrayList<PersonOfInterest> person = new ArrayList<PersonOfInterest>();
        for(int i=0; i < Persons.getInstance().getPerson().size();i++){
            PersonOfInterest names = PersonsOfInterest.getInstance().getPerson().get(i);
            if(names.getWeight() == weight){
                return PersonsOfInterest.getInstance().getPerson();
            }
        }
        System.out.println("Sorry no suspects with that weight.");
        return null;
    }

    public static ArrayList<PersonOfInterest> getGender(String gender) {
        ArrayList<PersonOfInterest> person = new ArrayList<PersonOfInterest>();
        for(int i=0; i < PersonsOfInterest.getInstance().getPerson().size();i++){
            PersonOfInterest names = PersonsOfInterest.getInstance().getPerson().get(i);
            if(names.getGender().equals(gender)){
                return PersonsOfInterest.getInstance().getPerson();
            }
        }
        System.out.println("Sorry no suspects with that gender.");
        return null;
    }
/*
    public static ArrayList<PersonOfInterest> getCrime(String type) {
        ArrayList<PersonOfInterest> person = new ArrayList<PersonOfInterest>();
        for(int i=0; i < PersonsOfInterest.getInstance().getPerson().size();i++){
            PersonOfInterest names = PersonsOfInterest.getInstance().getPerson().get(i);
            if(names.getCrime().equals(type)){
                return Persons.getInstance().getPerson();
            }
        }
        System.out.println("Sorry no suspects with that crime.");
        return null;
    }
*/
    public static ArrayList<PersonOfInterest> getTattooDescription(String tattoo) {
        ArrayList<PersonOfInterest> person = new ArrayList<PersonOfInterest>();
        for(int i=0; i < Persons.getInstance().getPerson().size();i++){
            PersonOfInterest names = PersonsOfInterest.getInstance().getPerson().get(i);
            if(names.getTattooDescription().equals(tattoo)){
                return PersonsOfInterest.getInstance().getPerson();
            }
        }
        System.out.println("Sorry no suspects with that tattoo.");
        return null;
    }

    public static ArrayList<PersonOfInterest> getHairColor(String hairColor) {
        ArrayList<PersonOfInterest> person = new ArrayList<PersonOfInterest>();
        for(int i=0; i < PersonsOfInterest.getInstance().getPerson().size();i++){
            PersonOfInterest names = PersonsOfInterest.getInstance().getPerson().get(i);
            if(names.getHairColor().equals(hairColor)){
                return PersonsOfInterest.getInstance().getPerson();
            }
        }
        System.out.println("Sorry no suspects with that hair color.");
        return null;
    }

	


    
}
