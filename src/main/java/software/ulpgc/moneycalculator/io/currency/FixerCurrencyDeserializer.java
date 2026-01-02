package software.ulpgc.moneycalculator.io.currency;

import com.google.gson.Gson;
import software.ulpgc.moneycalculator.pojos.CurrencySymbolsGetResponse;

public class FixerCurrencyDeserializer implements CurrencyDeserializer {
    @Override
    public CurrencySymbolsGetResponse deserialize(String read) {
        return new Gson().fromJson(read, CurrencySymbolsGetResponse.class);
    }
}
