import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Hand implements Comparable<Hand> {

    private ArrayList<Card> cards = new ArrayList<>();

    public void add(Card card) {
        cards.add(card);
    }

    public void print() {
        cards.forEach(System.out::println);
    }

    public void sort() {
        Collections.sort(cards);
    }

    public int getSum() {
        return cards.stream().map(a -> a.getValue()).reduce(0, (a, b) -> a + b);
    }

    @Override
    public int compareTo(Hand other) {
        return Integer.compare(getSum(), other.getSum());
    }

    public void sortBySuit() {
        Collections.sort(cards, new BySuitInValueOrder());
    }
}
