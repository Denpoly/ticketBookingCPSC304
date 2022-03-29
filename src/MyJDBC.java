import views.*;

import java.io.PrintStream;
import java.sql.*;
import javax.swing.*;

public class MyJDBC {
    static JButton b, b1, b2;
    static JLabel l;
    static JTextField t;
    static PrintStream con;
    public static void main(String[] args){


        //FRAME
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,800);

        //Components
        JTabbedPane tabs = new JTabbedPane();

        JPanel performer = new JPanel();
        performer.setLayout(new BoxLayout(performer, BoxLayout.Y_AXIS));
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        JTextArea ta = new JTextArea();

        con =new PrintStream(new TextAreaOutputStream(ta));
        System.setOut( con );

        SelectPanel selectP = new SelectPanel();
        CreatePerformerPanel createP = new CreatePerformerPanel();
        DeleteArtistPanel deleteP = new DeleteArtistPanel();
        ProjectionPanel projectP = new ProjectionPanel();
        JoinPanel joinP = new JoinPanel();
        UpdatePerformerPanel updateP = new UpdatePerformerPanel();
        EventAverageAgePanel aggregationPanel = new EventAverageAgePanel();

        //Adding components to main panel
        performer.add(selectP.getPanel());
        performer.add(createP.getPanel());
        performer.add(deleteP.getPanel());
        performer.add(updateP.getPanel());
        performer.add(new JScrollPane(ta));

        main.add(projectP.getPanel());
        main.add(joinP.getPanel());
        main.add(aggregationPanel.getPanel());
        main.add( new JScrollPane( ta )  );

        tabs.add("Performers", performer);
        tabs.add("Other", main);

        frame.add(tabs);
        frame.setVisible(true);
    }
}
