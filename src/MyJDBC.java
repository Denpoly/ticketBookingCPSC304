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
        frame.setSize(1400,800);

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

        SelectPanel selectP = new SelectPanel();
        CreatePerformerPanel createP = new CreatePerformerPanel();
        DeleteArtistPanel deleteP = new DeleteArtistPanel();
        ProjectionPanel projectP = new ProjectionPanel();
        JoinPanel joinP = new JoinPanel();
        NestedAggregationPanel naPanel = new NestedAggregationPanel();
        UpdatePerformerPanel updateP = new UpdatePerformerPanel();
        EventAverageAgePanel aggregationPanel = new EventAverageAgePanel();
        DivisionPanel divisionP = new DivisionPanel();

        //Adding components to main panel
        performer.add(selectP.getPanel());
        performer.add(createP.getPanel());
        performer.add(deleteP.getPanel());
        performer.add(updateP.getPanel());
        //performer.add(new JScrollPane(ta));

        main.add(projectP.getPanel());
        main.add(joinP.getPanel());
        main.add(naPanel.getPanel());
        main.add(aggregationPanel.getPanel());
        tabs.add("Performers", performer);
        tabs.add("Other", main);
        tabs.add("Division", divisionP.getPanel());
        //tabs.setPreferredSize(new Dimension(1000, 800));
        appContainer.add(tabs);
        JScrollPane console = new JScrollPane(ta);
        console.setPreferredSize(new Dimension(1000,400));
        appContainer.add(console);

        frame.add(appContainer);
        frame.setVisible(true);
    }
}
