package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public Connection connect() {
        Connection c = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver").newInstance();
            c = DriverManager.getConnection("jdbc:mariadb://localhost:3306/salon?user=root&password=");
            System.out.println("Connected to the MariDB server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }

        return c;
    }

}
