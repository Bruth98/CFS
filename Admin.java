
public class Admin extends Officer{
    
    public Admin(String firstName, String lastName, String department, int employeeID) {
        super();
    }
    
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getEmployeeID() {
        return this.employeeID;
    }
}