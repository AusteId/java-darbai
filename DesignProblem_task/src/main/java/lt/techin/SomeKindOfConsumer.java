package lt.techin;

import itadesign.beerdrinker.BeerBottle;
import itadesign.beerdrinker.BeerConsumer;
import itadesign.beerdrinker.DefaultBeerBottle;

public class SomeKindOfConsumer extends BeerConsumer {
    @Override
    protected boolean shouldConsumeBeer(BeerBottle beerBottle) {

        if(beerBottle.getVolumeInLiters() > 0.5 || beerBottle.getAlcoholContentInPercent() > 6 ||  getBloodAlcoholContentInLiters() < 120) {
            return false;
        }
        return true;
    }

    @Override
    public BeerBottle showBeerBottleToAStranger(BeerBottle beerBottle, boolean b) {

        BeerBottle beerBottle1;

        if(b) {
            BeerBottle bottle = new DefaultBeerBottle(beerBottle.getVolumeInLiters(), 0);
//            bottle.takeASip(bottle.getVolumeInLiters());
            return bottle;
        }
        return beerBottle;
    }
}
