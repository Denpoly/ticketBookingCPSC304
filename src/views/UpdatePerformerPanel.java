package views;

import models.Performer;
import utils.MySQLConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class UpdatePerformerPanel extends JFrame {

    JPanel mainPanel = new JPanel();
    JPanel fieldPanel = new JPanel();

    //Components
    JLabel title = new JLabel("Insert a new performer or update an existing tuple.");

    // Text field labels
    JLabel lPid = new JLabel("Performer ID:");
    JLabel lStageName = new JLabel("Stage Name:");
    JLabel lIndustry = new JLabel("Industry:");
    JLabel lEmail = new JLabel("Email:");
    JLabel lMobileNumber = new JLabel("Mobile #:");
    JLabel lPostalCode = new JLabel("Postal Code:");

    // Text fields
    JTextField tPid = new JTextField(16);
    JTextField tStageName = new JTextField(16);
    JTextField tIndustry = new JTextField(16);
    JTextField tEmail = new JTextField(16);
    JTextField tMobileNumber = new JTextField(16);
    JTextField tPostalCode = new JTextField(16);

    JLabel info_text1 = new JLabel("A new tuple will be added to the performer table if " +
            "the specified pid does not exist.");
    JLabel info_text2 = new JLabel("Otherwise, the existing tuple will be updated.");

    JButton button = new JButton("Update Table");

    public UpdatePerformerPanel() {
        //listeners
        button.addActionListener((ActionEvent e) -> {
            Performer p = new Performer(tStageName.getText(), tPid.getText(), tIndustry.getText(),
                    tEmail.getText(), tMobileNumber.getText(), tPostalCode.getText());
            Set<String> existing_pids = MySQLConnection.getPerformerIDs();

            if (existing_pids.contains(tPid.getText())) {
                String return_value = MySQLConnection.updateAPerformer(p);
                System.out.println("Successfully updated tuple for: " + return_value);
            } else {
                Boolean success = MySQLConnection.createAPerformer(p);
                System.out.println("Successfully inserted tuple for: " + tStageName.getText());
            }
        });

        fieldPanel.add(lPid);
        fieldPanel.add(lStageName);
        fieldPanel.add(lIndustry);

        fieldPanel.add(tPid);
        fieldPanel.add(tStageName);
        fieldPanel.add(tIndustry);

        fieldPanel.add(lEmail);
        fieldPanel.add(lMobileNumber);
        fieldPanel.add(lPostalCode);

        fieldPanel.add(tEmail);
        fieldPanel.add(tMobileNumber);
        fieldPanel.add(tPostalCode);

        fieldPanel.setMaximumSize(new Dimension(600, 120));
        fieldPanel.setLayout(new GridLayout(4, 3));

        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        mainPanel.add(info_text1);
        mainPanel.add(info_text2);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        mainPanel.add(fieldPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        mainPanel.add(button);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        fieldPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        info_text1.setAlignmentX(Component.CENTER_ALIGNMENT);
        info_text2.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public JPanel getPanel() {
        return mainPanel;
    }
}
