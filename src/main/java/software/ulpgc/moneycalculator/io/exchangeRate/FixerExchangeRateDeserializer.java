package software.ulpgc.moneycalculator.io.exchangeRate;

import com.google.gson.Gson;
import software.ulpgc.moneycalculator.pojos.ExchangeRatesGetResponse;

public class FixerExchangeRateDeserializer implements ExchangeRateDeserializer {
    @Override
    public ExchangeRatesGetResponse deserialize(String read) {
        return new Gson().fromJson(read, ExchangeRatesGetResponse.class);
    }
}