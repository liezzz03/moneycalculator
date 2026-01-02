package software.ulpgc.moneycalculator.application;

import software.ulpgc.moneycalculator.control.CalculateCommand;
import software.ulpgc.moneycalculator.io.currency.*;
import software.ulpgc.moneycalculator.io.exchangeRate.FixerExchangeRateDeserializer;
import software.ulpgc.moneycalculator.io.exchangeRate.FixerExchangeRateLoader;
import software.ulpgc.moneycalculator.io.exchangeRate.FixerExchangeRateReader;
import software.ulpgc.moneycalculator.model.Currency;

import java.util.List;

public class SwingMain {
    public static void main(String[] args) {
        CurrencyLoader loader = new FixerCurrencyLoader(new FixerCurrencyReader(), new FixerCurrencyDeserializer(), new FixerCurrencyAdapter());
        List<Currency> currencies = loader.load();
        MainFrame frame = new MainFrame(currencies);
        frame.put("Calculate", new CalculateCommand(
                frame.getCurrencyDialog(),
                frame.getMoneyDialog(),
                new FixerExchangeRateLoader(new FixerExchangeRateReader(), new FixerExchangeRateDeserializer()),
                frame.getMoneyDisplay()
        ));
        frame.setVisible(true);
    }
}