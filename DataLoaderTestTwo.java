import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.simple.JSONArray;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class DataLoaderTestTwo {
    private Persons persons = Persons.getInstance();
    private ArrayList<Person> personList = persons.getPerson();

    private Crimes crimes = Crimes.getInstance();
    private ArrayList<Crime> crimeList = crimes.getCrimes();

    private Evidences evidences = Evidences.getInstance();
    private ArrayList<Evidence> evidenceList = evidences.getEvidence();

    private Officers officers = Officers.getInstance();
    private ArrayList<Officer> officerList = officers.getOfficers();

    private Suspects suspects = Suspects.getInstance();
    private ArrayList<Suspect> suspectList = suspects.getSuspects();

    private Victims victims = Victims.getInstance();
    private ArrayList<Victim> victimList = victims.getVictims();

    private Cases cases = Cases.getInstance();
    private ArrayList<Case> caseList = cases.getCases();

    private Witnesses witnesses = Witnesses.getInstance();
    private ArrayList<Witness> witnessList = witnesses.getWitnesses();

    @BeforeEach
    public void setup(){
        personList.clear();
        personList.add(new Person("Michael Sana", "105 Sandhurst Drive", 042601, 19,"white male"));
        personList.add(new Person("Brady Ruth", "Somewhere in Cola", 000000, 20, "White male"));
        DataWriter.savePersons();

        crimeList.clear();
        crimeList.add(new Crime("robbery", true));
        crimeList.add(new Crime("shooting", false));
        DataWriter.saveCrimes();

        evidenceList.clear();
        evidenceList.add(new Evidence("knife", "on the sidewalk", true, false, true));
        evidenceList.add(new Evidence("sock", "idk", false,true,false));
        DataWriter.saveEvidence();

        officerList.clear();
        officerList.add(new Officer("Michael", "Sana", "crime"));
        officerList.add(new Officer("Brady", "Ruth", "crime"));
        DataWriter.saveOfficers();
        /** 
        suspectList.clear();
        suspectList.add(new Suspect("male", "american", "brown", "Michael Sana", "105 Sandhurts Drive", "white male", 042601, 45, 120, "dove", 19, false, 0000000000));
        suspectList.add(new Suspect("male", "american", "white", "Brady Ruth", "somewhere in cola", "white male", 000000, 50,140, "none", 20, true, 0000000000));
        */

        victimList.clear();
        victimList.add(new Victim("Michael", "105 Sandhurst Drive", 042601, "white male", true, 0000000000));
        victimList.add(new Victim("Brady", "somewhere in cola", 000000, "white male", false, 0000000000));
        DataWriter.saveVictims();

        witnessList.clear();
        witnessList.add(new Witness("Michael", "address",042601,"description", true));
        witnessList.add(new Witness("name", "address", 000000, "description", false));
        DataWriter.saveWitness();
        



    }

    @AfterEach
    public void tearDown(){
        Persons.getInstance().getPerson().clear();
        DataWriter.savePersons();

        Crimes.getInstance().getCrimes().clear();
        DataWriter.saveCrimes();

        Evidences.getInstance().getEvidence().clear();
        DataWriter.saveEvidence();

        Officers.getInstance().getOfficers().clear();
        DataWriter.saveOfficers();

        Victims.getInstance().getVictims().clear();
        DataWriter.saveVictims();

        Cases.getInstance().getCases().clear();
        DataWriter.saveCase();

        Witnesses.getInstance().getWitnesses().clear();
        DataWriter.saveWitness();

    }
    
    @Test
    public void testGetPersonFirstPersonName(){
        personList = DataLoader.loadPersons();
        assertEquals("Michael Sana", personList.get(0).getName());
    }

    @Test
    public void testGetPersonSize(){
        personList = DataLoader.loadPersons();
        assertEquals(2, personList.size());
    }

    @Test
    public void testGetPersonSizeZero(){
        Persons.getInstance().getPerson().clear();
        DataWriter.savePersons();
        assertEquals(0, personList.size());
    }


    @Test
    public void testGetPersonFirstPersonDOB(){
        personList = DataLoader.loadPersons();
        assertEquals(042601, personList.get(2).getDOB());
    }

    @Test
    public void testGetPersonFirstPersonAge(){
        personList = DataLoader.loadPersons();
        assertEquals(19, personList.get(3).getAge());
    }

    @Test
    public void testGetPersonFirstPersonDescription(){
        personList = DataLoader.loadPersons();
        assertEquals("white male", personList.get(4).getDescription());
    }

    @Test
    public void testGetPersonFirstPersonAddress(){
        personList = DataLoader.loadPersons();
        assertEquals("105 Sandhurst Drive", personList.get(5).getAddress());
    }


    //second person

    @Test
    public void testGetPersonSecondPersonName(){
        personList = DataLoader.loadPersons();
        assertEquals("Brady Ruth", personList.get(6).getName());
    }
    @Test
    public void testGetPersonSecondPersonDOB(){
        personList = DataLoader.loadPersons();
        assertEquals(000000, personList.get(7).getDOB());
    }

    @Test
    public void testGetPersonSecondPersonAge(){
        personList = DataLoader.loadPersons();
        assertEquals(20, personList.get(8).getAge());
    }

    @Test
    public void testGetPersonSecondPersonDescription(){
        personList = DataLoader.loadPersons();
        assertEquals("white male", personList.get(9).getDescription());
    }

    @Test
    public void testGetPersonSecondPersonAddress(){
        personList = DataLoader.loadPersons();
        assertEquals("Somewhere in cola", personList.get(10).getAddress());
    }

    @Test
    public void testGetCrimeSize(){
        crimeList = DataLoader.loadCrime();
        assertEquals(2, crimeList.size());
    }

    @Test
    public void testGetCrimeSizeZero(){
        Crimes.getInstance().getCrimes().clear();
        DataWriter.saveCrimes();
        assertEquals(0, crimeList.size());
    }

    @Test
    public void testGetCrimeFirstCrimeType(){
        crimeList = DataLoader.loadCrime();
        assertEquals("robbery", crimeList.get(0).getType());
    }

    @Test
    public void testGetCrimeFirstCrimeFelony(){
        crimeList = DataLoader.loadCrime();
        assertEquals(true, crimeList.get(1).isFelony());
    }

    @Test
    public void testGetCrimeSecondCrimeType(){
        crimeList = DataLoader.loadCrime();
        assertEquals("shooting", crimeList.get(2).getType());
    }

    @Test
    public void testGetCrimeSecondCrimeFelony(){
        crimeList = DataLoader.loadCrime();
        assertEquals(false, crimeList.get(3).getType());
    }

    @Test
    public void testGetEvidenceSize(){
        evidenceList = DataLoader.loadEvidence();
        assertEquals(2, evidenceList.size());
    }

    @Test
    public void testGetEvidenceSizeZero(){
        Evidences.getInstance().getEvidence().clear();
        DataWriter.saveEvidence();
        assertEquals(0, evidenceList.size());
    }

    @Test
    public void testGetEvidenceFirstEvidenceDescription(){
        evidenceList = DataLoader.loadEvidence();
        assertEquals("knife", evidenceList.get(0).getDescription());
    }

    @Test
    public void testGetEvidenceFirstEvidenceLocation(){
        evidenceList = DataLoader.loadEvidence();
        assertEquals("on the sidewalk", evidenceList.get(1).getLocation());
    }

    @Test
    public void testGetEvidenceFirstEvidenceWeapon(){
        evidenceList = DataLoader.loadEvidence();
        assertEquals(true, evidenceList.get(2).isWeapon());
    }

    @Test
    public void testGetEvidenceFirstEvidenceDrugs(){
        evidenceList = DataLoader.loadEvidence();
        assertEquals(false, evidenceList.get(3).isDrugs());
    }

    @Test
    public void testGetEvidenceFirstEvidenceFingerprints(){
        evidenceList = DataLoader.loadEvidence();
        assertEquals(false, evidenceList.get(4).hasFingerprints());
    }

    @Test
    public void testGetEvidenceSecondEvidenceDescription(){
        evidenceList = DataLoader.loadEvidence();
        assertEquals("socks", evidenceList.get(5).getDescription());
    }

    @Test
    public void testGetEvidenceSecondEvidenceLocation(){
        evidenceList = DataLoader.loadEvidence();
        assertEquals("idk", evidenceList.get(6).getLocation());
    }

    @Test
    public void testGetEvidenceSecondEvidenceWeapon(){
        evidenceList = DataLoader.loadEvidence();
        assertEquals(false, evidenceList.get(7).isWeapon());
    }

    @Test
    public void testGetEvidenceSecondEvidenceDrugs(){
        evidenceList = DataLoader.loadEvidence();
        assertEquals(true, evidenceList.get(8).isDrugs());
    }

    @Test
    public void testGetEvidenceSecondEvidenceFingerprint(){
        evidenceList = DataLoader.loadEvidence();
        assertEquals(false, evidenceList.get(9).hasFingerprints());
    }

    @Test
    public void testGetOfficerSize(){
        officerList = DataLoader.loadOfficer();
        assertEquals(2, officerList.size());
    }

    @Test
    public void testGetOfficerSizeZero(){
        Officers.getInstance().getOfficers().clear();
        officerList = DataLoader.loadOfficer();
        assertEquals(0, officerList.size());
    }

    @Test
    public void testGetOfficerFirstOfficerFirstName(){
        officerList = DataLoader.loadOfficer();
        assertEquals("Michael", officerList.get(0).getFirstName());
    }

    @Test
    public void testGetOfficerFirstOfficerLastName(){
        officerList = DataLoader.loadOfficer();
        assertEquals("Sana", officerList.get(1).getLastName());
    }

    @Test
    public void testGetOfficerFirstOfficerDepartment(){
        officerList = DataLoader.loadOfficer();
        assertEquals("crime", officerList.get(2).getDepartment());
    }

    @Test
    public void testGetOfficerSecondOfficerFirstName(){
        officerList = DataLoader.loadOfficer();
        assertEquals("Brady", officerList.get(3).getFirstName());
    }

    @Test
    public void testGetOfficerSecondOfficerLastName(){
        officerList = DataLoader.loadOfficer();
        assertEquals("Ruth", officerList.get(4).getLastName());
    }

    @Test
    public void testGetOfficerSecondOfficerDepartment(){
        officerList = DataLoader.loadOfficer();
        assertEquals("crime", officerList.get(5).getDepartment());
    }

    @Test
    public void testGetVictimSize(){
        victimList = DataLoader.loadVictim();
        assertEquals(2, victimList.size());
    }

    @Test
    public void testGetVictimSizeZero(){
        Victims.getInstance().getVictims().clear();
        victimList = DataLoader.loadVictim();
        assertEquals(0, victimList.size());
    }

    @Test
    public void testGetVictimFirstVictimName(){
        victimList = DataLoader.loadVictim();
        assertEquals("Michael", victimList.get(0).getName());
    }

    @Test
    public void testGetVictimFirstVictimAddress(){
        victimList = DataLoader.loadVictim();
        assertEquals("105 Sandhurst Drive", victimList.get(1).getAddress());
    }

    @Test
    public void testGetVictimFirstVictimDescription(){
        victimList = DataLoader.loadVictim();
        assertEquals("white male", victimList.get(2).getDescription());
    }

    @Test
    public void testGetVictimFirstVictimDOB(){
        victimList = DataLoader.loadVictim();
        assertEquals(042601, victimList.get(3).getDOB());
    }

    @Test
    public void testGetVictimFirstVictimPhoneNumber(){
        victimList = DataLoader.loadVictim();
        assertEquals(0000000000, victimList.get(4).getPhoneNum());
    }

    @Test
    public void testGetVictimFirstVictimAlive(){
        victimList = DataLoader.loadVictim();
        assertEquals(true, victimList.get(5).getStatus());
    }

    @Test
    public void testGetVictimSecondVictimName(){
        victimList = DataLoader.loadVictim();
        assertEquals("brady", victimList.get(6).getName());
    }

    @Test
    public void testgetVictimSecondVictimAddress(){
        victimList = DataLoader.loadVictim();
        assertEquals("somewhere in cola", victimList.get(7).getAddress());
    }

    @Test
    public void testgetVictimSecondVictimDescription(){
        victimList = DataLoader.loadVictim();
        assertEquals("white male", victimList.get(8).getDescription());
    }

    @Test
    public void testGetvictimSecondVictimDOB(){
        victimList = DataLoader.loadVictim();
        assertEquals(000000, victimList.get(9).getDOB());
    }

    @Test
    public void testGetVictimSecondVictimPhoneNum(){
        victimList = DataLoader.loadVictim();
        assertEquals(0000000000, victimList.get(10).getPhoneNum());
    }

    @Test
    public void testGetVictimSecondVictimAlive(){
        victimList = DataLoader.loadVictim();
        assertEquals(true, victimList.get(11).getStatus());
    }

    @Test
    public void testGetWitnessSize(){
        witnessList = DataLoader.loadWitnesses();
        assertEquals(2, witnessList.size());
    }

    @Test
    public void testGetWitnessSizeZero(){
        Witnesses.getInstance().getWitnesses().clear();
        witnessList = DataLoader.loadWitnesses();
        assertEquals(0, witnessList.size());
    }

    @Test
    public void testGetWitnessFirstWitnessName(){
        witnessList = DataLoader.loadWitnesses();
        assertEquals("Michael", witnessList.get(0).getName());
    }

    @Test
    public void testGetWitnessFirstWitnessAddress(){
        witnessList = DataLoader.loadWitnesses();
        assertEquals("address", witnessList.get(1).getAddress());
    }

    @Test
    public void testGetWitnessFirstWitnessDOB(){
        witnessList = DataLoader.loadWitnesses();
        assertEquals(042601, witnessList.get(2).getDOB());
    }

    @Test
    public void testGetWitnessFirstWitnessDescription(){
        witnessList = DataLoader.loadWitnesses();
        assertEquals("description", witnessList.get(3).getDescription());
    }

    @Test
    public void testGetWitnessFirstWitnessRelated(){
        witnessList = DataLoader.loadWitnesses();
        assertEquals(true, witnessList.get(4).getRelation());
    }

    @Test
    public void testGetWitnessSecondWitnessName(){
        witnessList = DataLoader.loadWitnesses();
        assertEquals("name", witnessList.get(5).getName());
    }

    @Test
    public void testGetWitnessSecondWitnessAddress(){
        witnessList = DataLoader.loadWitnesses();
        assertEquals("address", witnessList.get(6).getAddress());
    }

    @Test
    public void testGetWitnessSecondWitnessDOB(){
        witnessList = DataLoader.loadWitnesses();
        assertEquals(000000, witnessList.get(7).getDOB());
    }

    @Test
    public void testGetWitnessSecondWitnessDescription(){
        witnessList = DataLoader.loadWitnesses();
        assertEquals("description", witnessList.get(8).getDescription());
    }

    @Test
    public void testGetWitnessSecondWitnessRelated(){
        witnessList = DataLoader.loadWitnesses();
        assertEquals(true, witnessList.get(9).getRelation());
    }

}
