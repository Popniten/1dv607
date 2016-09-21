package controller;
import java.sql.*;

public class DBController {
    private Connection c = null;

    public void runCommand(String sql) {
        this.connectToDatabase();

        try {
            Statement stmt = this.c.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        this.closeDatabaseConnection();
    }

    private boolean connectToDatabase() {
        try {
            Class.forName("org.sqlite.JDBC");
            this.c = DriverManager.getConnection("jdbc:sqlite:src/data/MemberRegistry.db");
        } catch ( Exception e ) {
            return false;
        }
        return true;
    }

    private void closeDatabaseConnection() {
        if (this.c != null) {
            try {
                //this.c.commit();
                this.c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
