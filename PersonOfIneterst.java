public class PersonOfIneterst extends Person {
    public String gender;
    public String race;
    public String hairColor;
    public double height;
    public double weight;
    public boolean tattoo;
    public boolean criminalRecord;

    public PersonOfIneterst() {
        super();
        this.gender = "None";
        this.race = "None";
        this.hairColor = "None";
        this.height = 0.0;
        this.weight = 0.0;
        this.tattoo = false;
        this.criminalRecord = false;
    }

    public PersonOfIneterst(String gender, String race, String hairColor, double height, 
                            double weight, boolean tattoo, boolean criminalRecord) {
        super();
        this.gender = gender;
        this.race = race;
        this.hairColor = hairColor;
        this.height = height;
        this.weight = weight;
        this.tattoo = tattoo;
        this.criminalRecord = criminalRecord;
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
        return 0.0;
    }

    public double getWeight() {
        return 0.0;
    }

    public boolean hasTattoo() {
        return false;
    }

    public boolean hasCriminalRecord() {
        return false;
    }
}

