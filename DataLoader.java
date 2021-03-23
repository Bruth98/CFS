import java.util.ArrayList;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser; //Ask about this error
public class DataLoader extends DataConstants {
    public ArrayList<Person> loadPersons(){
        ArrayList<Person> persons = new ArrayList<Person>();
        try{
            FileReader reader = new FileReader(PERSON_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray personJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i<personJSON.size(); i++){
                JSONObject personJSON = (JSONObject)personJSON.get(i);
                String name =(String)personJSON.get(PERSON_NAME);
                String address = (String)personJSON.get(PERSON_ADDRESS);
                int dob =(int)personJSON.get(PERSON_DOB);
                String description = (String)personJSON.get(PERSON_DESCRIPTION);

                persons.add(new Person(name, address, dob, description));
            }
            return persons;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<User> loadUsers(){
        ArrayList<User> users = new ArrayList<User>();
        try{
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray userJSON =(JSONArray)new JSONParser().parse(reader);

            for(int i =0; i< userJSON.size();i++){
                JSONObject userJSON = (JSONObject)userJSON.get(i);
                int employeeID = 00000000;
                String password = "password";
                
                users.add(new User(employeeID, password));
            }
            return users;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Admin> loadAdmins(){
        ArrayList<Admin> admins = new ArrayList<Admin>();
        try{
            FileReader reader = new FileReader(ADMIN_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray adminJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i = 0; i<adminJSON.size(); i++){
                JSONObject adminJSON = (JSONObject)adminJSON.get(i);
                String firstName = "first name";
                String lastName = "last name";

                admins.add(new Admin(firstName, lastName));
            }
            return admins;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Agent> loadAgent(){
        
    }
}
