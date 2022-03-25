package views;

import utils.MySQLConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectionPanel extends JFrame {

    //Components
    JButton b22 = new JButton("search for events by amenities");
    JCheckBox hasAlcohol = new JCheckBox("Alcohol");
    JCheckBox isOutdoor = new JCheckBox("Outdoors");
    JCheckBox hasFood = new JCheckBox("Food");
    JPanel options = new JPanel();

    JLabel l = new JLabel("PROJECTION QUERY: Select Options");
    JPanel p = new JPanel();

    public ProjectionPanel() {
        options.setLayout(new BoxLayout(options, BoxLayout.Y_AXIS));

        //listeners
        b22.addActionListener((ActionEvent e) -> {

            ResultSet results = MySQLConnection.projectEventsByOptions(hasAlcohol.isSelected(), hasFood.isSelected(), isOutdoor.isSelected());
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
        p.add(options);
        p.add(b22);

    }

    public JPanel getPanel() {
        return p;
    }
}
