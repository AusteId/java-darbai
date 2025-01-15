import java.util.HashMap;

public class IOU {

    private HashMap<String, Double> IOU = new HashMap<>();

    public IOU() {
    }

    public void setSum(String toWhom, double amount) {
        IOU.put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom) {
        for (String whom : IOU.keySet()) {
            if (whom.contains(toWhom)) {
                return IOU.get(whom);
            }
        }
        return 0;
    }
}
