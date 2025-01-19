import java.util.ArrayList;

public class Pipe<T> {

    private ArrayList<T> pipe = new ArrayList<>();

    public Pipe() {
    }

    public void putIntoPipe(T value) {
        pipe.add(value);
    }

    public T takeFromPipe() {
        if(pipe.isEmpty()) {
            return null;
        }
        T longest = pipe.get(0);
        pipe.remove(longest);
        return longest;
    }

    public boolean isInPipe() {
        if(pipe.isEmpty()) {
            return false;
        }
        return true;
    }
}
