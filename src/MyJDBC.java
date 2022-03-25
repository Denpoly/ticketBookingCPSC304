import views.SelectPanel;
import views.TextAreaOutputStream;

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


        //Adding components to main panel
        main.add(selectP.getPanel());
        main.add( new JScrollPane( ta )  );
        frame.getContentPane().add(main);

        frame.setVisible(true);

    }
}
