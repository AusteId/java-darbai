public class Book {//implements Comparable<Book> {

    private String title;
    private int ageRecommended;

    public Book(String title, int ageRecommended) {
        this.title = title;
        this.ageRecommended = ageRecommended;
    }

    public String getTitle() {
        return title;
    }

    public int getAgeRecommended() {
        return ageRecommended;
    }

//    @Override
//    public int compareTo(Book book) {
//        return ageRecommended - book.getAgeRecommended();
//    }



    @Override
    public String toString() {
        return title + " (recommended for " + ageRecommended + " year-olds or older)";
    }
}
