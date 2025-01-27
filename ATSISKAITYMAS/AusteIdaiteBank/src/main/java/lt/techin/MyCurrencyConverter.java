package lt.techin;

import lt.itakademija.exam.Currency;
import lt.itakademija.exam.CurrencyConverter;
import lt.itakademija.exam.CurrencyRatesProvider;
import lt.itakademija.exam.Money;

import java.util.HashMap;
import java.util.Map;

public class MyCurrencyConverter implements CurrencyConverter {

    private CurrencyRatesProvider currencyRatesProvider;

    public MyCurrencyConverter(CurrencyRatesProvider currencyRatesProvider) {
        this.currencyRatesProvider = currencyRatesProvider;
    }

    @Override
    public Money convert(Currency from, Currency to, Money amount) {

        Money convertedAmount = amount.multiply(currencyRatesProvider.getRate(from, to));
        return convertedAmount;
        
    }
}
