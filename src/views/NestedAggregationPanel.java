package views;

import utils.MySQLConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

// SELECT C.username, MAX(PO.total_cost), E.title FROM customer C, purchase_order PO, ticket T, event E WHERE T.eid = E.eid AND PO.oid = T.oid AND C.username = PO.username GROUP BY C.username
public class NestedAggregationPanel {
    //Components
    JButton b22 = new JButton("run query");
    JLabel l = new JLabel("NESTED AGGREGRATION QUERY: Find the most money each user has spent on an order:");
    JPanel p = new JPanel();

    public NestedAggregationPanel(){
        b22.addActionListener((ActionEvent e) -> {
            ResultSet results = MySQLConnection.nestedAggregationQuery();
            try {
                while (results.next()) {
                    String username = results.getString("username");
                    String maxCost = results.getString("MAX(PO.total_cost)");
                    System.out.format("%s, %s\n", username, maxCost);
                }
                System.out.print("\n");
            } catch (SQLException err) {
                err.printStackTrace();
            }
        });
        p.add(l);
        p.add(b22);
    }
    public JPanel getPanel() {
        return p;
    }
}
