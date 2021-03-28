import java.util.ArrayList;
public class Persons {
    private static Persons persons = null;
    private static ArrayList<Person> personList;
    private Persons(){
        personList = DataLoader.loadPersons();
    }

    public static Persons getInstance() {
        if(persons ==null){
            persons = new Persons();
        }
        return persons;
    }

    public ArrayList<Person> getPerson(){
        return personList;
    }

    public boolean addPerson(String name, String address, int dob, int age, String description){
        if(havePerson(name, address, dob, description)){
            return false;
        }
        personList.add(new Person(name,address,dob,age,description));
        return true;
    }

    public boolean havePerson(String name, String address,int dob, String description){
        for(Person person : personList){
            if(person.getName().equals(name) && person.getAddress().equals(address) && person.getDescription().equals(description) && person.getDOB() == dob){
                return true;
            }
        }
        return false;
    }

    public void savePerson(){
        DataWriter.savePersons();
    }


}
