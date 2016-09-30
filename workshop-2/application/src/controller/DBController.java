package controller;

import java.sql.*;

public class DBController {
    /*private Connection c = null;
    private Statement stmt = null;

    public ResultSet selectFromDatabase(String sql) {
        ResultSet result = null;
        this.connectToDatabase();

        try {
            this.stmt = this.c.createStatement();
            result = stmt.executeQuery(sql);


            //stmt.close();
            return result;
        } catch(Exception e) {
            e.printStackTrace();
        }

        //this.closeDatabaseConnection();
        return result;
    }

    public boolean updateDatabase(String sql) {
        this.connectToDatabase();

        try {
            this.stmt = this.c.createStatement();
            stmt.executeUpdate(sql);

            //stmt.close();
            return true;
        } catch(Exception e) {
            e.printStackTrace();
        }

        //this.closeDatabaseConnection();
        return false;
    }

    private boolean connectToDatabase() {
        System.out.println("connection...");
        try {
            Class.forName("org.sqlite.JDBC");
            this.c = DriverManager.getConnection("jdbc:sqlite:data/MemberRegistry.db");
        } catch ( Exception e ) {
            System.out.println("WOOPSIE");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private void closeDatabaseConnection() {
        if (this.c != null) {
            try {
                //this.c.commit();
                this.stmt.close();
                this.c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }*/
}
