package model;

import java.sql.*;

/**
 * A class to handle the SQLite database.
 */
class Database {

    private Connection c = null;
    private Statement stmt = null;

    /**
     * Takes information about a member and inserts
     * it into the database.
     *
     * @param fName Members first name.
     * @param lName Members last name.
     * @param ssn Members social security number.
     */
    void insertMember(String fName, String lName, String ssn) {
        String sql = "INSERT INTO Member (firstname, lastname, ssn) VALUES ('"
                + fName
                + "', '"
                + lName
                + "', '"
                + ssn
                +"')";
        this.updateDatabase(sql);
    }

    /**
     * Fetches a member from the database and returns
     * it as a ResultSet.
     *
     * @param ssn The SSN of the member to fetch.
     * @return ResultSet.
     */
    ResultSet getMember(String ssn) {
        String sql = "SELECT * FROM Member WHERE ssn = '" + ssn + "'";
        return this.selectFromDatabase(sql);
    }

    /**
     * Fetches all members in the database.
     *
     * @return ResultSet of members.
     */
    ResultSet getAllMembers() {
        String sql = "SELECT * FROM Member";
        return this.selectFromDatabase(sql);
    }

    /**
     * Updates a member in the database.
     *
     * @param fName The members new first name.
     * @param lName The members new last name.
     * @param ssn The SSN of the member to update.
     */
    void updateMember(String fName, String lName, String ssn) {
        String sql = "UPDATE Member " +
                     "SET firstname = '" + fName + "', " +
                     "lastname = '" + lName + "' " +
                     "WHERE ssn = '" + ssn + "'";
        this.updateDatabase(sql);
    }

    void deleteMember(String ssn) {
        String sql = "";
    }

    void insertBoat(String name, String type, int ownerID) {String sql = "";}

    void getBoats() {
        String sql = "";
    }

    void updateBoat(String name, String type, int ownerID, int boatID) {
        String sql = "";
    }

    void deleteBoat(int boatID) {
        String sql = "";
    }

    /**
     * A method to get SQL queries to send to the database.
     *
     * @param command SQL command.
     * @param mem Member to handle.
     * @return SQL query.
     */
    String getMemberQuery(String command, Member mem) {
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

    /**
     * Select all members.
     *
     * @return Query.
     */
    String getMemberQuery() {
        return "SELECT * FROM Member";
    }

    /**
     * Select a specific member.
     *
     * @param ssn Member to select.
     * @return Query.
     */
    String getMemberQuery(String ssn) {
        return "SELECT * FROM Member WHERE ssn = '" + ssn + "'";
    }

    /**
     * Select boats from database.
     *
     * @param mem The members boats.
     * @return Query.
     */
    String getMemberBoatsQuery(Member mem) {
        return "SELECT * FROM Boat WHERE owner = '" + mem.getSSN() + "'";
    }

    /**
     * Insert boat to database.
     *
     * @param ownerSsn Owner ssn.
     * @param boat Boat to insert.
     * @return Query.
     */
    String getInsertBoatQuery(String ownerSsn, Boat boat) {
        return "INSERT INTO Boat (type, name, length, owner) VALUES " +
                "('" + boat.getType() + "', '" + boat.getName() + "', '" +
                boat.getLength() + "', '" + ownerSsn + "')";
    }

    /**
     * Boat queries for database.
     *
     * @param command SQL command.
     * @param boat Boat
     * @return Query.
     */
    String getBoatQuery(String command, Boat boat) {
        String sql = "";
        switch(command) {
            case "insert":
                sql = "INSERT INTO Boat (type, name, length) VALUES " +
                        "('" + boat.getType() + "', '" + boat.getName() + "', '" +
                            boat.getLength() + "')";
                break;
            case "update":
                sql = "UPDATE Boat " +
                        "SET type = '" + boat.getType() + "', " +
                        "name = '" + boat.getName() + "', " +
                        "length = '" + boat.getLength() + "' " +
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

    /**
     * Returns ResultSet if success, null if not
     *
     * @param sql Query to run in database.
     * @return ResultSet|Null.
     */
    ResultSet selectFromDatabase(String sql) {
        ResultSet result = null;
        this.connectToDatabase();

        try {
            this.stmt = this.c.createStatement();
            result = stmt.executeQuery(sql);

        } catch(Exception e) {
            result = null;
        }

        return result;
    }

    /**
     * Returns null if update was sucessful
     *
     * @param sql Query to run.
     * @return Null if successful.
     */
    String updateDatabase(String sql) {
        this.connectToDatabase();

        try {
            this.stmt = this.c.createStatement();
            stmt.executeUpdate(sql);

            return null;
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    /*
     *
     */
    private boolean connectToDatabase() {
        if(isConnectionClosed()) {
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

    /*
     *
     */
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

    /**
     * Close the database connection.
     */
    void closeDatabaseConnection() {
        if (this.c != null) {
            try {
                this.stmt.close();
                this.c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
