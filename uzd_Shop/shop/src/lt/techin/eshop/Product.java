package lt.techin.eshop;

public abstract class Product {
    private String title;
    private double priceNeto;


    public Product(String title, double priceNeto) {
        this.title = title;
        this.priceNeto = priceNeto;

    }

    public String getTitle() {
        return title;
    }

    public double getPriceNeto() {
        return priceNeto;
    }

    public double countBrutoInEuros() {
        return priceNeto + (priceNeto / 100 * getPvm());
    }

    public double countBrutoInFranks() {
        return countBrutoInEuros() * 0.9346;
    }

    public abstract double countBrutoInEuros2();

    public abstract double countBrutoInFranks2();

    public abstract double getPvm();
}
