import java.util.Scanner;
public class UI {
    public static void main(String[] args) {
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
    }
    
}
