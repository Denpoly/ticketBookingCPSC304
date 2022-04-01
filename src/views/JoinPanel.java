package views;

import utils.MySQLConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JoinPanel extends JFrame {
    //Components
    JButton b22 = new JButton("Search");
    JTextField t = new JTextField(16);
    JLabel l = new JLabel("Find all customers who have spent less than the specified amount in dollars (join).");
    JPanel p = new JPanel();

    public JoinPanel() {
        //listeners
        b22.addActionListener((ActionEvent e) -> {
            ResultSet results = MySQLConnection.joinCustomerPurchaseOrder(t.getText());
            System.out.println("Customers:");
            try {
                while (results.next()) {
                    String total_cost = results.getString("total_cost");
                    String first_name = results.getString("first_name");
                    String last_name = results.getString("last_name");
                    String email = results.getString("email");
                    String eventTitle = results.getString("title");
                    System.out.format("%s, %s, %s, $%s, %s\n", first_name, last_name, email, total_cost, eventTitle);
                }
                System.out.print("\n");
            } catch (SQLException err) {
                err.printStackTrace();
            }
        });

        p.add(l);
        p.add(Box.createRigidArea(new Dimension(0, 15)));
        p.add(t);
        p.add(Box.createRigidArea(new Dimension(0, 15)));
        p.add(b22);

        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        t.setMaximumSize(new Dimension(300, 30));

        l.setAlignmentX(Component.CENTER_ALIGNMENT);
        t.setAlignmentX(Component.CENTER_ALIGNMENT);
        b22.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
    public JPanel getPanel() {
        return p;
    }
}
