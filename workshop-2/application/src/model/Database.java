package model;

import java.sql.*;

/**
 * Created by kitty on 9/30/16.
 */
public class Database {

    private Connection c = null;
    private Statement stmt = null;

    protected String getMemberQuery(String command, Member mem) {
        String sql = "";
        switch(command) {
            case "insert":
                sql = "INSERT INTO Member (firstname, lastname, ssn) VALUES " +
                        "('" + mem.getFirstname() + "', '" + mem.getLastname() + "', '" + mem.getSSN() + "')";
                break;
            case "update":
                sql = "UPDATE Member " +
                        "SET firstname = '" + mem.getFirstname() + "', " +
                        "lastname = '" + mem.getLastname() + "', " +
                        "ssn = '" + mem.getSSN() + "'" +
                        "WHERE ssn = '" + mem.getSSN() + "'";
                break;
            case "select":
                sql = "SELECT * FROM Member WHERE ssn = '" + mem.getSSN() + "'";
                break;
            case "delete":
                sql = "DELETE FROM Member WHERE ssn = '" + mem.getSSN() + "'";
                break;
            default:
                break;
        }
        return sql;
    }

    protected String getMemberQuery() {
        return "SELECT * FROM Member";
    }

    protected String getMemberQuery(int ssn) {
        return "SELECT * FROM Member WHERE ssn = '" + ssn + "'";
    }

    protected String getMemberBoatsQuery(Member mem) {
        return "SELECT * FROM Boat WHERE owner = '" + mem.getSSN() + "'";
    }

    protected ResultSet selectFromDatabase(String sql) {
        ResultSet result = null;
        if (this.c == null) {
            this.connectToDatabase();
        }

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

    protected String updateDatabase(String sql) {
        this.connectToDatabase();

        try {
            this.stmt = this.c.createStatement();
            stmt.executeUpdate(sql);

            //stmt.close();
            return null;
        } catch(Exception e) {
            //e.printStackTrace();
            return e.getMessage();
        }
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

    public void closeDatabaseConnection() {
        if (this.c != null) {
            try {
                //this.c.commit();
                this.stmt.close();
                this.c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
