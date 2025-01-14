package lt.techin.eshop;

public class Medicine extends Product {
    private final double PVM = 9;

    public Medicine(String title, double priceNeto, double pvm) {
        super(title, priceNeto);
    }

    @Override
    public double countBrutoInEuros2() {
        return getPriceNeto() + (getPriceNeto() / 100 * PVM);
    }

    @Override
    public double countBrutoInFranks2() {
        return getPriceNeto() + (getPriceNeto() / 100 * PVM) * 0.9346;
    }

    @Override
    public double getPvm() {
        return PVM;
    }
}
