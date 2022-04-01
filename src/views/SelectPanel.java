package views;

import com.sun.tools.jconsole.JConsoleContext;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.MySQLConnection;

public class SelectPanel extends JFrame {

    //Components
    JButton b22 = new JButton("Search");
    JLabel l = new JLabel("Find all events where the selected performer appeared.");
    JComboBox<String> dropdown = new JComboBox<String>(MySQLConnection.getPerformerStageNames());
    JPanel p = new JPanel();

    public SelectPanel() {


        //listeners
        b22.addActionListener((ActionEvent e) -> {
            String name = dropdown.getItemAt(dropdown.getSelectedIndex());
            ResultSet results = MySQLConnection.selectEventsByArtists(name);
            System.out.format("Found events:\n");
            try {
                while (results.next()) {
                    String stage_name = results.getString("stage_name");
                    String event_title = results.getString("title");
                    String date = results.getString("startTime");
                    System.out.format("%s, %s, %s\n", stage_name, event_title, date);
                }
                System.out.print("\n");
            } catch (SQLException err) {
                err.printStackTrace();
            }
        });

        p.add(l);
        p.add(Box.createRigidArea(new Dimension(0, 15)));
        p.add(dropdown);
        p.add(Box.createRigidArea(new Dimension(0, 15)));
        p.add(b22);

        dropdown.setMaximumSize(new Dimension(200, 30));

        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        l.setAlignmentX(Component.CENTER_ALIGNMENT);
        dropdown.setAlignmentX(Component.CENTER_ALIGNMENT);
        b22.setAlignmentX(Component.CENTER_ALIGNMENT);

    }

    public JPanel getPanel() {
        return p;
    }
}