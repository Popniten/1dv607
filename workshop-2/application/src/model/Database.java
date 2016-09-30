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
                        "lastname = '" + mem.getLastname() + "' " +
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

    protected String getMemberQuery(String ssn) {
        return "SELECT * FROM Member WHERE ssn = '" + ssn + "'";
    }

    protected String getMemberBoatsQuery(Member mem) {
        return "SELECT * FROM Boat WHERE owner = '" + mem.getSSN() + "'";
    }

    protected String getBoatQuery(String command, Boat boat) {
        String sql = "";
        switch(command) {
            case "insert":
                sql = "INSERT INTO Boat (type, name, length, owner) VALUES " +
                        "('" + boat.getType() + "', '" + boat.getName() + "', '" +
                            boat.getLength() + "', '" + boat.getOwner()+ "')";
                break;
            case "update":
                sql = "UPDATE Boat " +
                        "SET type = '" + boat.getType() + "', " +
                        "name = '" + boat.getName() + "', " +
                        "length = '" + boat.getLength() + "', " +
                        "owner = '" + boat.getOwner() + "' " +
                        "WHERE id = '" + boat.getId() + "'";
                break;
            case "select":
                sql = "SELECT * FROM Boat WHERE id = '" + boat.getId() + "'";
                break;
            case "delete":
                sql = "DELETE FROM Boat WHERE id = '" + boat.getId() + "'";
                break;
            default:
                break;
        }
        return sql;
    }

    protected ResultSet selectFromDatabase(String sql) {
        ResultSet result = null;
        this.connectToDatabase();

        try {
            this.stmt = this.c.createStatement();
            result = stmt.executeQuery(sql);

            //stmt.close();
            //return result;
        } catch(Exception e) {
            e.printStackTrace();
            //return null;
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
        if(isConnectionClosed()) {
            System.out.println("connection...");
            try {
                Class.forName("org.sqlite.JDBC");
                this.c = DriverManager.getConnection("jdbc:sqlite:data/MemberRegistry.db");
                return true;
            } catch (Exception e) {
                System.out.println("WOOPSIE");
                e.printStackTrace();
                return false;
            }
        }
        else {
            return false;
        }
    }

    private boolean isConnectionClosed() {
        if (this.c != null) {
            //check if the connection is closed
            try {
                return this.c.isClosed();
            } catch (SQLException e) {
                return false;
            }
        } else {
            //this.c is null, therefore closed
            return true;
        }
    }

    public void closeDatabaseConnection() {
        System.out.println("closing connection...");
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
