import java.util.ArrayList;

public class Box implements Packable {

    private double maxCapacity;
    private ArrayList<Packable> items = new ArrayList<>();

    public Box(double maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public double weight() {
        double weight = 0;
        for (Packable item : items) {
            weight += item.weight();
        }
        return weight;
    }

    public void add(Packable item) {
        if(weight() + item.weight() <= maxCapacity) {
            items.add(item);
        }
    }

    public String toString() {
        return "Box: " + items.size() + " items, total weight " + weight() + " kg";
    }
}
