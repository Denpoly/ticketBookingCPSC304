package views;

import models.Performer;
import utils.MySQLConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CreatePerformerPanel extends JFrame {

    //Components
    JButton b22 = new JButton("Insert a new Artist");

    JTextField tStageName = new JTextField(16);
    JLabel lStageName = new JLabel("Enter a stage name");
    JTextField tPid = new JTextField(16);
    JLabel lPid = new JLabel("Enter a PID");
    JTextField tIndustry = new JTextField(16);
    JLabel lIndustry = new JLabel("Enter an Industry");
    JTextField tEmail = new JTextField(16);
    JLabel lEmail = new JLabel("Enter an email");
    JTextField tMobileNumber = new JTextField(16);
    JLabel lMobileNumber = new JLabel("Enter a mobile number");
    JTextField tPostalCode = new JTextField(16);
    JLabel lPostalCode = new JLabel("enter a postal code");

    JLabel[] labels = {lStageName, lPid, lIndustry, lEmail, lMobileNumber, lPostalCode};
    JTextField[] textField = {tStageName,tPid,tIndustry, tEmail, tMobileNumber, tPostalCode};

    JLabel title = new JLabel("INSERT QUERY: insert a new performer");

    JPanel p1 = new JPanel();

    JPanel p2 = new JPanel();
    JPanel container = new JPanel();

    ArrayList<JPanel> inputs = new ArrayList<>();

    public CreatePerformerPanel() {
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
        //listeners
        b22.addActionListener((ActionEvent e) -> {
            Performer p = new Performer(tStageName.getText(), tPid.getText(), tIndustry.getText(), tEmail.getText(),
                                        tMobileNumber.getText(), tPostalCode.getText());
            Boolean success = MySQLConnection.createAPerformer(p);
            System.out.println(success);
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
