import java.util.ArrayList;
import java.util.Scanner;
//uml done
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
    

    
}
