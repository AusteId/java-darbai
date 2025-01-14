package lt.techin.eshop;

public class SimpleProduct extends Product {
    private final double PVM = 21;

    public SimpleProduct(String title, double priceNeto) {
        super(title, priceNeto);
    }

    @Override
    public double countBrutoInEuros2() {
        return getPriceNeto() + (getPriceNeto() / 100 * PVM);
    }

    @Override
    public double countBrutoInFranks2() {
        return countBrutoInEuros2() * getSwissFrancExchangeRate();
    }

//    @Override
//    public double getPvm() {
//        return PVM;
//    }
}
