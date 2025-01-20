package lt.techin.supermarket;

public class Cash {

    private final double CENTS_10 = 0.1;
    private final double CENTS_50 = 0.5;
    private final double EUROS_1 = 1.0;
    private final double EUROS_2 = 2.0;
    private int quantity10cents = 0;
    private int quantity50cents = 0;
    private int quantity1euro = 0;
    private int quantity2euros = 0;

    public int getQuantity10cents() {
        return quantity10cents;
    }

    public void setQuantity10cents(int quantity10cents) {
        this.quantity10cents = quantity10cents;
    }

    public int getQuantity50cents() {
        return quantity50cents;
    }

    public void setQuantity50cents(int quantity50cents) {
        this.quantity50cents = quantity50cents;
    }

    public int getQuantity1euro() {
        return quantity1euro;
    }

    public void setQuantity1euro(int quantity1euro) {
        this.quantity1euro = quantity1euro;
    }

    public int getQuantity2euros() {
        return quantity2euros;
    }

    public void setQuantity2euros(int quantity2euros) {
        this.quantity2euros = quantity2euros;
    }

    public double getCENTS_10() {
        return CENTS_10;
    }

    public double getCENTS_50() {
        return CENTS_50;
    }

    public double getEUROS_1() {
        return EUROS_1;
    }

    public double getEUROS_2() {
        return EUROS_2;
    }

    @Override
    public String toString() {
        return "Value: " + CENTS_10 + ", quantity: " + quantity10cents + "\n" +
                ", CENTS_50=" + CENTS_50 +
                ", EUROS_1=" + EUROS_1 +
                ", EUROS_2=" + EUROS_2 +
                ", quantity10cents=" + quantity10cents +
                ", quantity50cents=" + quantity50cents +
                ", quantity1euro=" + quantity1euro +
                ", quantity2euros=" + quantity2euros +
                '}';
    }
}
