package lt.techin;

import lt.itakademija.exam.*;

public class MyCurrencyConverter implements CurrencyConverter {

    private CurrencyRatesProvider currencyRatesProvider;

    public MyCurrencyConverter(CurrencyRatesProvider currencyRatesProvider) {
        this.currencyRatesProvider = currencyRatesProvider;
    }

    @Override
    public Money convert(Currency from, Currency to, Money amount) {

        if(currencyRatesProvider.getRate(from, to) == null) {
            throw new CurrencyConversionException("Unable to convert currency");
        }

        Money convertedAmount = amount.multiply(currencyRatesProvider.getRate(from, to));

        return convertedAmount;
    }
}
