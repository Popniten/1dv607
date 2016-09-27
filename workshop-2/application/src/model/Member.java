package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by popniten on 2016-09-21.
 */
public class Member {
    //TODO: add validation to setters
    private String firstname;
    private String lastname;
    private String SSN;
    //private String SQLQuery;

    public Member(String firstname, String lastname, String SSN) {
        setFirstname(firstname);
        setLastname(lastname);
        setSSN(SSN);
    }

    public String toString() {
        return this.getSSN() + ": " + this.getFirstname() + " " + this.getLastname();
    }

    public String getSQLQuery(String command) {
        String sql = "";
        switch(command) {
            case "insert":
                 sql = "INSERT INTO Member (firstname, lastname, ssn) VALUES " +
                        "('" + this.firstname + "', '" + this.lastname + "', '" + this.SSN + "')";
                break;
            case "update":
                sql = "UPDATE Member " +
                        "SET firstname = '" + this.firstname + "', " +
                        "lastname = '" + this.lastname + "', " +
                        "ssn = '" + this.SSN + "'" +
                        "WHERE ssn = '" + this.SSN + "'";
                break;
            case "select":
                sql = "SELECT * FROM Member WHERE ssn = '" + this.SSN + "'";
                break;
            case "delete":
                sql = "DELETE FROM Member WHERE ssn = '" + this.SSN + "'";
                break;
            default:
                break;
        }
        return sql;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }
}
