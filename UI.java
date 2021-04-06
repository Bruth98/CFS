import java.util.Scanner;
import java.util.Random;

//import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
public class UI {
    private String[] mainMenu = {"Create Account", "Login", "Get Cases", "Add Case", "Find Suspects"};
    private String[] searchBy = {"First Name", "Last Name", "Age", "Height", "Weight", "Gender", "Crime Type", "Tattoo Description", "Hair Color"};
    private Scanner keyboard;
    private CFS cfs;
    private boolean loggedIn = false;

    UI() {
        keyboard = new Scanner(System.in);
        cfs = new CFS();
    }

    public static void main(String[] args) {
        UI Ui = new UI();
        Ui.play();
    }

    public void play() {
        System.out.println("****************************************");
        System.out.println("Welcome to Crime Fighter Software!");
        while (true) {
            displayMainMenu();
            int userCommand = getUserCommand(mainMenu.length);
            if (userCommand == -1) {
                System.out.println("Not a valid choice. Try again.");
            }
            if (userCommand == (mainMenu.length - 1)) {
                    cfs.logout();
            }
            switch (userCommand) {
                case(0):  // Create Account
                    createAccount();
                    break;
                case(1):  // Login
                    login();
                    break;
                case(2):  // Get all Cases
                    getCases();
                    break;
                case(3):  // Add a Case
                    addCase();  // needs to be added
                    break;
                case(4):  // Get all Suspects (Going to need one that allows searches for tattooDescripton, one for age, one for hair color, and one for height.)
                    getSuspects();  // maybe ask how they want to search inside of this method, then call the specific search inside of here.
                    /*
                    Clarification: After looking at the scenarios it actually seems like
                                   we need a getSuspect(tattooDescription) and a getSuspect(age, haircare, height).
                    ALSO: In no scenarios do we need to add a suspect, so if we just load in JSON files, do we even need an addSuspect method?
                    */
                    break;
            }
            System.out.println("***** Users Online *****");
            displayUsers();
        }
    }

    /*
    Create Account
    */
    private void createAccount() {
        int userID = getFieldInt("userID");
        keyboard.nextLine();
        String password = getField("password");
        if (cfs.createAccount(userID, password)) {
            System.out.println("You have successfully created an account.");
        }
        else {
            System.out.println("Sorry, that user already exists.");
        }
    }

    /*
    Login
    */
    private void login() {
        int userID = getFieldInt("User ID");
        String password = getField("Password");
        if (cfs.login(userID, password)) {
            loggedIn = true;
        }
        else {
            System.out.println("Sorry, that is not a User Name in the system.");
        }
    }

    /*
    Get all Cases
    */
    private void getCases() {
        /*
        if(!loggedIn) {
            System.out.println("Sorry, please log in first.");
            return;
        }
        */
        System.out.println("Searching Cases");
        int caseID = getCaseID();
        if (caseID == 0) { 
            return;
        }

        if (cfs.findCases(caseID)) {
            Case case2 = cfs.getCase(caseID);
            System.out.println(case2.toString());
        }
        
    }

    /*
    Find Specific Case
    */
    private int getCaseID() {
        System.out.println("Enter Case ID: ");
        while (true) {
            int caseID = keyboard.nextInt();
            if (caseID > 0) {
                return caseID;
            }
            System.out.println("Please enter a valid Case ID.");
            System.out.println("Would you like to try again? Please enter \"y\" or \"n\"");
            String ans = keyboard.nextLine();
            if (ans == "n") {
                return 0;
            }
        }
    }

    /*
    Add a Case
    */
    private void addCase() {
        /*
        if (!loggedIn) {
            System.out.println("Sorry, you have to be logged in to add a Case.");
            return;
        }
        */
        Crime crime = fillCrime();  // get the type of crime
        ArrayList<Suspect> suspects = fillSuspects();  // Add the suspects
        ArrayList<Witness> witnesses = fillWitnesses();
        ArrayList<Victim> victims = fillVictims();
        ArrayList<Evidence> evidence = fillEvidence();
        Random r = new Random();
        int caseID = r.nextInt(1000);
        System.out.println("Please enter the date this occurred (in format MMDDYYYY).");
        int date = keyboard.nextInt();
        /*
        String dateString = String.valueOf(date);  // converting dob to string to check for formatting errors
        if (date > 99999999 || (dateString.length() < 7 || dateString.length() > 8)) {
            boolean formatted = false;
            while (!formatted) {
                System.out.println("Sorry, not a valid date. Please try again.");
                date = keyboard.nextInt();
                dateString = String.valueOf(date);
                if (date <= 99999999 && dateString.length() == 8) {
                    formatted = true;
                }
            }
        }
        */
        System.out.println("Enter the location of the crime.");
        String location = keyboard.nextLine();
        System.out.println("Case Added.");
        Case case2 = new Case(crime, suspects, witnesses, victims, evidence, caseID, date, location);
        System.out.println(case2.toString());
    }

