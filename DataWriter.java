import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class DataWriter extends DataConstants {
    public void savePersons(){
        Person person = Person.getInstance(); //need to make two different classes one being Person and the other being persons similar to Users
        ArrayList<Person> persons = person.getPersons();
        JSONArray jsonPerson = new JSONArray();

        for(int i=0; i< persons.size(); i++){
            jsonPerson.add(getPersons(JSON(persons.get(i))));
        }
        try(FileWriter file = new FileWriter(PERSON_FILE_NAME)){
            file.write(jsonPerson.toJSONString());
            file.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static JSONObject getPersonJSON(Person person){
        JSONObject personDetails = new JSONObject();
        personDetails.put(PERSON_NAME, person.getName());
        personDetails.put(PERSON_ADDRESS, person.getAddress());
        personDetails.put(PERSON_DESCRIPTION,person.getDescription());
        personDetails.put(PERSON_DOB, person.getDOB());

        return personDetails;
    }

    public static void saveUsers(){
        Users users = Users.getInstance();
        ArrayList<User> user = users.getUsers();
        
        JSONArray jsonUser = new JSONArray();
        
        for(int i=0; i< user.size(); i++){
            jsonUser.add(getUserJSON(user.get(i)));
        }
        try(FileWriter file = new FileWriter(USER_FILE_NAME)){
            file.write(jsonUser.toJSONString());
            file.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static JSONObject getUserJSON(User user){
        JSONObject userDetails = new JSONObject();
        userDetails.put(EMPLOYEE_PASSWORD, user.getPassword());
        userDetails.put(EMPLOYEE_ID, user.getUserID());

        return userDetails;
    }

    public static void saveAdmins(){
        Admins admins = Admins.getInstance();
        ArrayList<Admin> admin = admins.getAdmins();
        
    } 
    public static void main(String[] args){
        DataWriter.saveUsers();
    }
}
