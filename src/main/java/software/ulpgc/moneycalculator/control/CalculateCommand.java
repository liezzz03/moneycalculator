package software.ulpgc.moneycalculator.control;

import software.ulpgc.moneycalculator.io.exchangeRate.ExchangeRateLoader;
import software.ulpgc.moneycalculator.model.Currency;
import software.ulpgc.moneycalculator.model.ExchangeRate;
import software.ulpgc.moneycalculator.model.Money;
import software.ulpgc.moneycalculator.ui.CurrencyDialog;
import software.ulpgc.moneycalculator.ui.MoneyDialog;
import software.ulpgc.moneycalculator.ui.MoneyDisplay;

public class CalculateCommand implements Command {
    private final CurrencyDialog currencyDialog;
    private final MoneyDialog moneyDialog;
    private final ExchangeRateLoader exchangeRateLoader;
    private final MoneyDisplay moneyDisplay;

    public CalculateCommand(CurrencyDialog currencyDialog, MoneyDialog moneyDialog, ExchangeRateLoader exchangeRateLoader, MoneyDisplay moneyDisplay) {
        this.currencyDialog = currencyDialog;
        this.moneyDialog = moneyDialog;
        this.exchangeRateLoader = exchangeRateLoader;
        this.moneyDisplay = moneyDisplay;
    }

    @Override
    public void execute() {
        Money money = moneyDialog.get();
        Currency currencyTo = currencyDialog.get();
        ExchangeRate exchangeRate = exchangeRateLoader.load(money.currency(), currencyTo);
        Money conversion = new Money(money.amount() * exchangeRate.rate(), currencyTo);

        moneyDisplay.show(conversion);
    }
}
