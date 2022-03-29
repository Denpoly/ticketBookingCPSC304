package views;

import models.Performer;
import utils.MySQLConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class UpdatePerformerPanel extends JFrame {

    //Components
    JButton b22 = new JButton("Update Performer with Specified pid");

    JTextField tPid = new JTextField(16);
    JLabel lPid = new JLabel("PID:");
    JTextField tStageName = new JTextField(16);
    JLabel lStageName = new JLabel("Stage Name:");
    JTextField tIndustry = new JTextField(16);
    JLabel lIndustry = new JLabel("Industry:");
    JTextField tEmail = new JTextField(16);
    JLabel lEmail = new JLabel("Email:");
    JTextField tMobileNumber = new JTextField(16);
    JLabel lMobileNumber = new JLabel("Mobile #:");
    JTextField tPostalCode = new JTextField(16);
    JLabel lPostalCode = new JLabel("Postal Code:");

    JLabel[] labels = {lPid, lStageName, lIndustry, lEmail, lMobileNumber, lPostalCode};
    JTextField[] textField = {tPid, tStageName, tIndustry, tEmail, tMobileNumber, tPostalCode};

    JLabel title = new JLabel("UPDATE QUERY: update an existing performer");

    JPanel p1 = new JPanel();

    JPanel p2 = new JPanel();
    JPanel container = new JPanel();

    ArrayList<JPanel> inputs = new ArrayList<>();

    public UpdatePerformerPanel() {
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
        //listeners
        b22.addActionListener((ActionEvent e) -> {
            Performer p = new Performer(tStageName.getText(), tPid.getText(), tIndustry.getText(), tEmail.getText(),
                                        tMobileNumber.getText(), tPostalCode.getText());
            String return_value = MySQLConnection.updateAPerformer(p);
            System.out.println("Updated tuple for: " + return_value);
        });
        container.add(title);
        for(int i = 0; i < labels.length; i++){
            JPanel temp = new JPanel();
            temp.add(labels[i]);
            temp.add(textField[i]);
            p1.add(temp);
        }

        container.add(b22);
        container.add(p1);

    }

    public JPanel getPanel() {
        return container;
    }
}
