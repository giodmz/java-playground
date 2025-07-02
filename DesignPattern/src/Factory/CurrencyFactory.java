package Factory;

public class CurrencyFactory {
    public static Currency newCurrency(Country country) {
        return switch (country) {
            case USA -> new UsDollar();
            case BRAZIL -> new Real();
            default -> throw new IllegalArgumentException("No currency found");
        };
    }
}