    /*
    Fill out the Crime in a case
    */
    private Crime fillCrime() {
        System.out.println("*************** Adding Crime ***************");
        System.out.println("Enter the type of Crime: ");
        String type = keyboard.nextLine();
        
        System.out.println("Is this a felony? Enter \"true\" or \"false\".");
        boolean felony = keyboard.nextBoolean();
        Crime crime = new Crime(type, felony);
        System.out.println("********************************************");
        return crime;
    }

    /*
    Add Suspects to a Case
    */
    private ArrayList<Suspect> fillSuspects() {
        System.out.println("************ Adding Suspects ************");
        System.out.println("How many Suspects are there?");
        int numSuspects = keyboard.nextInt();
        ArrayList<Suspect> suspectList = new ArrayList<Suspect>();
        for (int i = 0; i < numSuspects; i++) {
            System.out.println("************ Suspect #"+(i+1)+" ************");
            System.out.println("Enter Suspect's Name: ");
            String name = keyboard.nextLine();
            keyboard.nextLine();
            System.out.println("Enter a known address:");
            String address = keyboard.nextLine();
        

            System.out.println("Enter suspect's D.O.B. (in format MMDDYYYY):");
            int dob = keyboard.nextInt();
            /*
            String dobString = String.valueOf(dob);  // converting dob to string to check for formatting errors
            if (dob > 99999999 || (dobString.length() < 7 || dobString.length() > 8)) {
                boolean formatted = false;
                while (!formatted) {
                    System.out.println("Sorry, not a valid D.O.B. Please try again.");
                    dob = keyboard.nextInt();
                    dobString = String.valueOf(dob);
                    if (dob > 99999999 || (dobString.length() < 7 || dobString.length() > 8)) {
                        formatted = true;
                    }
                }
            }
            */
            System.out.println("Enter suspect's age: ");
            int age = keyboard.nextInt();
            keyboard.nextLine();

            System.out.println("Enter a description of the suspect: ");
            String description = keyboard.nextLine();
            

            System.out.println("Enter suspect's height: ");
            double height = keyboard.nextDouble();
            keyboard.nextLine();

            System.out.println("Enter suspect's weight: ");
            double weight = keyboard.nextDouble();
            keyboard.nextLine();

            System.out.println("Enter suspect's gender: ");
            String gender = keyboard.nextLine();
            

            System.out.println("Enter suspect's race: ");
            String race = keyboard.nextLine();
            

            System.out.println("Enter suspect's hair color: ");
            String hairColor = keyboard.nextLine();
            

            System.out.println("Does the suspect have a tattoo? Enter \"y\" for yes or \"n\" for no. ");
            String hasTattoo = keyboard.nextLine();
            
            String tattoo;
            if (hasTattoo.equals("y")) {
                System.out.println("Please enter a description of the suspect's tattoo:");
                tattoo = keyboard.nextLine();
            }
            else {
                tattoo = "N/A";
            }

            System.out.println("Please enter the suspect's phone number: ");
            long phoneNum = keyboard.nextLong();
            // keyboard.nextLine();
            // keyboard.next();


            System.out.println("Does the suspect have a Criminal Record? Enter \"true\" if yes or \"false\" if no.");
            boolean criminalRecord = keyboard.nextBoolean();
            keyboard.nextLine();

            Suspect suspect = new Suspect(name, address, dob, description, gender, 
            race, hairColor, height, weight, tattoo, criminalRecord,age, phoneNum);
            suspectList.add(suspect);
            System.out.println("********************************************");
            System.out.println();
            
        }
        System.out.println("********************************************");
        System.out.println();
        return suspectList;
    }

