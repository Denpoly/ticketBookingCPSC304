package views;

import utils.MySQLConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DivisionPanel extends JFrame {

    //Components
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Find all customers that have bought tickets for all Ariana Grande events:");
    JButton button = new JButton("Find Customers");
    JLabel out_label = new JLabel();

    public DivisionPanel() {
        button.addActionListener((ActionEvent e) -> {
            ResultSet customers = MySQLConnection.customerDivisionQuery();
            StringBuilder out = new StringBuilder("Customers: ");
            String first, last;
            try {
                while (customers.next()) {
                    first = customers.getString("first_name");
                    last = customers.getString("last_name");
                    out.append(first).append(" ").append(last).append(", ");
                }
            } catch (SQLException err) {
                err.printStackTrace();
            }
            out.delete(out.lastIndexOf(","), out.length());
            out_label.setText(out.toString());
        });

        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        panel.add(out_label);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        out_label.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public JPanel getPanel() {
        return panel;
    }
}