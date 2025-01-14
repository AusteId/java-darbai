package lt.techin.eshop;

import java.util.Objects;

public abstract class Product {
    private String title;
    private double priceNeto;
    private double swissFrancExchangeRate = 0.9346;


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

    public double getSwissFrancExchangeRate() {
        return swissFrancExchangeRate;
    }

    //    public double countBrutoInEuros() {
//        return priceNeto + (priceNeto / 100 * getPvm());
//    }
//
//    public double countBrutoInFranks() {
//        return countBrutoInEuros() * swissFrancExchangeRate;
//    }

    public abstract double countBrutoInEuros2();

    public abstract double countBrutoInFranks2();

//    public abstract double getPvm();


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }
}
