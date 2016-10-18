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

    /**
     * Deletes a member from the database.
     *
     * @param ssn The SSN of the member to delete.
     */
    void deleteMember(String ssn) {
        String sql = "DELETE FROM Member WHERE ssn = '" + ssn + "'";
        this.updateDatabase(sql);
    }

    /**
     * Inserts a new boat into the database.
     *
     * @param name Name of the boat.
     * @param type Boat type.
     * @param length Boats length.
     * @param ownerSSN Boat owners SSN.
     */
    void insertBoat(String name, String type, int length, String ownerSSN) {
        String sql = "INSERT INTO Boat (type, name, length, owner) VALUES "
                + "('"
                + type
                + "', '"
                + name
                + "', '"
                + length
                + "', '"
                + ownerSSN
                + "')";
        this.updateDatabase(sql);
    }

    /**
     * Returns a result set of a members boats.
     *
     * @param ownerSSN The member.
     * @return ResultSet of boats.
     */
    ResultSet getMembersBoats(String ownerSSN) {
        String sql = "SELECT * FROM Boat WHERE owner = '" + ownerSSN + "'";
        return this.selectFromDatabase(sql);
    }

    /**
     * Updates a boats information in the database.
     *
     * @param name Boats name.
     * @param type Boat type.
     * @param length Boat length.
     * @param boatID Boats ID.
     */
    void updateBoat(String name, String type, int length, int boatID) {
        String sql = "UPDATE Boat " +
                "SET type = '" + type + "', " +
                "name = '" + name + "', " +
                "length = '" + length + "' " +
                "WHERE id = '" + boatID + "'";
        this.updateDatabase(sql);
    }

    /**
     * Deletes a boat from the database.
     *
     * @param boatID ID of the boat to delete.
     */
    void deleteBoat(int boatID) {
        String sql = "DELETE FROM Boat WHERE id = '" + boatID + "'";
        this.updateDatabase(sql);
    }

    private ResultSet selectFromDatabase(String sql) {
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

    private String updateDatabase(String sql) {
        this.connectToDatabase();

        try {
            this.stmt = this.c.createStatement();
            stmt.executeUpdate(sql);

            return null;
        } catch(Exception e) {
            return e.getMessage();
        }
    }

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
