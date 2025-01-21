package lt.techin.supermarket;

public enum Coin {

    EUROS_2(2.0), EUROS_1(1.0), CENTS_50(0.5), CENTS_10(0.1);

    private final double value;

    Coin(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public static boolean isValid(double input) {
        for (Coin coin : Coin.values()) {
            if(coin.getValue() == input) {
                return true;
            }
        }
        return false;
    }
}
