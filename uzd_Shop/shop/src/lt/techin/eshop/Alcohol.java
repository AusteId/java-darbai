package lt.techin.eshop;

public abstract class Alcohol extends Product {
    private final double PVM = 21;
    private double volume;

    public Alcohol(String title, double priceNeto, double pvm, double volume) {
        super(title, priceNeto);
        this.volume = volume;
    }

    @Override
    public abstract double countBrutoInEuros2();

    @Override
    public abstract double countBrutoInFranks2();


}
