package lt.techin.supermarket;

import lt.techin.supermarket.exceptions.NotEnoughChangeException;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CashRegister {

    public static final double CENTS_10 = 0.1;
    public static final double CENTS_50 = 0.5;
    public static final double EUROS_1 = 1.0;
    public static final double EUROS_2 = 2.0;

    private Map<Double, Integer> cash = new TreeMap<>(Comparator.reverseOrder());

    public Map<Double, Integer> getCash() {
        return cash;
    }

    public void addCash(double denomination, int quantity) {
        cash.put(denomination, quantity);
    }

    public void addAdditionalCoins(double denomination, int quantity) {
        cash.replace(denomination, cash.getOrDefault(denomination, 0) + quantity);
    }

    public void removeCoins(double denomination, int quantity) {

    }

    public int getQuantity(double denomination) {
        return cash.getOrDefault(denomination, 0);
    }

    public void giveReturnDenomination(double denomination, int neededAmount) {
        if (getQuantity(denomination) >= neededAmount) {
            cash.replace(denomination, cash.get(denomination) - neededAmount);
        }
    }

    public double countChange(double paid, double price) {
        return paid - price;
    }

    public Map<Double, Integer> giveChange(double amount) {

        Map<Double, Integer> change = new HashMap<>();

        int amountOfCoins = 0;

        for (Map.Entry<Double, Integer> entry : cash.entrySet()) {
            if (amount == 0) {
                break;
            }

            amountOfCoins = (int) (amount / entry.getKey());


            if (entry.getValue() - amountOfCoins >= 0) {
                cash.replace(entry.getKey(), entry.getValue() - amountOfCoins);
            } else {
                amountOfCoins = entry.getValue();
                cash.replace(entry.getKey(), 0);
            }
            if(amountOfCoins > 0) {
                change.put(entry.getKey(), amountOfCoins);
            }

            amount -= amountOfCoins * entry.getKey();
            amount = Math.round(amount * 100.0) / 100.0;

        }

        if (amount > 0) {
            throw new NotEnoughChangeException("Sufficient change cannot be provided " + amount);
        }

        return  change;
    }

    public void displayAllCashWithQuantity() {
        for (Map.Entry<Double, Integer> entry : cash.entrySet()) {
            System.out.println("Value: " + entry.getKey() + ", quantity: " + entry.getValue());
        }
    }
}



