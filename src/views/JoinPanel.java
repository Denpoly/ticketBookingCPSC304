package views;

import utils.MySQLConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JoinPanel extends JFrame {
    //Components
    JButton b22 = new JButton("query customers");
    JTextField t = new JTextField(16);
    JLabel l = new JLabel("JOIN QUERY: Enter a lower total_cost limit");
    JPanel p = new JPanel();

    public JoinPanel() {
        //listeners
        b22.addActionListener((ActionEvent e) -> {
            ResultSet results = MySQLConnection.joinCustomerPurchaseOrder(t.getText());
            try {
                while (results.next()) {
                    String first_name = results.getString("first_name");
                    String last_name = results.getString("last_name");
                    String email = results.getString("email");
                    System.out.format("%s, %s, %s\n", first_name, last_name, email);
                }
                System.out.print("\n");
            } catch (SQLException err) {
                err.printStackTrace();
            }
        });
        p.add(l);
        p.add(t);
        p.add(b22);
    }
    public JPanel getPanel() {
        return p;
    }
}
