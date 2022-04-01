package views;

import utils.MySQLConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventAverageAgePanel extends JFrame {

    //Components
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Find the average age of all customers who bought tickets for the selected event below.");
    JLabel label2 = new JLabel("(Aggregation)");
    JComboBox<String> dropdown = new JComboBox<String>(MySQLConnection.getEventTitles());
    JButton button = new JButton("Find");

    public EventAverageAgePanel() {

        //Listeners
        button.addActionListener((ActionEvent e) -> {
            String event_title = dropdown.getItemAt(dropdown.getSelectedIndex());
            Double average_age = MySQLConnection.getEventAverageAge(event_title);
            System.out.format("The average age of all the ticket holders at the selected event is: %s\n\n", average_age);
        });

        panel.add(label);
        panel.add(label2);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(dropdown);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(button);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        dropdown.setMaximumSize(new Dimension(300, 30));

        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        dropdown.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public JPanel getPanel() {
        return panel;
    }
}