import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        HashMap<String, Integer> books = new HashMap<>();
        ArrayList<Book> books = new ArrayList<>();


        while (true) {
            System.out.println("Input the name of the book, empty stops:");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println(books.size() + " books in total.");
                System.out.println("");
                System.out.println("Books:");
//                for (String i : books.keySet()) {
//                    System.out.println(i + " (recommended for " + books.get(i) + " year-olds or older)");
//                }
//                break;


//                books.sort((a, b) -> a.getAgeRecommended() - b.getAgeRecommended());
                books.sort(Comparator.comparing(Book::getAgeRecommended).thenComparing(Book::getTitle));
                for(Book book : books) {
                    System.out.println(book);
                }
                break;
            }
            System.out.println("Input the age recommendation:");
            int ageRecommended = Integer.parseInt(scanner.nextLine());
//            books.put(name, age);
            books.add(new Book(name, ageRecommended));
        }
    }
}
