package lt.techin;

import java.util.ArrayList;

public class Swearwords {

    private static ArrayList<String> swearwords = new ArrayList<>();

    public Swearwords() {

    }

    public static ArrayList<String> getSwearwords() {
        swearwords.add("rupūs miltai");
        swearwords.add("velniai rautų");
        swearwords.add("velnias");
        swearwords.add("velniais");
        return swearwords;
    }

}
