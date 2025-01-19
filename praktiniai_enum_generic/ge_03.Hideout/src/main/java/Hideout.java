import java.util.ArrayList;

public class Hideout<T> {

    private ArrayList<T> hideout = new ArrayList<>();

    public Hideout() {
    }

    public void putIntoHideout(T toHide) {
        if(hideout.isEmpty() || hideout.size() == 1) {
            hideout.clear();
            hideout.add(toHide);
        } else {
            hideout.remove(toHide);
        }
    }

    public T takeFromHideout() {
        if(hideout.isEmpty()) {
            return null;
        }
        T object = hideout.get(0);
        hideout.remove(object);
        return object;
    }

    public boolean isInHideout() {
        if(hideout.isEmpty()) {
            return false;
        }
        return true;
    }
}
