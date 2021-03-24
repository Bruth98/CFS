import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser; //Ask about this error
public class DataLoader extends DataConstants {
    public ArrayList<Person> loadPersons(){
        ArrayList<Person> persons = new ArrayList<Person>();
        try{
            FileReader reader = new FileReader(PERSON_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray personJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i<personJSON.size(); i++){
                JSONObject personsJSON = (JSONObject)personJSON.get(i);
                String name =(String)personsJSON.get(PERSON_NAME);
                String address = (String)personsJSON.get(PERSON_ADDRESS);
                int dob =(int)personsJSON.get(PERSON_DOB);
                String description = (String)personsJSON.get(PERSON_DESCRIPTION);

                persons.add(new Person(name, address, dob, description));
            }
            return persons;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<User> loadUsers(){
        ArrayList<User> users = new ArrayList<User>();
        try{
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray userJSON =(JSONArray)new JSONParser().parse(reader);

            for(int i =0; i< userJSON.size();i++){
                JSONObject usersJSON = (JSONObject)usersJSON.get(i);
                int employeeID = (int)usersJSON.get(EMPLOYEE_ID);
                String password = (String)usersJSON.get(EMPLOYEE_PASSWORD);
                
                users.add(new User(employeeID, password));
            }
            return users;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Admin> loadAdmins(){
        ArrayList<Admin> admins = new ArrayList<Admin>();
        try{
            FileReader reader = new FileReader(ADMIN_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray adminJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i = 0; i<adminJSON.size(); i++){
                JSONObject adminsJSON = (JSONObject)adminJSON.get(i);
                String firstName = (String)adminsJSON.get(ADMIN_FIRST_NAME);
                String lastName = (String)adminsJSON.get(ADMIN_LAST_NAME);

                admins.add(new Admin(firstName, lastName));
            }
            return admins;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Crime> loadCrime(){
        ArrayList<Crime> crimes = new ArrayList<Crime>();
        try{
            FileReader reader = new FileReader(CRIME_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray crimeJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i<crimeJSON.size(); i++){
                JSONObject crimesJSON = (JSONObject)crimeJSON.get(i);
                String type = (String)crimesJSON.get(CRIME_TYPE);
                boolean felony =(boolean)crimesJSON.get(CRIME_FELONY);

                crimes.add(new Crime(type, felony));
            }
            return crimes;
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Evidence> loadEvidence(){
        ArrayList<Evidence> evidences = new ArrayList<Evidence>();
        try{
            FileReader reader = new FileReader(EVIDENCE_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray evidenceJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i<evidenceJSON.size(); i++){
                JSONObject evidencesJSON = (JSONObject)evidenceJSON.get(i);
                String description = (String)evidencesJSON.get(EVIDENCE_DESCRIPTION);
                String location = (String)evidencesJSON.get(EVIDENCE_LOACTION);
                boolean weapon = (boolean)evidencesJSON.get(EVIDENCE_WEAPON);
                boolean drugs = (boolean)evidencesJSON.get(EVIDENCE_DRUGS);
                boolean fingerprints=(boolean)evidencesJSON.get(EVIDENCE_FINGERPRINTS);

                evidences.add(new Evidence(description, location, weapon, drugs, fingerprints));
            }
            return evidences;
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
