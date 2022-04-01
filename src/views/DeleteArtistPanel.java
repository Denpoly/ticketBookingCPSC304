package views;

import utils.MySQLConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteArtistPanel extends JFrame {

    //Components
    JButton b22 = new JButton("Delete");
    JLabel l = new JLabel("Delete all performers with the selected stage name and their related events.");
    JComboBox<String> dropdown = new JComboBox<String>(MySQLConnection.getPerformerStageNames());
    JPanel p = new JPanel();

    public DeleteArtistPanel() {
        //listeners
        b22.addActionListener((ActionEvent e) -> {
            String stage_name = dropdown.getItemAt(dropdown.getSelectedIndex());
            MySQLConnection.deleteAPerformer(stage_name);
            System.out.println("Deleted the tuple for: " + stage_name);
            dropdown.removeItemAt(dropdown.getSelectedIndex());
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
