package software.ulpgc.moneycalculator.application;

import software.ulpgc.moneycalculator.control.Command;
import software.ulpgc.moneycalculator.control.ExchangeMoneyCommand;
import software.ulpgc.moneycalculator.io.currency.*;
import software.ulpgc.moneycalculator.io.exchangeRate.ExchangeRateLoader;
import software.ulpgc.moneycalculator.io.exchangeRate.FixerExchangeRateDeserializer;
import software.ulpgc.moneycalculator.io.exchangeRate.FixerExchangeRateLoader;
import software.ulpgc.moneycalculator.io.exchangeRate.FixerExchangeRateReader;
import software.ulpgc.moneycalculator.model.Currency;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CurrencyLoader loader = new FixerCurrencyLoader(
                new FixerCurrencyReader(),
                new FixerCurrencyDeserializer(),
                new FixerCurrencyAdapter()
        );
        List<Currency> currencies = loader.load();
        MainFrame mainFrame = new MainFrame(currencies);
        ExchangeRateLoader exchangeRateLoader = new FixerExchangeRateLoader(
                new FixerExchangeRateReader(),
                new FixerExchangeRateDeserializer()
        );
        Command exchangeCommand = new ExchangeMoneyCommand(
                mainFrame.getMoneyDialog(),
                mainFrame.getCurrencyDialog(),
                exchangeRateLoader,
                mainFrame.getMoneyDisplay()
        );
        mainFrame.put("Calculate", exchangeCommand);
        mainFrame.setVisible(true);
    }
}