    /*
    Adding Witnesses to a case
    */
    private ArrayList<Witness> fillWitnesses() {
        System.out.println("************* Adding Witnesses *************");
        int numWitness;
        System.out.println("How many witnesses are there?");
        numWitness = keyboard.nextInt();
        ArrayList<Witness> witnessList = new ArrayList<Witness>();
        for (int i = 0; i < numWitness; i++) {
            System.out.println("************ Witness #"+(i+1)+" ************");

            System.out.println("Please enter the witness's name:");
            String name = keyboard.nextLine();
            keyboard.nextLine();

            System.out.println("Please enter the witness's address: ");
            String address = keyboard.nextLine();

            System.out.println("Please enter the witness's D.O.B.:");
            int dob = keyboard.nextInt();
            /*
            String dobString = String.valueOf(dob);  // converting dob to string to check for formatting errors
            if (dob > 99999999 || (dobString.length() < 7 || dobString.length() > 8)) {
                boolean formatted = false;
                while (!formatted) {
                    System.out.println("Sorry, not a valid D.O.B. Please try again.");
                    dob = keyboard.nextInt();
                    dobString = String.valueOf(dob);
                    if (dob > 99999999 || (dobString.length() < 7 || dobString.length() > 8)) {
                        formatted = true;
                    }
                }
            }
            */
            System.out.println("Please enter the witness's statement:");
            String statement = keyboard.nextLine();
            keyboard.nextLine();

            System.out.println("Does the witness have a relationship to the victim? Enter \"true\" for yes or \"false\" for no.");
            boolean relationToVictim = keyboard.nextBoolean();

            Witness witness = new Witness(name, address, dob, statement, relationToVictim);
            witnessList.add(witness);
            System.out.println("********************************************");
        }
        System.out.println("********************************************");
        return witnessList;
    }

    /*
    Adding Victims to a Case
    */
    private ArrayList<Victim> fillVictims() {
        System.out.println("************ Adding Victims ************");
        int numVictims;
        System.out.println("How many victims are there?");
        numVictims = keyboard.nextInt();
        ArrayList<Victim> victimList = new ArrayList<Victim>();
        for (int i = 0; i < numVictims; i++) {
            System.out.println("************ Victim #"+(i+1)+" ************");
            System.out.println("Please enter the victim's name:");
            String name = keyboard.nextLine();
            keyboard.nextLine();

            System.out.println("Please enter the victim's address: ");
            String address = keyboard.nextLine();
            

            System.out.println("Please enter the victim's D.O.B.:");
            int dob = keyboard.nextInt();
            /*
            String dobString = String.valueOf(dob);  // converting dob to string to check for formatting errors
            if (dob > 99999999 || (dobString.length() < 7 || dobString.length() > 8)) {
                boolean formatted = false;
                while (!formatted) {
                    System.out.println("Sorry, not a valid D.O.B. Please try again.");
                    dob = keyboard.nextInt();
                    dobString = String.valueOf(dob);
                    if (dob > 99999999 || (dobString.length() < 7 || dobString.length() > 8)) {
                        formatted = true;
                    }
                }
            }
            */
            System.out.println("Is the victim alive? Enter \"true\" for yes or \"false\" for no.");
            boolean alive = keyboard.nextBoolean();
            String statement;
            if (!alive) {
                statement = "N/A";
            }
            else {
                System.out.println("Please enter the victim's statement:");
                statement = keyboard.nextLine();
                keyboard.nextLine();
            }
            System.out.println("Please enter the victim's phone number:");
            long phoneNum = keyboard.nextLong();

            Victim victim = new Victim(name, address, dob, statement, alive, phoneNum);
            victimList.add(victim);
            System.out.println("********************************************");
            System.out.println();
        }
        System.out.println("********************************************");
        return victimList;
    }

    /*
    Adding Evidence to a Case
    */
    private ArrayList<Evidence> fillEvidence() {
        System.out.println("************ Adding Evidence ************");
        int numEvidence;
        Random r = new Random();
        int evidenceID = r.nextInt(1000);
        System.out.println("How many pieces of evidence are there?");
        numEvidence = keyboard.nextInt();
        ArrayList<Evidence> evidenceList = new ArrayList<Evidence>();
        for (int i = 0; i < numEvidence; i++) {
            System.out.println("************ Evidence #"+(i+1)+" ************");
            System.out.println("Is the evidence a weapon? Enter \"true\" for yes or \"false\" for no.");
            boolean weapon = keyboard.nextBoolean();
            boolean drugs = false;
            if (!weapon) {
                System.out.println("Is the evidence drugs? Enter \"true\" for yes or \"false\" for no.");
                drugs = keyboard.nextBoolean();
            }
            System.out.println("Please enter the description: ");
            String description = keyboard.nextLine();
            keyboard.nextLine();

            System.out.println("Are there fingerprints? Enter \"true\" for yes or \"false\" for no.");
            boolean fingerprints = keyboard.nextBoolean();

            System.out.println("Enter where this evidence was found:");
            String location = keyboard.nextLine();
            keyboard.nextLine();
            Evidence evidence = new Evidence(description, location, weapon, drugs, fingerprints);
            evidenceList.add(evidence);
            System.out.println("********************************************");
        }
        System.out.println("********************************************");
        return evidenceList;
    }

