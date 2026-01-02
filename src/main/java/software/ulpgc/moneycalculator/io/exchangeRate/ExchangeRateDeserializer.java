package software.ulpgc.moneycalculator.io.exchangeRate;

import software.ulpgc.moneycalculator.pojos.ExchangeRatesGetResponse;

public interface ExchangeRateDeserializer {
    ExchangeRatesGetResponse deserialize(String read);
}