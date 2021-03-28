import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser; 
import org.json.simple.parser.ParseException;
public class DataLoader extends DataConstants {
    public static ArrayList<Person> loadPersons(){
        ArrayList<Person> persons = new ArrayList<Person>();
        try{
            FileReader reader = new FileReader(PERSON_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray personJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i<personJSON.size(); i++){
                JSONObject personsJSON = (JSONObject)personJSON.get(i);
                String name =(String)personsJSON.get(PERSON_NAME);
                String address = (String)personsJSON.get(PERSON_ADDRESS);
                int dob =((Long)personsJSON.get(PERSON_DOB)).intValue();
                int age =((Long)personsJSON.get(PERSON_AGE)).intValue();
                String description = (String)personsJSON.get(PERSON_DESCRIPTION);

                persons.add(new Person(name, address, dob, age, description));
            }
            return persons;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<User> loadUsers(){
        ArrayList<User> users = new ArrayList<User>();
        try{
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray userJSON =(JSONArray)new JSONParser().parse(reader);

            for(int i =0; i< userJSON.size();i++){
                JSONObject usersJSON = (JSONObject)userJSON.get(i);
                int employeeID = ((Long)usersJSON.get(EMPLOYEE_ID)).intValue();
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

    public static ArrayList<Admin> loadAdmins(){
        ArrayList<Admin> admins = new ArrayList<Admin>();
        try{
            FileReader reader = new FileReader(ADMIN_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray adminJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i = 0; i<adminJSON.size(); i++){
                JSONObject adminsJSON = (JSONObject)adminJSON.get(i);
                String firstName = (String)adminsJSON.get(ADMIN_FIRST_NAME);
                String lastName = (String)adminsJSON.get(ADMIN_LAST_NAME);
                String department = (String)adminsJSON.get(ADMIN_DEPARTMENT);
                int employeeID = ((Long)adminsJSON.get(ADMIN_EMPLOYEE_ID)).intValue();
                admins.add(new Admin(firstName, lastName, department, employeeID));
            }
            return admins;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Crime> loadCrime(){
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

    public static ArrayList<Evidence> loadEvidence(){
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

    public static ArrayList<Officer> loadOfficer(){
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

    public static ArrayList<Suspect> loadSuspect(){
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
                String name = (String)suspectsJSON.get(SUSPECT_NAME);
                String address = (String)suspectsJSON.get(SUSPECT_ADDRESS);
                String description = (String)suspectsJSON.get(SUSPECT_DESCRIPTION);
                int dob = ((Long)suspectsJSON.get(SUSPECT_DOB)).intValue();
                double height =((Long)suspectsJSON.get(SUSPECT_HEIGHT)).doubleValue();
                double weight = ((Long)suspectsJSON.get(SUSPECT_WEIGHT)).doubleValue();
                String tattoo = (String)suspectsJSON.get(SUSPECT_TATTOO);
                int age = ((Long)suspectsJSON.get(SUSPECT_AGE)).intValue();
                boolean criminalRecord = (boolean)suspectsJSON.get(SUSPECT_CRIMINAL_RECORD);
                suspect.add(new Suspect(name, address, dob, description, gender, 
                race, hairColor, height, weight, tattoo, criminalRecord, age));
            }

            return suspect;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
   
    public static ArrayList<Victim> loadVictim(){
        ArrayList<Victim> victim = new ArrayList<Victim>();
        try{
            FileReader reader = new FileReader(VICTIM_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray victimJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i<victimJSON.size(); i++){
                JSONObject victimsJSON = (JSONObject)victimJSON.get(i);
                String name = (String)victimsJSON.get(VICTIM_NAME);
                String address = (String)victimsJSON.get(VICTIM_ADDRESS);
                String description = (String)victimsJSON.get(VICTIM_DESCRIPTION);
                int dob = ((Long)victimsJSON.get(VICTIM_DOB)).intValue();
                int phoneNum = ((Long)victimsJSON.get(VICTIM_PHONE_NUMBER)).intValue();
                boolean alive = (boolean)victimsJSON.get(VICTIM_ALIVE);
                
                victim.add(new Victim(name, address, dob, description, alive, phoneNum));
            }
                return victim;
        }
            catch(Exception e){
                e.printStackTrace();
            }
            return null;
    }

    public static ArrayList<Case> loadCase(){
        ArrayList<Case> case2 = new ArrayList<Case>();
        try{
            FileReader reader = new FileReader(CASE_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray caseJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i<caseJSON.size(); i++){
                JSONObject casesJSON = (JSONObject)caseJSON.get(i);
                int caseID =((Long)casesJSON.get(CASE_ID)).intValue();
                String date = (String)casesJSON.get(CASE_DATE);
                String location = (String)casesJSON.get(CASE_LOCATION);
                JSONArray agentIDS = (JSONArray)casesJSON.get("data constant");
                ArrayList<User> users = getUsers(agentIDS);
                JSONArray EvidenceIDS = (JSONArray)casesJSON.get("data constant");
                ArrayList<Evidence> evidences = getEvidence(EvidenceIDS);
                case2.add(new Case(caseID, date, location,agentIDS,EvidenceIDS));
            }

            return case2;
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    private static ArrayList<User> getUsers(JSONArray UserIDS){
        ArrayList<User> users = new ArrayList<User>();
        for(int i=0; i< UserIDS.size(); i++){
            int userID = ((Long)UserIDS.get(i)).intValue();
            User user = Users.getInstance().getUser(userID);
            users.add(user);
        }
        return users;
    }
    private static ArrayList<Evidence> getEvidence(JSONArray EvidenceIDS){
        ArrayList<Evidence> evidences = new ArrayList<Evidence>();
        for(int i=0; i< EvidenceIDS.size(); i++){
            int evidenceID = ((Long)EvidenceIDS.get(i)).intValue();
            Evidence evidence = Evidences.getInstance().getEvidenceID(evidenceID);
            evidences.add(evidence);
        }
        return evidences;
    }
    public static ArrayList<Witness> loadWitnesses(){
        ArrayList<Witness> witness = new ArrayList<Witness>();
        try{
            FileReader reader = new FileReader(WITNESS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray witnessJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i =0; i<witnessJSON.size(); i++){
                JSONObject witnessesJSON = (JSONObject)witnessJSON.get(i);
                String name = (String)witnessesJSON.get(WITNESS_NAME);
                String address = (String)witnessesJSON.get(WITNESS_NAME);
                String description = (String)witnessesJSON.get(WITNESS_DESCRIPTION);
                int dob = ((Long)witnessJSON.get(WITNESS_DOB)).intValue();
                boolean relationToVictim = (boolean)witnessesJSON.get(WITNESS_RELATION_TO_VICTIM);

                witness.add(new Witness(name, address, dob, description, relationToVictim));
            }
            return witness;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static ArrayList<PersonOfInterest> loadPersonofInterests(){
        ArrayList<PersonOfInterest> personofinterest = new ArrayList<PersonOfInterest>();
        try{
            FileReader reader = new FileReader(PERSON_OF_INTEREST_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray posJSON = (JSONArray)new JSONParser().parse(reader);
        
            for(int i =0; i<posJSON.size();i++){
                JSONObject possJSON = (JSONObject)posJSON.get(i);
                String name = (String)possJSON.get(PERSON_OF_INTEREST_NAME);
                String address = (String)possJSON.get(PERSON_OF_INTEREST_ADDRESS);
                int dob = ((Long)possJSON.get(PERSON_OF_INTEREST_DOB)).intValue();
                String description = (String)possJSON.get(PERSON_OF_INTEREST_DESCRIPTION);
                String gender = (String)possJSON.get(PERSON_OF_INTEREST_GENDER);
                String race = (String)possJSON.get(PERSON_OF_INTEREST_RACE);
                String hairColor = (String)possJSON.get(PERSON_OF_INTEREST_HAIR_COLOR);
                double weight = ((Long)possJSON.get(PERSON_OF_INTEREST_WEIGHT)).doubleValue();
                double height = ((Long)possJSON.get(PERSON_OF_INTEREST_HEIGHT)).doubleValue();
                String tattoo = (String)possJSON.get(PERSON_OF_INTEREST_TATTOO);
                boolean criminalRecord = (boolean)possJSON.get(PERSON_OF_INTEREST_CRIMINAL_RECORD);
                int age = ((Long)possJSON.get(PERSON_OF_INTEREST_AGE)).intValue();

                personofinterest.add(new PersonOfInterest(null, gender, race, hairColor, height, 
                weight, tattoo, criminalRecord, age));
            }
            return personofinterest;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

