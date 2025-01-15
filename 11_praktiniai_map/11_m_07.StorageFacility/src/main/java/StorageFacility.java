import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {

    private HashMap<String, ArrayList<String>> storage = new HashMap<>();

    public void add(String unit, String item) {
        storage.putIfAbsent(unit, new ArrayList<>());
        ArrayList<String> items = storage.get(unit);
        items.add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        return storage.getOrDefault(storageUnit, new ArrayList<>());
    }

    public void remove(String storageUnit, String item) {
        if(storage.containsKey(storageUnit)) {
            storage.get(storageUnit).remove(item);
            if(storage.get(storageUnit).isEmpty()) {
                storage.remove(storageUnit);
            }
        }
    }

    public ArrayList<String> storageUnits() {
        ArrayList<String> items = new ArrayList<>();
        for (String unit : storage.keySet()) {
            if(!storage.get(unit).isEmpty()) {
                items.add(unit);
            }
        }
        return items;
    }
}
