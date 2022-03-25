package utils;

import models.Performer;

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

    public static Boolean createAPerformer(Performer p) {
        String query = "INSERT INTO performer VALUES (?, ?, ?, ?, ?, ?)";


        Statement st = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, p.getMstage_name());
            stmt.setString(2, p.getMpid());
            stmt.setString(3, p.getMindustry());
            stmt.setString(4, p.getMemail());
            stmt.setString(5, p.getMmobile_number());
            stmt.setString(6, p.getMpostal_code());

            Boolean b = stmt.execute();
            return b;

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public static Boolean deleteAPerformer(String name){
        String query = "DELETE FROM performer WHERE stage_name = ?";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, name);
            Boolean b = stmt.execute();
            return b;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public static ResultSet projectEventsByOptions(Boolean hasFood, Boolean hasAlcohol, Boolean isOutdoors){
        String query = "SELECT e.title, v.name FROM event e, hostedAt h, venue v WHERE e.eid = h.eid AND h.vid = v.vid AND v.has_alcohol = ? AND v.has_food = ? AND v.is_outdoor = ?";
        PreparedStatement stmt = null;

        try{
            stmt = connection.prepareStatement(query);
            stmt.setString(1, booleanToString(hasAlcohol));
            stmt.setString(2, booleanToString(hasFood));
            stmt.setString(3, booleanToString(isOutdoors));

            ResultSet rs = stmt.executeQuery();
            return rs;
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return null;

    }

    private static String booleanToString(boolean b){
        return b? "1" : "0";
    }

}
