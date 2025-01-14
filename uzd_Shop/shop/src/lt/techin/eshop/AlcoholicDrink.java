package lt.techin.eshop;

public class AlcoholicDrink extends Alcohol {
    private final double TAX_UP_TO_15_PERCENTAGE = 0.89;
    private final double TAX_MORE_THEN_15_PERCENTAGE = 1.26;

    public AlcoholicDrink(String title, double priceNeto, double volume, double liters) {
        super(title, priceNeto, volume, liters);
    }

    @Override
    public double countBrutoInEuros2() {
        double priceWithPvm = getPriceNeto() + (getPriceNeto() / 100 * getPVM());
        if(getVolume() <= 15) {
            priceWithPvm += getLiters() * TAX_UP_TO_15_PERCENTAGE;
        } else {
            priceWithPvm += getLiters() * TAX_MORE_THEN_15_PERCENTAGE;
        }
        return priceWithPvm;
    }

    @Override
    public double countBrutoInFranks2() {
        return countBrutoInEuros2() * getSwissFrancExchangeRate();
    }
}
