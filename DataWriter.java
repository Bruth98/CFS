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
        
    }

    public void saveUsers(){
        
    }
}
