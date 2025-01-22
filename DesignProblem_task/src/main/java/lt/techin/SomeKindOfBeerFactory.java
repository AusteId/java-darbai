package lt.techin;

import itadesign.beerdrinker.BeerFactory;
import itadesign.beerdrinker.DefaultBeerBottle;
import itadesign.beerdrinker.NoMoreMaltException;

import java.util.ArrayList;

public class SomeKindOfBeerFactory implements BeerFactory {

    private int reserve = 1000;

    @Override
    public void receiveMaltShippment(double v) {
        if(v > 0) {
            reserve += (int) (v * 1000);
        }
    }

    @Override
    public DefaultBeerBottle produceNextBeerBottle() throws NoMoreMaltException {

        DefaultBeerBottle bottle = null;
        if(reserve >= 25) {
            bottle = new DefaultBeerBottle(0.5, 4.7);
            reserve -= 25;
        } else {
            throw new NoMoreMaltException("No more malt available");
        }
        return bottle;
    }
}
