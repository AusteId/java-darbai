import java.util.ArrayList;

public class Herd implements  Movable {

    private ArrayList<Movable> objects = new ArrayList<>();

    @Override
    public void move(int dx, int dy) {
        for (Movable object : objects) {
            object.move(dx, dy);
        }
    }

    public String toString() {
        String s = "";

        for (Movable object : objects) {
          s += object.toString() + "\n";
        }
        return s;
    }

    public void addToHerd(Movable movable) {
        objects.add(movable);
    }
}
