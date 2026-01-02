package software.ulpgc.moneycalculator.application;

import software.ulpgc.moneycalculator.model.Money;
import software.ulpgc.moneycalculator.ui.MoneyDialog;

import javax.swing.*;
import java.awt.*;

public class SwingMoneyDialog extends JPanel implements MoneyDialog {
    private final JTextField amountField;
    private final SwingCurrencyDialog currencyDialog;

    public SwingMoneyDialog(SwingCurrencyDialog currencyDialog) {
        this.add(this.amountField = amountField());
        this.add(this.currencyDialog = currencyDialog);
        this.setBackground(Color.DARK_GRAY);
    }

    private JTextField amountField() {
        JTextField amountField = new JTextField(10);
        amountField.setFont(new Font("arial", Font.PLAIN, 12)); // TODO numeric filter
        return amountField;
    }

    @Override
    public Money get() {
        String amountText = amountField.getText();
        if (amountText.isEmpty()) throw new IllegalArgumentException("AmountField cannot be empty");
        return new Money(stringToDouble(amountText), currencyDialog.get());
    }

    private double stringToDouble(String string) {
        return Double.parseDouble(string);
    }
}