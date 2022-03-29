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
        NestedAggregationPanel naPanel = new NestedAggregationPanel();

        //Adding components to main panel
        main.add(selectP.getPanel());
        main.add(createP.getPanel());
        main.add(deleteP.getPanel());
        main.add(projectP.getPanel());
        main.add(joinP.getPanel());
        main.add(naPanel.getPanel());
        main.add( new JScrollPane( ta )  );


        frame.getContentPane().add(main);
        frame.setVisible(true);

    }
}
