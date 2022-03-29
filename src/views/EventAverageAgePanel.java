package views;

import utils.MySQLConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventAverageAgePanel extends JFrame {

    //Components
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Select title event:");
    JComboBox<String> dropdown = new JComboBox<String>(MySQLConnection.getEventTitles());
    JButton button = new JButton("Find Average Age");

    public EventAverageAgePanel() {

        //Listeners
        button.addActionListener((ActionEvent e) -> {
            String event_title = dropdown.getItemAt(dropdown.getSelectedIndex());
            Double average_age = MySQLConnection.getEventAverageAge(event_title);
            System.out.format("The average age of all ticket holders at the '%s' event is: %s\n", event_title, average_age);
        });

        panel.add(label);
        panel.add(dropdown);
        panel.add(button);
    }

    public JPanel getPanel() {
        return panel;
    }
}