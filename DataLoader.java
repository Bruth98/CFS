import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser; //Ask about this error
import org.json.simple.parser.ParseException;
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
        catch(Exception e){
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
        catch(Exception e){
            e.printStackTrace();
        } 
        return null;
    }

    public ArrayList<Officer> loadOfficer(){
        ArrayList<Officer> officers = new ArrayList<Officer>();
        try{
            FileReader reader = new FileReader(OFFICER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray officerJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i<officerJSON.size(); i++){
                JSONObject officersJSON = (JSONObject)officerJSON.get(i);
                String firstName = (String)officersJSON.get(OFFICER_FIRST_NAME);
                String lastName = (String)officersJSON.get(OFFICER_LAST_NAME);
                String department = (String)officersJSON.get(OFFICER_DEPARTMENT);

                officers.add(new Officer(firstName, lastName, department));
            }
            return officers;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Suspect> loadSuspect(){
        ArrayList<Suspect> suspect = new ArrayList<Suspect>();
        try{
            FileReader reader = new FileReader(SUSPECT_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray suspectJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i<suspectJSON.size(); i++){
                JSONObject suspectsJSON = (JSONObject)suspectJSON.get(i);
                String gender = (String)suspectsJSON.get(SUSPECT_GENDER);
                String race = (String)suspectsJSON.get(SUSPECT_RACE);
                String hairColor = (String)suspectsJSON.get(SUSPECT_HAIR_COLOR);
                double height =(double)suspectsJSON.get(SUSPECT_HEIGHT);
                double weight = (double)suspectsJSON.get(SUSPECT_WEIGHT);
                boolean tattoo = (boolean)suspectsJSON.get(SUSPECT_TATTOO);
                boolean criminalRecord = (boolean)suspectsJSON.get(SUSPECT_CRIMINAL_RECORD);

                suspect.add(new Suspect(gender, race, hairColor, height, weight, tattoo, criminalRecord));

            }

            return suspect;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Victim> loadVictim(){
        ArrayList<Victim> victim = new ArrayList<Victim>();
        try{
            FileReader reader = new FileReader(VICTIM_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray victimJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i<victimJSON.size(); i++){
                JSONObject victimsJSON = (JSONObject)victimJSON.get(i);
                int phoneNum = (int)victimsJSON.get(VICTIM_PHONE_NUMBER);
                boolean alive = (boolean)victimsJSON.get(VICTIM_ALIVE);

                victim.add(new Victim(phoneNum, alive));
            }
            return victim;
            catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }
    }
}
