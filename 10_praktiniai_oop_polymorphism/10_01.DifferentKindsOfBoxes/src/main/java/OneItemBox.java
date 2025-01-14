import java.util.ArrayList;

public class OneItemBox extends Box {

    private ArrayList<Item> itemOneInBox = new ArrayList<>();

    public OneItemBox(){

    }

    @Override
    public void add(Item item) {
        if(itemOneInBox.size() == 0) {
            itemOneInBox.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return itemOneInBox.contains(item);
    }
}
