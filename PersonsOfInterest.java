import java.util.ArrayList;
public class PersonsOfInterest {
    private static PersonsOfInterest personsOfInterest = null;
    private static ArrayList<PersonOfInterest> personOfInterestList;
    private PersonsOfInterest(){
        personOfInterestList = DataLoader.loadPersonofInterests();
    }

    public static PersonsOfInterest getInstance() {
        if(personsOfInterest ==null){
            personsOfInterest = new PersonsOfInterest();
        }
        return personsOfInterest;
    }

    public ArrayList<PersonOfInterest> getPerson(){
        return personOfInterestList;
    }

    public boolean addPersonOfInterest(String name, String address, int dob, int age, String description,
      String gender, String race, String hairColor, double height, double weight, String tattooDescription, boolean criminalRecord){
        if(havePersonOfInterest(name, address, dob, description)){
            return false;
        }
        personOfInterestList.add(new PersonOfInterest(name, address, dob, age, description, gender, race, hairColor, height, 
        weight, tattooDescription, criminalRecord));
        return true;
    }

    public boolean havePersonOfInterest(String name, String address,int dob, String description){
        for(PersonOfInterest personOfInterest : personOfInterestList){
            if(personOfInterest.getName().equals(name) && personOfInterest.getAddress().equals(address) && personOfInterest.getDescription().equals(description) && personOfInterest.getDOB() == dob){
                return true;
            }
        }
        return false;
    }

    public void savePersonsOfInterest(){
        DataWriter.savePersonOfInterest();
    }
}
