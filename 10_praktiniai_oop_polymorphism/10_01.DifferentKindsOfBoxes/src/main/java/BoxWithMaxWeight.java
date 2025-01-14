import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {

    private int maxCapacity;
    private ArrayList<Item> items = new ArrayList<>();

    public BoxWithMaxWeight(int capacity) {
        maxCapacity = capacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    @Override
    public void add(Item item) {
        int itemsWeight = 0;
        for (Item value : items) {
            itemsWeight += value.getWeight();
        }
        if(item.getWeight() + itemsWeight <= maxCapacity) {
            items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return items.contains(item);
    }
}
