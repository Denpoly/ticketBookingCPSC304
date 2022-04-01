import views.*;

import java.awt.*;
import java.io.PrintStream;
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
        frame.setSize(1100,800);

        //Components
        JTabbedPane tabs = new JTabbedPane();

        JPanel performer = new JPanel();
        performer.setLayout(new BoxLayout(performer, BoxLayout.Y_AXIS));
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        JPanel appContainer = new JPanel();
        appContainer.setLayout(new BoxLayout(appContainer, BoxLayout.X_AXIS));

        JTextArea ta = new JTextArea();

        con =new PrintStream(new TextAreaOutputStream(ta));
        System.setOut( con );

        // Performer table panels
        UpdatePerformerPanel updateP = new UpdatePerformerPanel();
        SelectPanel selectP = new SelectPanel();
        DeleteArtistPanel deleteP = new DeleteArtistPanel();

        // Add performer table panels to the performer tab
        performer.add(updateP.getPanel());
        performer.add(Box.createRigidArea(new Dimension(0, 45)));
        performer.add(selectP.getPanel());
        performer.add(Box.createRigidArea(new Dimension(0, 45)));
        performer.add(deleteP.getPanel());

        // Event and Customer table panels
        ProjectionPanel projectP = new ProjectionPanel();
        JoinPanel joinP = new JoinPanel();
        NestedAggregationPanel naPanel = new NestedAggregationPanel();
        EventAverageAgePanel aggregationPanel = new EventAverageAgePanel();
        DivisionPanel divisionP = new DivisionPanel();

        // Add event and customer table panels to the event and customers tab
        main.add(projectP.getPanel());
        main.add(Box.createRigidArea(new Dimension(0, 45)));
        main.add(joinP.getPanel());
        main.add(Box.createRigidArea(new Dimension(0, 45)));
        main.add(naPanel.getPanel());
        main.add(Box.createRigidArea(new Dimension(0, 45)));
        main.add(aggregationPanel.getPanel());
        main.add(Box.createRigidArea(new Dimension(0, 45)));
        main.add(divisionP.getPanel());

        // Add panels to appropriate tabs
        tabs.add("Performers", performer);
        tabs.add("Events and Customers", main);

        appContainer.add(tabs);
        JScrollPane console = new JScrollPane(ta);
        console.setPreferredSize(new Dimension(400,400));
        appContainer.add(console);

        frame.add(appContainer);
        frame.setVisible(true);
    }
}
