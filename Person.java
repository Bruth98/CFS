public class Person {
    public String name;
    public String address;
    public int dob;
    public String description;

    public Person() {
        this.name = "None";
        this.address = "None";
        this.dob = 00000000;
        this.description = "None";
    }


    public Person(String name, String address, int dob, String description) {
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public int getDOB() {
        return this.dob;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return "Name: " + this.name + " Address: " + this.address + " DOB: " + this.dob + " Description: " + this.description;
    }
}
