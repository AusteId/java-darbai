package lt.techin;

import itadesign.beerdrinker.BeerBottle;
import itadesign.beerdrinker.BeerConsumer;
import itadesign.beerdrinker.DefaultBeerBottle;

public class SomeKindOfConsumer extends BeerConsumer {
    @Override
    protected boolean shouldConsumeBeer(BeerBottle beerBottle) {

        if(beerBottle.getVolumeInLiters() <= 0.5 && beerBottle.getAlcoholContentInPercent() <= 6 &&  getBloodAlcoholContentInLiters() < .120) {
            return true;
        }
        return false;
    }

    @Override
    public BeerBottle showBeerBottleToAStranger(BeerBottle beerBottle, boolean b) {

        if(b) {
            return new BeerBottleAdapter(beerBottle);
        }
        return beerBottle;
    }
}
