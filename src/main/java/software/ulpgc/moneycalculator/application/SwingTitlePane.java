package software.ulpgc.moneycalculator.application;

import javax.swing.*;
import java.awt.*;

public class SwingTitlePane extends JPanel {

    public SwingTitlePane() {
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(addVerticalSpace(40));
        this.add(titleLabel());
        this.add(addVerticalSpace(80));
    }

    private static Component addVerticalSpace(int height) {
        return Box.createVerticalStrut(height);
    }

    private Component titleLabel() {
        JLabel titleLabel = new JLabel("Money Calculator");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return titleLabel;
    }
}
