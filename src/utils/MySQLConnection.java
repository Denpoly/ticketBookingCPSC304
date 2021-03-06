package utils;

import models.Performer;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MySQLConnection {
    private static Connection connection;

    private static String username = "";
    private static String password = "";

    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketbooking", username, password );
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

    public static String updateAPerformer(Performer p) {
        String query = "UPDATE performer SET stage_name = ?, industry = ?, email = ?, mobile_number = ?, postal_code = ? WHERE pid = ?";

        Statement st = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, p.getMstage_name());
            stmt.setString(2, p.getMindustry());
            stmt.setString(3, p.getMemail());
            stmt.setString(4, p.getMmobile_number());
            stmt.setString(5, p.getMpostal_code());
            stmt.setString(6, p.getMpid());

            stmt.execute();
            return p.getMstage_name();

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public static Set<String> getPerformerIDs() {
        String query = "SELECT DISTINCT pid FROM performer";
        Set<String> pids = new HashSet<>();

        try {
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(query);
            ResultSet pids_rs = stmt.executeQuery();
            while (pids_rs.next()) {
                pids.add(pids_rs.getString("pid"));
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return pids;
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
    /*
     * Query to get all first names, last names and emails
     * of all customers who have spent less than totalCost
     * on a single purchase order.
     */
    public static ResultSet joinCustomerPurchaseOrder(String totalCost){
        String query = "SELECT DISTINCT PO.total_cost, C.first_name, C.last_name, email, E.title FROM customer C, purchase_order PO, ticket T, event E WHERE T.eid = E.eid AND PO.oid = T.oid AND C.username = PO.username AND total_cost < ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, totalCost);
            rs = stmt.executeQuery();
        }  catch (SQLException err) {
            err.printStackTrace();
        }

        return rs;
    }

    public static ResultSet nestedAggregationQuery(Boolean hasFood, Boolean hasAlcohol, Boolean isOutdoors){
        String query = "select C.username, MAX(PO.total_cost) from venue V, customer C, purchase_order PO, ticket T where C.username = PO.username AND PO.oid = T.oid AND T.vid = V.vid AND V.has_alcohol = ? AND V.has_food = ? AND V.is_outdoor = ? GROUP BY C.username";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, booleanToString(hasAlcohol));
            stmt.setString(2, booleanToString(hasFood));
            stmt.setString(3, booleanToString(isOutdoors));
            rs = stmt.executeQuery();
        }  catch (SQLException err) {
            err.printStackTrace();
        }

        return rs;
    }

    public static String[] getEventTitles() {
        String query = "SELECT DISTINCT title FROM event";
        ArrayList<String> titles = new ArrayList<>();

        try {
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(query);
            ResultSet titles_rs = stmt.executeQuery();
            while (titles_rs.next()) {
                titles.add(titles_rs.getString("title"));
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return titles.toArray(new String[titles.size()]);
    }

    public static String[] getPerformerStageNames() {
        String query = "SELECT DISTINCT stage_name FROM performer";
        ArrayList<String> names = new ArrayList<>();

        try {
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(query);
            ResultSet names_rs = stmt.executeQuery();
            while (names_rs.next()) {
                names.add(names_rs.getString("stage_name"));
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return names.toArray(new String[names.size()]);
    }

    public static double getEventAverageAge(String event_title) {
        String query = "SELECT AVG(c.age) FROM event e, customer c, ticket t, purchase_order p WHERE t.oid = p.oid AND t.eid = e.eid AND p.username = c.username AND e.title = ?";
        Double average_age = 0.0;

        try {
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(query);
            stmt.setString(1, event_title);
            ResultSet age_set = stmt.executeQuery();
            if (age_set.next()) {
                average_age = age_set.getDouble(1);
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return average_age;
    }

    public static ResultSet customerDivisionQuery() {
        String query = "SELECT c.first_name, c.last_name\n" +
                "FROM customer c\n" +
                "WHERE NOT EXISTS\n" +
                "(SELECT p.eid\n" +
                "FROM performs p, performer pf\n" +
                "WHERE p.pid = pf.pid AND pf.stage_name = 'Ariana Grande' AND p.eid NOT IN\n" +
                "(SELECT p.eid\n" +
                "FROM performs p, performer pf, ticket t, purchase_order po\n" +
                "WHERE p.pid = pf.pid AND p.eid = t.eid AND t.oid = po.oid AND po.username = c.username AND pf.stage_name = 'Ariana Grande'\n" +
                "))";
        ResultSet rs = null;

        try {
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(query);
            rs = stmt.executeQuery();
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return rs;
    }

    private static String booleanToString(boolean b){
        return b? "1" : "0";
    }

}
