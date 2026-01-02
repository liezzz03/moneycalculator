package software.ulpgc.moneycalculator.io.currency;

import software.ulpgc.moneycalculator.model.Currency;
import software.ulpgc.moneycalculator.pojos.CurrencySymbolsGetResponse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class FixerCurrencyAdapter implements CurrencyAdapter {
    @Override
    public List<Currency> adapt(Object object) {
        return adapt((CurrencySymbolsGetResponse) object);
    }

    public List<Currency> adapt(CurrencySymbolsGetResponse response) {
        List<Currency> currencies = new ArrayList<>();
        for (Map.Entry<String, String> entry : response.symbols().entrySet()) {
            currencies.add(new Currency(entry.getKey(), entry.getValue()));
        }
        currencies.sort(Comparator.comparing(Currency::country));
        return currencies;
    }
}