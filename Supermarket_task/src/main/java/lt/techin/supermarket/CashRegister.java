package lt.techin.supermarket;

import java.util.HashMap;
import java.util.Map;

public class CashRegister {

    private Map<Double, Integer> cash = new HashMap<>();

    public Map<Double, Integer> getCash() {
        return cash;
    }
}
