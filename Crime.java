/*
This is the Crime class, it holds the type of Crime, and a boolean to determine whether or not it is a felony.
Very simple class.
*/
public class Crime {
    public String type;
    public boolean felony;

    public Crime(String type, boolean felony){
        this.type = type;
        this.felony = felony;
    }
    public String getType(){
        return this.type;
    }

    public boolean isFelony(){
        return this.felony;
    }

    public String toString() {
        return "Type of Crime: " +this.type+"\nFelony: "+this.felony;
    }
}
