package views;

import utils.MySQLConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteArtistPanel extends JFrame {

    //Components
    JButton b22 = new JButton("Delete artist and its events");
    JTextField t = new JTextField(16);
    JLabel l = new JLabel("DELETION QUERY: Enter an artist");
    JPanel p = new JPanel();

    public DeleteArtistPanel() {


        //listeners
        b22.addActionListener((ActionEvent e) -> {
            Boolean result = MySQLConnection.deleteAPerformer(t.getText());
            System.out.println(result);
        });

        p.add(l);
        p.add(t);
        p.add(b22);

    }

    public JPanel getPanel() {
        return p;
    }
}
