import java.util.ArrayList;
public class Officers {
    private static Officers officers = null;
    private static ArrayList<Officer> officerList;
    private Officers(){
        officerList = DataLoader.loadOfficer();
    }

    public static Officers getInstance(){
        if(officers == null){
            officers = new Officers();
        }
        return officers;
    }

    public ArrayList<Officer> getOfficers(){
        return officerList;
    }

    public boolean addOfficer(String firstName, String lastName, String department){
        if(haveOfficer(firstName, lastName, department)){
            return false;
        }
        officerList.add(new Officer(firstName, lastName, department));
        return true;
    }

    public boolean haveOfficer(String firstName, String lastName, String department){
        for(Officer officer : officerList){
            if(officer.getFirstName().equals(firstName) && officer.getLastName().equals(lastName) && officer.getDepartment().equals(department)){
                return true;
            }
        }
        return true;
    }

    public void saveOfficer(){
        DataWriter.saveOfficers();
    }
}
