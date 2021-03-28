public class Person {
    public String name;
    public String address;
    public int dob;
    public int age;
    public String description;
    public double height;
    public double weight;

    public Person() {
        this.name = "None";
        this.address = "None";
        this.dob = 00000000;
        this.age = 0;
        this.description = "None";
        this.height = 0;
        this.weight = 0;
    }


    public Person(String name, String address, int dob, int age, String description) {
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.age = age;
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

    public int getAge() {
        return this.age;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return "Name: " + this.name + " Address: " + this.address + " DOB: " + this.dob + " Description: " + this.description;
    }


    public double getHeight() {
        return this.height;
    }


    public double getWeight() {
        return this.weight;
    }


    
}
