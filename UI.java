import java.util.Scanner;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
public class UI {
    private String[] mainMenu = {"Create Account", "Login", "Get Cases", "Get Suspects", "Get Witnesses", "Get Victims"};
    Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        UI Ui = new UI();
        Ui.play();
    }

    public void play(){
        boolean loggedIn = false;
        Users users = Users.getInstance();
        System.out.println("****************************************");
        System.out.println("Welcome to Crime Fighter Software!");
        displayMainMenu();
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
    Create Account
    */
    public void createAccount() {
        int userID = getFieldInt("userID");
        String password = getField("password");

    }

    /*
    Login
    */
    public void login() {
        System.out.println("Please enter your User ID: ");
        int userID = keyboard.nextInt();

        System.out.println("Please enter your Password: ");
        String password = keyboard.next();

        System.out.println("****************************************");
        System.out.println(userID);
        System.out.println(password);
    
        /*
        Searching the list of Users for a matching userID and password. I can't 
        figure out why I can't use a for each loop here 
        */
        for (User user : users) {
            if (userID == user.getUserID() && password.equals(user.getPassword())) {
                loggedIn = true;
            }
        }
    }
    private String getField(String prompt) {

        System.out.print(prompt + ": ");
        return keyboard.next();
    }
    private int getFieldInt(String prompt) {

        System.out.print(prompt + ": ");
        return keyboard.nextInt();
    }
    private boolean addUser() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Would you like to add a User? (Y or N):");

        String input = keyboard.next();
        if(input.toLowerCase().trim().equals("y")) return true;
        return false;
    }
    public void displayUsers(){
        Users user2 = Users.getInstance(); // ask
        ArrayList<User> users = user2.getUsers();
    }
}
