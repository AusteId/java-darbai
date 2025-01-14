public class CD implements Packable {

    private String artist;
    private String name;
    private int publicationYear;
    private double weightOfAllCD = 0.1;

    public CD(String artist, String name, int publicationYear) {
        this.artist = artist;
        this.name = name;
        this.publicationYear = publicationYear;
    }

    @Override
    public double weight() {
        return weightOfAllCD;
    }

    @Override
    public String toString() {
        return artist + ": " + name + " (" + publicationYear + ")";
    }
}
