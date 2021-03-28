import java.util.ArrayList;

public class Crimes {
    private static Crimes crimes = null;
    private static ArrayList<Crime> crimeList;

    private Crimes() {
        crimeList = DataLoader.loadCrime();
    }

    public static Crimes getInstance() {
        if (crimes == null) {
            crimes = new Crimes();
        }
        return crimes;
    }

    public ArrayList<Crime> getCrimes() {
        return crimeList;
    }

    public boolean addCrime(String type, boolean felony) {
        for (Crime crime : crimeList) {
            if (crime.getType().equals(type) && crime.isFelony() == felony) {
                return true;
            }
        }
        return false;
    }

    public void saveCrimes() {
        DataWriter.saveCrimes();
    }



}
