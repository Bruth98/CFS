import java.util.Scanner;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
public class UI {
    private String[] mainMenu = {"Create Account", "Login", "Get Cases", "Get Suspects", "Get Witnesses", "Get Victims"};
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
                case(0):
                    createAccount();
                    break;
                case(1):
                    login();
                    break;
                case(2):
                    getCases();
                    break;
                case(3):
                    getSuspects();
                    break;
                case(4):
                    getWitnesses();
                    break;
                case(5):
                    getVictims();
                    break;
            }

        System.out.println("Current Users");
   
        System.out.println("***** Users Online *****");
        displayUsers();

        while(addUser()) {
            int userID = getFieldInt("employeeID");
            String password = getField("password");

            Users.addUser(userID, password); // Ask about this
        }

        System.out.println("***** Your updated list of Users *****")
        displayUsers();

        System.out.println("\nHave a good day!")
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
    public void createAccount() {
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
    public void login() {
        int userID = getFieldInt("User ID");
        String password = getField("Password");
        if (cfs.login(userID, password)) {
            loggedIn = true;
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

    public void displayUsers(){
        Users user2 = Users.getInstance(); // ask
        ArrayList<User> users = user2.getUsers();
    }
}
