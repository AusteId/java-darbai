package lt.techin.eshop;

public abstract class Alcohol extends Product {
    private final double PVM = 21;
    private double volume;
    private double liters;

    public Alcohol(String title, double priceNeto, double volume, double liters) {
        super(title, priceNeto);
        this.volume = volume;
        this.liters = liters;
    }

    public double getPVM() {
        return PVM;
    }

    public double getVolume() {
        return volume;
    }

    public double getLiters() {
        return liters;
    }

    @Override
    public abstract double countBrutoInEuros2();

    @Override
    public abstract double countBrutoInFranks2();


}
