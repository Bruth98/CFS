import java.util.Scanner;
import java.util.ArrayList;
public class UI {
    public static void main(String[] args) {
        UI Ui = new UI();
        Ui.play();
    }
public void play(){
    Scanner keyboard = new Scanner(System.in);
    boolean loggedIn = false;
    System.out.println("****************************************");
    System.out.println("Welcome to Crime Fighter Software!");
    System.out.println("Please enter your User ID: ");
    int userID = keyboard.nextInt();

    System.out.println("Please enter your Password: ");
    String password = keyboard.next();

    System.out.println("****************************************");
    System.out.println(userID);
    System.out.println(password);
   User user =  User.getInstance();
   System.out.println("Current Users");
   
    System.out.println("***** Users Online *****");
    displayUsers();

    while(addUser()) {
        int employeeID = getFieldInt("employeeID");
        String password = getField("password");

        User.addUser(employeeID, password);
    }

    System.out.println("***** Your updated list of Users *****")
    displayUsers();

    System.out.println("\nHave a good day!")
}
private String getField(String prompt) {
    Scanner keyboard = new Scanner(System.in);
    System.out.print(prompt + ": ");
    return keyboard.next();
}
private int getFieldInt(String prompt) {
    Scanner keyboard = new Scanner(System.in);
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
    User user2 = User.getInstance();
    ArrayList<User> users = user2.getUser();
}
    }
