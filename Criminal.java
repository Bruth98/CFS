public class Criminal extends Suspect{
    public boolean inJail;
    public boolean felony;
    public int numCrimes;

    public Criminal() {
        super();
    }

    public Criminal(boolean inJail, boolean felony, int numCrimes) {
        super();
    }

    public boolean isInJail(){
        return false;
    }

    public boolean commitFelony() {
        return false;
    }

    public int crimesCommitted() {
        return 0;
    }

    public void setCriminalRecord() {
        PersonOfIneterst.hasCriminalRecord = true;
    }


    
}
