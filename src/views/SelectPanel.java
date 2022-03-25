package views;

import com.sun.tools.jconsole.JConsoleContext;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.MySQLConnection;

public class SelectPanel extends JFrame {

    //Components
    JButton b22 = new JButton("search for events by artist");
    JTextField t = new JTextField(16);
    JLabel l = new JLabel("SELECTION QUERY: Enter an artist");
    JPanel p = new JPanel();

    public SelectPanel() {


        //listeners
        b22.addActionListener((ActionEvent e) -> {
            ResultSet results = MySQLConnection.selectEventsByArtists(t.getText());
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
        p.add(t);
        p.add(b22);

    }

    public JPanel getPanel() {
        return p;
    }
}