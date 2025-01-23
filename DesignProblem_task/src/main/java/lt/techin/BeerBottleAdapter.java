package lt.techin;

import itadesign.beerdrinker.BeerBottle;

public class BeerBottleAdapter implements BeerBottle {

    private BeerBottle wrappedBottle;

    public BeerBottleAdapter(BeerBottle wrappedBottle) {
        this.wrappedBottle = wrappedBottle;
    }

    @Override
    public double getAlcoholContentInPercent() {
        return 0;
    }

    @Override
    public double getVolumeInLiters() {
        return wrappedBottle.getVolumeInLiters();
    }

    @Override
    public void takeASip(double v) {
        wrappedBottle.takeASip(v);
    }
}