    /*
    Gets Suspects
    */
    private void getSuspects() {
        Scanner keyboard = new Scanner(System.in);
        int input = 0;
        String sInput;
        int input1;
        double inputD;
        ArrayList<String> personID = new ArrayList<String>();
        displaySearchChoices();
        System.out.println("Enter the number of Categories you would like to search for");
        input = keyboard.nextInt();
        keyboard.nextLine();
        keyboard.next();
        ArrayList<Person> personFound = new ArrayList<Person>();
        
        for(int i=0; i<input;i++){
            System.out.println("Keyword:" + (i+1) + " ");
            sInput = keyboard.nextLine();
            keyboard.next();
            sInput.toLowerCase();
            if(sInput.equals("name")){
                System.out.println("Enter name");
                sInput = keyboard.nextLine();
                keyboard.next();
                personFound.addAll(Database.getFirst(sInput));
            }
            else if(sInput.equals("age")){
                System.out.println("Enter age");
                input1 = keyboard.nextInt();
                keyboard.nextLine();
                keyboard.next();
                personFound.addAll(Database.getAge(input1));
            }
            else if(sInput.equals("height")){
                System.out.println("Enter height");
                inputD = keyboard.nextDouble();
                keyboard.nextLine();
                keyboard.next();
                personFound.addAll(Database.getHeight(inputD));
            }
            else if(sInput.equals("weight")){
                System.out.println("Enter weight");
                inputD = keyboard.nextDouble();
                keyboard.nextDouble();
                personFound.addAll(Database.getWeight(inputD));
            }
            else if(sInput.equals("gender")){
                System.out.println("Enter gender");
                sInput = keyboard.nextLine();
                keyboard.next();
                personFound.addAll(Database.getGender(sInput));
            }
            /*
            else if(sInput.equals("crime")){
                System.out.println("Enter crime");
                sInput = keyboard.nextLine();
                personFound.addAll(Database.getCrime(sInput));
            }
            */
            else if(sInput.equals("tattoo")){
                System.out.println("Enter tattoo description");
                sInput = keyboard.nextLine();
                keyboard.next();
                personFound.addAll(Database.getTattooDescription(sInput));
            }
            else if(sInput.equals("hair color")){
                System.out.println("Enter hair color");
                sInput = keyboard.nextLine();
                keyboard.next();
                personFound.addAll(Database.getHairColor(sInput));
            }
        }
    
    }

    /*
    Main Menu Options
    */
    private void displayMainMenu() {
        System.out.println("\n************ Main Menu *************");
        for(int i=0; i< mainMenu.length; i++) {
            System.out.println((i+1) + ". " + mainMenu[i]);
        }
        System.out.println("\n");
    }

    /*
    Search Suspect Options
    */
    private void displaySearchChoices() {
        System.out.println("************ Search By ************");
        for(int i=0; i < searchBy.length; i++) {
            System.out.println((i+1) + ". " + searchBy[i]);
        }
        System.out.println("\n***********************************");
    }

    /*
    Take in User input
    */
    private int getUserCommand(int numCommands) {
        System.out.println("What would you like to do? ");
        String input = keyboard.nextLine();
        
        int command = Integer.parseInt(input) - 1;

        if (command >= 0 && command <= numCommands - 1) {
            return command;
        }
        return -1;
    } 


    /*
    Gets each String field
    */
    private String getField(String prompt) {

        System.out.print(prompt + ": ");
        return keyboard.nextLine();
    }

    /*
    Gets each int field
    */
    private int getFieldInt(String prompt) {

        System.out.print(prompt + ": ");
        return keyboard.nextInt();
    }

    /*
    Gets each double field
    */
    private double getFieldDouble(String prompt) {

        System.out.print(prompt + ": ");
        return keyboard.nextDouble();
    }

    /*
    Gets each boolean field
    */
    private boolean getFieldBool(String prompt) {

        System.out.print(prompt + ": ");
        return keyboard.nextBoolean();
    }

    public void displayUsers(){
        Users user2 = Users.getInstance(); // ask
        ArrayList<User> users = user2.getUsers();
    }
}
