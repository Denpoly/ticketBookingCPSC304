package utils;

import java.sql.*;
public class MySQLConnection {
    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketbooking", "", "" );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConection()
    {

        return connection;


    }

    public static ResultSet selectEventsByArtists(String artist) {
        String query = "SELECT * from event E, performs P1, performer P2 WHERE E.eid = P1.eid AND P1.pid = P2.pid and P2.stage_name = ?";


        Statement st = null;
        try {
            st = connection.createStatement();
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, artist);
            ResultSet rs = stmt.executeQuery();
            return rs;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
