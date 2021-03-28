public class Persons {
    private static Persons persons = null;
    private Persons(){

    }

    public Persons getInstance() {
        if(persons ==null){
            persons = new Persons();
        }
        return persons;
    }
}
