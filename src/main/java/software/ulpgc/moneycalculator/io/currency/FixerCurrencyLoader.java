package software.ulpgc.moneycalculator.io.currency;

import software.ulpgc.moneycalculator.model.Currency;

import java.util.List;

public class FixerCurrencyLoader implements CurrencyLoader {
    private final CurrencyReader reader;
    private final CurrencyDeserializer deserializer;
    private final CurrencyAdapter adapter;

    public FixerCurrencyLoader(CurrencyReader reader, CurrencyDeserializer deserializer, CurrencyAdapter adapter) {
        this.reader = reader;
        this.deserializer = deserializer;
        this.adapter = adapter;
    }

    @Override
    public List<Currency> load() {
        return adapter.adapt(deserializer.deserialize(reader.read()));
    }
}