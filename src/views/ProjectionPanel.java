package views;

import utils.MySQLConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectionPanel extends JFrame {

    //Components
    JButton b22 = new JButton("Search");
    JCheckBox hasAlcohol = new JCheckBox("Alcohol");
    JCheckBox isOutdoor = new JCheckBox("Outdoors");
    JCheckBox hasFood = new JCheckBox("Food");
    JPanel options = new JPanel();

    JLabel l = new JLabel("Find event names by amenities (projection).");
    JPanel p = new JPanel();

    public ProjectionPanel() {
        options.setLayout(new GridLayout(1, 3));
        options.setMaximumSize(new Dimension(300, 30));

        //listeners
        b22.addActionListener((ActionEvent e) -> {

            ResultSet results = MySQLConnection.projectEventsByOptions(hasAlcohol.isSelected(), hasFood.isSelected(), isOutdoor.isSelected());
            System.out.println("Events:");
            try {
                while (results.next()) {
                    String event_name = results.getString("name");
                    String event_title = results.getString("title");
                    System.out.format("%s, %s\n", event_name, event_title);
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
        p.add(Box.createRigidArea(new Dimension(0, 15)));
        p.add(options);
        p.add(Box.createRigidArea(new Dimension(0, 15)));
        p.add(b22);

        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        l.setAlignmentX(Component.CENTER_ALIGNMENT);
        options.setAlignmentX(Component.CENTER_ALIGNMENT);
        b22.setAlignmentX(Component.CENTER_ALIGNMENT);

    }

    public JPanel getPanel() {
        return p;
    }
}
