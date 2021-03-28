import java.util.ArrayList;
public class PersonOfInterest extends Person {
    public String gender;
    public String race;
    public String hairColor;
    public double height;
    public double weight;
    public String tattoo;
    public boolean criminalRecord;
    public int age;

    public PersonOfInterest() {
        super();
        this.gender = "None";
        this.race = "None";
        this.hairColor = "None";
        this.height = 0.0;
        this.weight = 0.0;
        this.tattoo = "None";
        this.criminalRecord = false;
        this.age = 0;
    }

    public PersonOfInterest(Person person, String gender, String race, String hairColor, double height, 
                            double weight, String tattooDescription, boolean criminalRecord, int age) {
        super();
        this.gender = gender;
        this.race = race;
        this.hairColor = hairColor;
        this.height = height;
        this.weight = weight;
        this.tattoo = tattooDescription;
        this.criminalRecord = criminalRecord;
        this.age = age;
    }

    public PersonOfInterest(String name, String address, int dob, int age2, String description, String gender2,
            String race2, String hairColor2, double height2, double weight2, String tattooDescription,
            boolean criminalRecord2) {
                super();
                this.gender = gender2;
                this.race = race2;
                this.hairColor = hairColor2;
                this.height = height2;
                this.weight = weight2;
                this.tattoo = tattooDescription;
                this.criminalRecord = criminalRecord2;
                this.age = age;
    }

    public String getGender() {
        return this.gender;
    }
    
    public String getRace() {
        return this.race;
    }

    public String getHairColor() {
        return this.hairColor;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWeight() {
        return this.weight;
    }

    public String getTattooDescription() {
        return this.tattoo;
    }

    public boolean getCriminalRecord() {
        return this.criminalRecord;
    }
}

