package test;

import Factory.Country;
import Factory.Currency;
import Factory.CurrencyFactory;

public class CurrencyFactoryTest {
    public static void main(String[] args) {
        Currency currency = CurrencyFactory.newCurrency(Country.BRAZIL);
        System.out.println(currency.getSymbol());
    }
}
