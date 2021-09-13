/*
This is the main UI for the software
*/

import java.util.Scanner;
import java.util.Random;

//import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
public class UI {
    private String[] mainMenu = {"Create Account", "Login", "Get Cases", "Add Case", "Find Suspects"};  // Create a list of options for the main menu
    private String[] searchBy = {"First Name", "Last Name", "Age", "Height", "Weight", "Gender", "Crime Type", "Tattoo Description", "Hair Color"};  // Create a list of options
                                                                                                                                                     // to search by
    private Scanner keyboard;
    private CFS cfs;  // Establish the database
    private boolean loggedIn = false;

    UI() {
        keyboard = new Scanner(System.in);
        cfs = new CFS();
    }

    public static void main(String[] args) {
        UI Ui = new UI();
        Ui.play();
    }

    public void play() {  // Start of the program's interface
        System.out.println("****************************************");
        System.out.println("Welcome to Crime Fighter Software!");
        while (true) {
            displayMainMenu();
            int userCommand = getUserCommand(mainMenu.length);  // will return the user input (method on line 538)
            if (userCommand == -1) {
                System.out.println("Not a valid choice. Try again."); 
            }
            if (userCommand == (mainMenu.length - 1)) {
                    cfs.logout();  // if they chose to logout, logout
            }
            switch (userCommand) {
                case(0):  // If the user chose option 0, create account
                    createAccount();
                    break;
                case(1):  // If the user chose option 1, enter the log in interface
                    login();
                    break;
                case(2):  // If the user chose option 2, return the case that is searched for
                    getCases();
                    break;
                case(3):  // If the user chose option 3, start filling out a case
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
        int userID = getFieldInt("userID");  // take in the new user ID (we envisioned this as the officer's employee number)(method line 563)
        keyboard.nextLine();
        String password = getField("password");  // create a new password for this user (method on line 554)
        if (cfs.createAccount(userID, password)) {  // checks if the account is already created in the system
            System.out.println("You have successfully created an account.");  // if not, create a new account
            
        }
        else { 
            System.out.println("Sorry, that user already exists.");  // if there is an account, return with error)
        }
    }

    /*
    Login
    */
    private void login() {
        int userID = getFieldInt("User ID");
        String password = getField("Password");
        if (cfs.login(userID, password)) {  // check if user ID and password match an account in the system
            loggedIn = true;
        }
        else {
            System.out.println("Sorry, that is not an account in the system.");
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
        int caseID = getCaseID();  // get the ID of the case that the user wants to search for
        if (caseID == 0) {  // If the case ID is invalid
            return;
        }

        if (cfs.findCases(caseID)) {  // Search for the case in the database
            Case case2 = cfs.getCase(caseID);  // if a case is found, copy it to a new case for display
            System.out.println(case2.toString());  // print out the found case
        }
        
    }

    /*
    Find Specific Case
    */
    private int getCaseID() {
        System.out.println("Enter Case ID: ");
        while (true) {  // always run until there is a valid case ID or the user manually exits the loop
            int caseID = keyboard.nextInt();
            if (caseID > 0) {  // if the case ID is valid, return it to the searching method
                return caseID;
            }
            System.out.println("Please enter a valid Case ID.");  // if the case ID was not valid
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
        Crime crime = fillCrime();  // get the type of crime (method on line 183)
        ArrayList<Suspect> suspects = fillSuspects();  // Add the Suspects (method on line 198)
        ArrayList<Witness> witnesses = fillWitnesses();  // Add the Witnesses (method on line 293)
        ArrayList<Victim> victims = fillVictims();  // Add the Victims (method on line 343)
        ArrayList<Evidence> evidence = fillEvidence();  // Add the Evidence (method on line 401)
        Random r = new Random();
        int caseID = r.nextInt(1000);  // Create new ID for the case between 0000 and 1000
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
        String type = keyboard.nextLine();  // Capture the type of crime from the user
        
        System.out.println("Is this a felony? Enter \"true\" or \"false\".");
        boolean felony = keyboard.nextBoolean();  // capture if it is a felony or not
        Crime crime = new Crime(type, felony);
        System.out.println("********************************************");
        return crime;  // return the Crime to the overall Case
    }

    /*
    Add Suspects to a Case
    */
    private ArrayList<Suspect> fillSuspects() {
        System.out.println("************ Adding Suspects ************");
        System.out.println("How many Suspects are there?");
        int numSuspects = keyboard.nextInt();  // Capture how many times this method needs to be looped
        ArrayList<Suspect> suspectList = new ArrayList<Suspect>();  // Establish a list of Suspects
        for (int i = 0; i < numSuspects; i++) {  // Loop over the number of Suspects in the Case
            System.out.println("************ Suspect #"+(i+1)+" ************");
            System.out.println("Enter Suspect's Name: ");
            String name = keyboard.nextLine();  // Capture the Suspects name
            keyboard.nextLine();
            System.out.println("Enter a known address:");  
            String address = keyboard.nextLine();  // Capture the Suspect's address
        

            System.out.println("Enter suspect's D.O.B. (in format MMDDYYYY):");
            int dob = keyboard.nextInt();  // Capture the Suspects D.O.B.
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
            int age = keyboard.nextInt();  // Capture the Suspects age
            keyboard.nextLine();

            System.out.println("Enter a description of the suspect: ");
            String description = keyboard.nextLine();  // Capture a description of the Suspect
            

            System.out.println("Enter suspect's height: ");
            double height = keyboard.nextDouble();
            keyboard.nextLine();  // Capture the height of the suspect

            System.out.println("Enter suspect's weight: ");
            double weight = keyboard.nextDouble();  // Suspects weight
            keyboard.nextLine();

            System.out.println("Enter suspect's gender: ");
            String gender = keyboard.nextLine();  // Suspects gender
            

            System.out.println("Enter suspect's race: ");
            String race = keyboard.nextLine();  // Suspects race
            

            System.out.println("Enter suspect's hair color: ");
            String hairColor = keyboard.nextLine();  // Suspects hair color
            

            System.out.println("Does the suspect have a tattoo? Enter \"y\" for yes or \"n\" for no. ");
            String hasTattoo = keyboard.nextLine();  // does the Suspect have a tattoo
            
            String tattoo;
            if (hasTattoo.equals("y")) {
                System.out.println("Please enter a description of the suspect's tattoo:");
                tattoo = keyboard.nextLine();  // if yes, capture a description of the Suspects tattoo(s).
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
            race, hairColor, height, weight, tattoo, criminalRecord,age, phoneNum);  // Create a new Suspect with all the entered parameters
            suspectList.add(suspect);  // Add the suspect to the ArrayList
            System.out.println("********************************************");
            System.out.println();
            
        }
        System.out.println("********************************************");
        System.out.println();
        return suspectList;  // return the list of Suspects to the Case method to be added to the Case
    }

    /*
    Adding Witnesses to a case.
    This is much like the fillSuspects method, so commenting will be a bit more light
    */
    private ArrayList<Witness> fillWitnesses() {
        System.out.println("************* Adding Witnesses *************");
        int numWitness;
        System.out.println("How many witnesses are there?");
        numWitness = keyboard.nextInt();  // Capture how many Witnesses there are to loop over
        ArrayList<Witness> witnessList = new ArrayList<Witness>();  // Establish a list of Witnesses
        for (int i = 0; i < numWitness; i++) {  // loop over the number of Witnesses
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

            Witness witness = new Witness(name, address, dob, statement, relationToVictim);  // Create a new Witness with the entered parameters
            witnessList.add(witness);  // Add the Witness to the list
            System.out.println("********************************************");
        }
        System.out.println("********************************************");
        return witnessList;  // return the list of witnesses to the Case method to be attached to the Case.
    }

    /*
    Adding Victims to a Case
    This is much like the fillSuspects method, so commenting will be a bit more light
    */
    private ArrayList<Victim> fillVictims() {
        System.out.println("************ Adding Victims ************");
        int numVictims;
        System.out.println("How many victims are there?");
        numVictims = keyboard.nextInt();  // Establish how many victims there are in the case
        ArrayList<Victim> victimList = new ArrayList<Victim>();  // Establish a list of Victims for the Case
        for (int i = 0; i < numVictims; i++) {  // loop over the number of Victims
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

            Victim victim = new Victim(name, address, dob, statement, alive, phoneNum);  // Create a new Victim for the inserted parameters
            victimList.add(victim);  // Add the Victim to the Victim list
            System.out.println("********************************************");
            System.out.println();
        }
        System.out.println("********************************************");
        return victimList;  // return the Victim list to be added to the Case
    }

    /*
    Adding Evidence to a Case
    This is much like the fillSuspects method, so commenting will be a bit more light
    */
    private ArrayList<Evidence> fillEvidence() {
        System.out.println("************ Adding Evidence ************");
        int numEvidence;
        Random r = new Random();
        System.out.println("How many pieces of evidence are there?");  // get the number of pieces of Evidence
        numEvidence = keyboard.nextInt();
        ArrayList<Evidence> evidenceList = new ArrayList<Evidence>();  // Establish a list to hold the Evidence in
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
            Evidence evidence = new Evidence(description, location, weapon, drugs, fingerprints);  // Create a new piece of Evidence using the entered parameters
            evidenceList.add(evidence);  // Add the Evidence to the list
            System.out.println("********************************************");
        }
        System.out.println("********************************************");
        return evidenceList;  // return the Evidence list to the Case
    }

    /*
    Gets Suspects
    This method searches for specific suspects in the database based off of different search parameters.
    */
    private void getSuspects() {
        Scanner keyboard = new Scanner(System.in);
        int input = 0;
        String sInput;  // this is what will store what the user is searching for
        int input1;  // will be used when the user needs to search for an int
        double inputD;  // will be used when the user needs to search with a double
        ArrayList<String> personID = new ArrayList<String>();  
        displaySearchChoices();  // display the options the user can search by
        System.out.println("Enter the number of Categories you would like to search for");
        input = keyboard.nextInt();
        keyboard.nextLine();
        keyboard.next();
        ArrayList<Person> personFound = new ArrayList<Person>();  // Establish a list of all Suspects found
        
        for(int i=0; i<input;i++){  // loop over the number of parameters the user wants to search for
            System.out.println("Keyword:" + (i+1) + " ");
            sInput = keyboard.nextLine();  // capture what the User would like to search for first
            keyboard.next();
            sInput.toLowerCase();
            if(sInput.equals("name")){  // If the user wants to search by name
                System.out.println("Enter name");
                sInput = keyboard.nextLine();
                keyboard.next();
                personFound.addAll(Database.getFirst(sInput));  // if the suspect exists in the database, add it to the list
            }
            else if(sInput.equals("age")){  // if the user wants to search by age
                System.out.println("Enter age");
                input1 = keyboard.nextInt();  // capture the age to look for
                keyboard.nextLine();
                keyboard.next();
                personFound.addAll(Database.getAge(input1));  // if suspects with that age exist in the database, add it to the list
            }
            else if(sInput.equals("height")){  // if the user wants to search by height
                System.out.println("Enter height");
                inputD = keyboard.nextDouble();  // capture the height
                keyboard.nextLine();
                keyboard.next();
                personFound.addAll(Database.getHeight(inputD));  // if suspects with that height exist, add them to the list
            }
            else if(sInput.equals("weight")){  // if the user wants to search by weight
                System.out.println("Enter weight");
                inputD = keyboard.nextDouble();  // capture the weight
                keyboard.nextDouble();
                personFound.addAll(Database.getWeight(inputD));  // if suspects with that weight exist, add them to the list
            }
            else if(sInput.equals("gender")){  // if the user wants to search by gender
                System.out.println("Enter gender");
                sInput = keyboard.nextLine();  // capture the gender
                keyboard.next();
                personFound.addAll(Database.getGender(sInput));  // if suspects with that gender exist, add them to the list
            }
            /*
            Could not get this to work
            
            else if(sInput.equals("crime")){
                System.out.println("Enter crime");
                sInput = keyboard.nextLine();
                personFound.addAll(Database.getCrime(sInput));
            }
            */
            else if(sInput.equals("tattoo")){  // if the user wants to search by tattoo description
                System.out.println("Enter tattoo description");
                sInput = keyboard.nextLine();
                keyboard.next();
                personFound.addAll(Database.getTattooDescription(sInput));  // if a suspect with that tattoo exists, add them to the list (this description has to be EXACT though)
            }
            else if(sInput.equals("hair color")){  // if the user wantes to search by hair color
                System.out.println("Enter hair color");
                sInput = keyboard.nextLine();  // capture the color of hair
                keyboard.next();
                personFound.addAll(Database.getHairColor(sInput));  // add all suspects with that hair color to the list
            }
        }
        /*
        We unfortunantley did not have time to come back and finsih this method. I know it needs to return, but dont have time to implement it.
    }

    /*
    Main Menu Options
    */
    private void displayMainMenu() {
        System.out.println("\n************ Main Menu *************");
        for(int i=0; i< mainMenu.length; i++) {  // loop over the array to display all options
            System.out.println((i+1) + ". " + mainMenu[i]);  // display the option at the current index
        }
        System.out.println("\n");
    }

    /*
    Search Suspect Options
    */
    private void displaySearchChoices() {
        System.out.println("************ Search By ************");
        for(int i=0; i < searchBy.length; i++) {  // loop over the array with all the search options
            System.out.println((i+1) + ". " + searchBy[i]);  // display the option at the current index
        }
        System.out.println("\n***********************************");
    }

    /*
    Take in User input
    */
    private int getUserCommand(int numCommands) {
        System.out.println("What would you like to do? ");
        String input = keyboard.nextLine();  // capture the int entered by user
        
        int command = Integer.parseInt(input) - 1;

        if (command >= 0 && command <= numCommands - 1) {  // if the int is greater than 0 and less than the number of possible options
            return command;  // return the int
        }
        return -1;  // return a -1 to flag for error in the play() method
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
        int num = keyboard.nextInt();
        keyboard.nextLine();
        return num;
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
