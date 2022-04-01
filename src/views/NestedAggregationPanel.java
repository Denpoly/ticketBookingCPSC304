package views;

import utils.MySQLConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NestedAggregationPanel {
    //Components
    JButton b22 = new JButton("Find");
    JLabel l1 = new JLabel("Find the most money each user has spent on tickets at venues with selected amenity options.");
    JLabel l2 = new JLabel("(Nested aggregation)");
    JPanel p = new JPanel();
    JCheckBox hasAlcohol = new JCheckBox("Alcohol");
    JCheckBox isOutdoor = new JCheckBox("Outdoors");
    JCheckBox hasFood = new JCheckBox("Food");
    JPanel options = new JPanel();

    public NestedAggregationPanel(){
        options.setLayout(new GridLayout(1, 3));
        options.setMaximumSize(new Dimension(300, 30));

        b22.addActionListener((ActionEvent e) -> {
            ResultSet results = MySQLConnection.nestedAggregationQuery(hasAlcohol.isSelected(), hasFood.isSelected(), isOutdoor.isSelected());
            System.out.println("Customers:");
            try {
                while (results.next()) {
                    String username = results.getString("username");
                    String maxCost = results.getString("MAX(PO.total_cost)");
                    System.out.format("%s, $%s\n", username, maxCost);
                }
                System.out.print("\n");
            } catch (SQLException err) {
                err.printStackTrace();
            }
        });
        options.add(hasAlcohol);
        options.add(hasFood);
        options.add(isOutdoor);

        p.add(l1);
        p.add(l2);
        p.add(Box.createRigidArea(new Dimension(0, 15)));
        p.add(options);
        p.add(Box.createRigidArea(new Dimension(0, 15)));
        p.add(b22);

        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        l1.setAlignmentX(Component.CENTER_ALIGNMENT);
        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
        options.setAlignmentX(Component.CENTER_ALIGNMENT);
        b22.setAlignmentX(Component.CENTER_ALIGNMENT);

    }
    public JPanel getPanel() {
        return p;
    }
}
