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
    JLabel label = new JLabel("Find all customers that have bought tickets for all Ariana Grande events.");
    JLabel label2 = new JLabel("(Division)");
    JButton button = new JButton("Find Customers");

    public DivisionPanel() {
        button.addActionListener((ActionEvent e) -> {
            ResultSet customers = MySQLConnection.customerDivisionQuery();
            String first, last;
            System.out.println("Customers:");
            try {
                while (customers.next()) {

                    first = customers.getString("first_name");
                    last = customers.getString("last_name");
                    System.out.println(first + " " + last);

                }
                System.out.print("\n");
            } catch (SQLException err) {
                err.printStackTrace();
            }
        });

        panel.add(label);
        panel.add(label2);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(button);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public JPanel getPanel() {
        return panel;
    }
}