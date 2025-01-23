package lt.techin;

import java.util.ArrayList;

public class Swearwords {

    private static ArrayList<String> swearwords = new ArrayList<>();

    public Swearwords() {
        swearwords.add("rupūs miltai");
        swearwords.add("velniai rautų");
        swearwords.add("velnias");
        swearwords.add("velniais");
    }

    public ArrayList<String> getSwearwords() {
        return swearwords;
    }

}
