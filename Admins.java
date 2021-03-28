import java.util.ArrayList;
public class Admins {
    private static Admins admins = null;
    private static ArrayList<Admin> adminList; 
    private Admins(){
        adminList = DataLoader.loadAdmins();
    }

    public static Admins getInstance(){
        if(admins == null){
            admins = new Admins();
        }
        return admins;
    }

    public ArrayList<Admin> getAdmins(){
        return adminList;
    }

    public boolean addAdmin(String firstName, String lastName, String department, int employeeID){
        for(Admin admin : adminList){
            if(admin.getFirstName().equals(firstName) && admin.getLastName().equals(lastName) && admin.getDepartment().equals(department) && admin.getEmployeeID() == employeeID){
                return true;
            }
        }
        return false;
    }

    public void saveAdmins(){
        DataWriter.savePersons();
    }
}
