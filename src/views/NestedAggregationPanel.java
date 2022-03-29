package views;

import utils.MySQLConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NestedAggregationPanel {
    //Components
    JButton b22 = new JButton("run query");
    JLabel l = new JLabel("NESTED AGGREGRATION QUERY: Find the most money each user has spent on orders at venues with various amenity options:");
    JPanel p = new JPanel();
    JCheckBox hasAlcohol = new JCheckBox("Alcohol");
    JCheckBox isOutdoor = new JCheckBox("Outdoors");
    JCheckBox hasFood = new JCheckBox("Food");
    JPanel options = new JPanel();

    public NestedAggregationPanel(){
        b22.addActionListener((ActionEvent e) -> {
            ResultSet results = MySQLConnection.nestedAggregationQuery(hasAlcohol.isSelected(), hasFood.isSelected(), isOutdoor.isSelected());
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
        options.add(hasAlcohol);
        options.add(hasFood);
        options.add(isOutdoor);
        p.add(l);
        p.add(options);
        p.add(b22);

    }
    public JPanel getPanel() {
        return p;
    }
}
