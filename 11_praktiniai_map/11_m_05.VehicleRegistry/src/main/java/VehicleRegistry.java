import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {

    private HashMap<LicensePlate, String> hashMap = new HashMap<>();

    public boolean add(LicensePlate licensePlate, String owner) {

            if(hashMap.get(licensePlate) == null) {
                hashMap.put(licensePlate, owner);
                return true;
            }
            return false;
    }

    public String get(LicensePlate licensePlate) {
        if(hashMap.get(licensePlate) != null) {
            return hashMap.get(licensePlate);
        }
        return null;
    }

    public boolean remove(LicensePlate licensePlate) {
        if(hashMap.containsKey(licensePlate)) {
            hashMap.remove(licensePlate);
            return true;
        }
        return false;
    }

    public void printLicensePlates() {
        for (LicensePlate plates : hashMap.keySet()) {
            System.out.println(plates);
        }
    }

    public void printOwners() {
        ArrayList<String> uniqueOwners = new ArrayList<>();
        for(String owner : hashMap.values()) {
            if(!uniqueOwners.contains(owner)) {
                uniqueOwners.add(owner);
            }
        }
        for (String uniqueOwner : uniqueOwners) {
            System.out.println(uniqueOwner);
        }
    }
}
