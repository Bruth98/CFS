import java.util.ArrayList;
import java.util.Scanner;
public class Officer extends User{
    protected String firstName;
    protected String lastName;
    protected String department;
    public Officer() {
        super();
        this.firstName = "None";
        this.lastName = "None";
        this.department = "None";
    }
    
    public Officer(String firstName, String lastName, String department) {
        super();
        this.firstName= firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public int getEmployeeID() {
        return this.employeeID;
    }

    public String getDepartment(){
        return this.department;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void displaySearchByKeyword(){
        Scanner keyboard = new Scanner(System.in);
        int input = 0;
        String sInput;
        int input1;
        double inputD;
        ArrayList<String> personID = new ArrayList<String>();
        System.out.println("Enter the number of keyword you would like to search for");
        input = keyboard.nextInt();
        keyboard.nextLine();
        ArrayList<Person> personFound = new ArrayList<Person>();

        for(int i=0; i<input;i++){
            System.out.println("Keyword:" + (i+1) + " ");
            sInput = keyboard.nextLine();
            sInput.toLowerCase();
            if(sInput.equals("first name")){
                System.out.println("Enter first name");
                sInput = keyboard.nextLine();
                personFound.addAll(Database.getFirst(sInput));
            }
            else if(sInput.equals("last name")){
                System.out.println("Enter last name");
                sInput = keyboard.nextLine();
                personFound.addAll(Database.getLast(sInput));
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
}
