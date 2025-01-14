package lt.techin.eshop;

public class Wine extends Alcohol {
    private final double TAX_UP_TO_8_5_PERCENTAGE = 0.28;
    private final double TAX_MORE_THEN_8_5_PERCENTAGE = 0.72;

    public Wine(String title, double priceNeto, double volume, double liters) {
        super(title, priceNeto, volume, liters);
    }

    @Override
    public double countBrutoInEuros2() {
        double priceWithPvm = getPriceNeto() + (getPriceNeto() / 100 * getPVM());
        if(getVolume() <= 8.5) {
            priceWithPvm += getLiters() * TAX_UP_TO_8_5_PERCENTAGE;
        } else {
            priceWithPvm += getLiters() * TAX_MORE_THEN_8_5_PERCENTAGE;
        }
        return priceWithPvm;
    }

    @Override
    public double countBrutoInFranks2() {
        return countBrutoInEuros2() * getSwissFrancExchangeRate();
    }


}
