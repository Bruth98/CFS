import java.util.Scanner;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
public class UI {
    private String[] mainMenu = {"Create Account", "Login", "Get Cases", "Add Case", "Get Suspects", "Add Suspect", "Get Witnesses", "Add Witness", "Get Victims", "Add Victims", "Log Out"};
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
        displayMainMenu();
        int userCommand = getUserCommand(mainMenu.length);

        if (userCommand == -1) {
            System.out.println("Not a valid choice.");
            continue;
        }
        
        if (userCommand == (mainMenu.length - 1) {
            cfs.logout();
            break;
        }

        while (true) {
            System.out.println("What do you want to do?");
            int choice = keyboard.nextInt();
            switch (choice) {
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
                case(5):  // Add a Suspect to a Case
                    addSuspects();  // needs to be added
                    break;
                case(6):  // Get all Witnesses (
                    getWitnesses();
                    break;
                case(7):  // Add a Witness to a Case
                    addWitness();  // needs to be added
                    break;
                case(8):  // Get all Victims (we're gonna
                    getVictims();
                    break;
                case(9):  // Add a Victim to a Case
                    addVictims();  // needs to be added
                    break;
            }

        System.out.println("Current Users");
   
        System.out.println("***** Users Online *****");
        displayUsers();
        }
        /*
        while(addUser()) {
            int userID = getFieldInt("employeeID");
            String password = getField("password");

            Users.addUser(userID, password); // Ask about this
        }

        System.out.println("***** Your updated list of Users *****")
        displayUsers();

        System.out.println("\nHave a good day!")
        */
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
