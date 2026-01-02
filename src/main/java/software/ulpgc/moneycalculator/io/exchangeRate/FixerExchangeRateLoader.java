package software.ulpgc.moneycalculator.io.exchangeRate;

import software.ulpgc.moneycalculator.model.Currency;
import software.ulpgc.moneycalculator.model.ExchangeRate;

import java.time.LocalDate;
import java.util.Map;

public class FixerExchangeRateLoader implements ExchangeRateLoader {
    private final ExchangeRateReader reader;
    private final ExchangeRateDeserializer deserializer;

    private static final String BASE_CURRENCY = "EUR";

    public FixerExchangeRateLoader(ExchangeRateReader reader, ExchangeRateDeserializer deserializer) {
        this.reader = reader;
        this.deserializer = deserializer;
    }

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        Map<String, Double> rates = (deserializer.deserialize(reader.read())).rates();
        LocalDate date = null;
        if (from.code().equals(BASE_CURRENCY)) {
            return new ExchangeRate(date, from, to, rates.get(to.code()));
        } else if (to.code().equals(BASE_CURRENCY)) {
            return new ExchangeRate(date, from, to, 1 / rates.get(from.code()));
        } else {
            return new ExchangeRate(date, from, to, calculateRate(from, to, rates));
        }
    }

    private static double calculateRate(Currency from, Currency to, Map<String, Double> rates) {
        double rateFromToBase = 1 / rates.get(from.code());
        double rateBaseToTarget = rates.get(to.code());
        return rateFromToBase * rateBaseToTarget;
    }
}