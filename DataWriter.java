import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class DataWriter extends DataConstants {
    public static void savePersons(){
        Persons persons = Persons.getInstance(); 
        ArrayList<Person> person = persons.getPerson();
        JSONArray jsonPerson = new JSONArray();

        for(int i=0; i< person.size(); i++){
            jsonPerson.add(getPersonJSON(person.get(i)));
        }
        try(FileWriter file = new FileWriter(PERSON_FILE_NAME)){
            file.write(jsonPerson.toJSONString());
            file.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static JSONObject getPersonJSON(Person person){
        JSONObject personDetails = new JSONObject();
        personDetails.put(PERSON_NAME, person.getName());
        personDetails.put(PERSON_ADDRESS, person.getAddress());
        personDetails.put(PERSON_DESCRIPTION,person.getDescription());
        personDetails.put(PERSON_DOB, person.getDOB());

        return personDetails;
    }

    public static void saveUsers(){
        Users users = Users.getInstance();
        ArrayList<User> user = users.getUsers();
        
        JSONArray jsonUser = new JSONArray();
        
        for(int i=0; i< user.size(); i++){
            jsonUser.add(getUserJSON(user.get(i)));
        }
        try(FileWriter file = new FileWriter(USER_FILE_NAME)){
            file.write(jsonUser.toJSONString());
            file.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static JSONObject getUserJSON(User user){
        JSONObject userDetails = new JSONObject();
        userDetails.put(EMPLOYEE_PASSWORD, user.getPassword());
        userDetails.put(EMPLOYEE_ID, user.getUserID());

        return userDetails;
    }

    public static void saveAdmins(){
        Admins admins = Admins.getInstance();
        ArrayList<Admin> admin = admins.getAdmins();
        JSONArray jsonAdmin = new JSONArray();

        for(int i=0; i<admin.size(); i++){
            jsonAdmin.add(getAdminJSON(admin.get(i)));
        }
        try(FileWriter file = new FileWriter(ADMIN_FILE_NAME)){
            file.write(jsonAdmin.toJSONString());
            file.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static JSONObject getAdminJSON(Admin admin){
        JSONObject adminDetails = new JSONObject();
        adminDetails.put(ADMIN_FIRST_NAME, admin.getFirstName());
        adminDetails.put(ADMIN_LAST_NAME, admin.getFirstName());

        return adminDetails;
    }


    public static void saveCrimes(){
        Crimes crimes = Crimes.getInstance();
        ArrayList<Crime> crime = crimes.getCrimes();
        JSONArray jsonCrime = new JSONArray();

        for(int i=0; i<crime.size(); i++){
            jsonCrime.add(getCrimeJSON(crime.get(i)));
        }
        try(FileWriter file = new FileWriter(CRIME_FILE_NAME)){
            file.write(jsonCrime.toJSONString());
            file.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static JSONObject getCrimeJSON(Crime crime){
        JSONObject crimeDetails = new JSONObject();
        crimeDetails.put(CRIME_TYPE, crime.getType());
        crimeDetails.put(CRIME_FELONY, crime.isFelony());

        return crimeDetails;
    }

    public static void saveEvidence(){
        Evidences evidences = Evidences.getInstance();
        ArrayList<Evidence> evidence = evidences.getEvidence();
        JSONArray jsonEvidence = new JSONArray();

        for(int i=0; i<evidence.size(); i++){
            jsonEvidence.add(getEvidenceJSON(evidence.get(i)));
        }
        try(FileWriter file = new FileWriter(EVIDENCE_FILE_NAME)){
            file.write(jsonEvidence.toJSONString());
            file.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static JSONObject getEvidenceJSON(Evidence evidence){
        JSONObject evidenceDetails = new JSONObject();
        evidenceDetails.put(EVIDENCE_DESCRIPTION, evidence.getDescription());
        evidenceDetails.put(EVIDENCE_DRUGS, evidence.isDrugs());
        evidenceDetails.put(EVIDENCE_FINGERPRINTS, evidence.hasFingerprints());
        evidenceDetails.put(EVIDENCE_LOACTION, evidence.getLocation());
        evidenceDetails.put(EVIDENCE_WEAPON, evidence.isWeapon());

        return evidenceDetails;
    }

    public static void saveOfficers(){
        Officers officers = Officers.getInstance();
        ArrayList<Officer> officer = officers.getOfficers();
        JSONArray jsonOfficers = new JSONArray();

        for(int i=0; i<officer.size(); i++){
            jsonOfficers.add(getOfficerJSON(officer.get(i)));
        }
        try(FileWriter file = new FileWriter(OFFICER_FILE_NAME)){
            file.write(jsonOfficers.toJSONString());
            file.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static JSONObject getOfficerJSON(Officer officer){
        JSONObject officerDetails = new JSONObject();
        officerDetails.put(OFFICER_DEPARTMENT, officer.getDepartment());
        officerDetails.put(OFFICER_FIRST_NAME, officer.getFirstName());
        officerDetails.put(OFFICER_LAST_NAME, officer.getLastName());

        return officerDetails;
    }

    public static void saveSuspects(){
        Suspects suspects = Suspects.getInstance();
        ArrayList<Suspect> suspect = suspects.getSuspects();
        JSONArray jsonSuspect = new JSONArray();

        for(int i=0; i<suspect.size(); i++){
            jsonSuspect.add(getSuspectJSON(suspect.get(i)));
        }
        try(FileWriter file = new FileWriter(SUSPECT_FILE_NAME)){
            file.write(jsonSuspect.toJSONString());
            file.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static JSONObject getSuspectJSON(Suspect suspect){
        JSONObject suspectDetails = new JSONObject();
        suspectDetails.put(SUSPECT_CRIMINAL_RECORD, suspect.getCriminalRecord());
        suspectDetails.put(SUSPECT_GENDER, suspect.getGender());
        suspectDetails.put(SUSPECT_HAIR_COLOR, suspect.getHairColor());
        suspectDetails.put(SUSPECT_HEIGHT, suspect.getHeight());
        suspectDetails.put(SUSPECT_RACE, suspect.getRace());
        suspectDetails.put(SUSPECT_TATTOO, suspect.getTattoo());
        suspectDetails.put(SUSPECT_WEIGHT, suspect.getWeight());
        

        return suspectDetails;
    }

    public static void saveVictims(){
        Victims victims = Victims.getInstance();
        ArrayList<Victim> victim = victims.getVictims();
        JSONArray jsonVictim = new JSONArray();

        for(int i=0; i<victim.size(); i++){
            jsonVictim.add(getVictimJSON(victim.get(i)));
        }
        try(FileWriter file = new FileWriter(VICTIM_FILE_NAME)){
            file.write(jsonVictim.toJSONString());
            file.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static JSONObject getVictimJSON(Victim victim){
        JSONObject victimDetails = new JSONObject();
        victimDetails.put(VICTIM_ALIVE, victim.getStatus());
        victimDetails.put(VICTIM_PHONE_NUMBER, victim.getPhoneNum());
        victimDetails.put(VICTIM_ADDRESS, victim.getAddress());
        victimDetails.put(VICTIM_NAME, victim.getName());
        victimDetails.put(VICTIM_DESCRIPTION, victim.getDescription());
        victimDetails.put(VICTIM_DOB, victim.getDOB());
        
      
        return victimDetails;
    }

    public static void saveCase(){
        Cases cases = Cases.getInstance();
        ArrayList<Case> case2 = cases.getCases();
        JSONArray jsonCase = new JSONArray();

        for(int i=0; i<case2.size(); i++){
            jsonCase.add(getCaseJSON(case2.get(i)));
        }
        try(FileWriter file = new FileWriter(CASE_FILE_NAME)){
            file.write(jsonCase.toJSONString());
            file.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static JSONObject getCaseJSON(Case case2){
        JSONObject caseDetails = new JSONObject();
        caseDetails.put(CASE_ID, case2.getCaseID());
        caseDetails.put(CASE_DATE, case2.getDate());
        caseDetails.put(CASE_LOCATION, case2.getLocation());
        
      
        return caseDetails;
    }

    public static void saveWitness(){
        Witnesses witnesses = Witnesses.getInstance();
        ArrayList<Witness> witness = witnesses.getWitnesses();
        JSONArray jsonWitness = new JSONArray();

        for(int i=0; i<witness.size(); i++){
            jsonWitness.add(getWitnessJSON(witness.get(i)));
        }
        try(FileWriter file = new FileWriter(WITNESS_FILE_NAME)){
            file.write(jsonWitness.toJSONString());
            file.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static JSONObject getWitnessJSON(Witness witness){
        JSONObject witnessDetails = new JSONObject();
        witnessDetails.put(WITNESS_ADDRESS, witness.getAddress());
        witnessDetails.put(WITNESS_DESCRIPTION, witness.getDescription());
        witnessDetails.put(WITNESS_DOB, witness.getDOB());
        witnessDetails.put(WITNESS_NAME, witness.getName());
        witnessDetails.put(WITNESS_RELATION_TO_VICTIM, witness.getRelation());
        
      
        return witnessDetails;
    }

}
