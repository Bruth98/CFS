import java.util.ArrayList;
import java.util.Collection;

public class Database {

/*
starts with a chunk of getters
*/
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

    /*
    Search for a person with a specific name
    */
    public static ArrayList<Person> getFirst(String name) {  // Search for a person with a specific first name
        ArrayList<Person> person = new ArrayList<Person>();
        for(int i=0; i < Persons.getInstance().getPerson().size();i++){  // loop over the size of the ArrayList
            Person names = Persons.getInstance().getPerson().get(i);  // get the name of person (i) in the list
            if(names.getName().equals(name)){  // compare that name to the name being searched for
                return Persons.getInstance().getPerson();  // if they match, return that person from the list
            }
        }
        System.out.println("Sorry no suspects with that name.");  // if the names do not match
        return null;  // return nothing
    }
	
    /*
    Almost exactly the same as the getFirst(String name) method
    */
    public static ArrayList<Person> getAge(int age) {  // Search for a person with a specific age
        ArrayList<Person> person = new ArrayList<Person>();
        for(int i=0; i < Persons.getInstance().getPerson().size();i++){  // loop over the size of the ArrayList
            Person names = Persons.getInstance().getPerson().get(i);  // Eastablish that person as a new object
            if(names.getAge() == age){  // if that person's age matches the one being searched for
                return Persons.getInstance().getPerson();  // return that person to the user
            }
        }
        System.out.println("Sorry no suspects with that age.");
        return null;
    }
	
    /*
    Almost exactly the same as the getFirst(String name) method
    */
    public static ArrayList<PersonOfInterest> getHeight(double height) {  // Search for a person with a specific height
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

    /*
    Almost exactly the same as the getFirst(String name) method
    */
    public static ArrayList<PersonOfInterest> getWeight(double weight) {  // Search for a person with a specific weight
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

    /*
    Almost exactly the same as the getFirst(String name) method
    */
    public static ArrayList<PersonOfInterest> getGender(String gender) {  // Search for a person with a specific gender
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
    
    /*
    Almost exactly the same as the getFirst(String name) method
    */
    public static ArrayList<PersonOfInterest> getTattooDescription(String tattoo) {  // // Search for a person with a specific tattoo description
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

    /*
    Almost exactly the same as the getFirst(String name) method
    */
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
