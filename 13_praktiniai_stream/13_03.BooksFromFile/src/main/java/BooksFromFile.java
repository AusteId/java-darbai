
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.nio.file.Path.of;

public class BooksFromFile {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here

    }

    public static List<Book> readBooks(String file) throws IOException {
        return Files.lines(of(file)).map(a -> a.split(","))
                .map(a -> new Book(a[0], Integer.parseInt(a[1]), Integer.parseInt(a[2]),
                        a[3])).collect(Collectors.toList());

    }

}
