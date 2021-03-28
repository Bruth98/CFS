import java.util.Scanner;

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
        boolean correct = false;
        do {
            displayMainMenu();
            int userCommand = getUserCommand(mainMenu.length);
            if (userCommand == -1) {
                System.out.println("Not a valid choice. Try again.");
            }
            if (userCommand > 0 && userCommand < mainMenu.length ) {
                correct = true;
                if (userCommand == (mainMenu.length - 1)) {
                    cfs.logout();
                }
            }
        } while (!correct)


        while (true) {
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
        }
    

        System.out.println("Current Users");
   
        System.out.println("***** Users Online *****");
        displayUsers();
    }

    /*
    Create Account
    */
    private void createAccount() {
        int userID = getFieldInt("userID");
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
    }

    /*
    Get all Cases
    */
    private void getCases() {
        System.out.println("Searching Cases");
        int caseID = getCaseID();
        if (caseID == 0) { 
            return;
        }
        /*
        !! This method is not finished !!
        */
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
        ArrayList<Person> personFound = new ArrayList<Person>();
        
        for(int i=0; i<input;i++){
            System.out.println("Keyword:" + (i+1) + " ");
            sInput = keyboard.nextLine();
            sInput.toLowerCase();
            if(sInput.equals("name")){
                System.out.println("Enter name");
                sInput = keyboard.nextLine();
                personFound.addAll(Database.getFirst(sInput));
            }
            else if(sInput.equals("age")){
                System.out.println("Enter age");
                input1 = keyboard.nextInt();
                keyboard.nextLine();
                personFound.addAll(Database.getAge(input1));
            }
            else if(sInput.equals("height")){
                System.out.println("Enter height");
                inputD = keyboard.nextDouble();
                keyboard.nextLine();
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
                personFound.addAll(Database.getGender(sInput));
            }
            else if(sInput.equals("crime")){
                System.out.println("Enter crime");
                sInput = keyboard.nextLine();
                personFound.addAll(Database.getCrime(sInput));
            }
            else if(sInput.equals("tattoo")){
                System.out.println("Enter tattoo description");
                sInput = keyboard.nextLine();
                personFound.addAll(Database.getTattooDescription(sInput));
            }
            else if(sInput.equals("hair color")){
                System.out.println("Enter hair color");
                sInput = keyboard.nextLine();
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
        return keyboard.next();
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