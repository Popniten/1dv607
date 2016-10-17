package model;

import java.util.ArrayList;

/**
 * A class to represent a member.
 */
public class Member {
    private String firstname;
    private String lastname;
    private String SSN;
    private ArrayList<Boat> boats;

    /**
     * Constructor.
     *
     * @param firstname Member first name.
     * @param lastname Member last name.
     * @param SSN Members social security number.
     */
    public Member(String firstname, String lastname, String SSN) {
        this.boats = new ArrayList<>();
        this.setFirstname(firstname);
        this.setLastname(lastname);
        setSSN(SSN);
    }

    /**
     * Copy constructor
     *
     * @param that Member to copy.
     */
    public Member(Member that) {
        this.boats = that.getBoats();
        this.setLastname(that.getLastname());
        this.setFirstname(that.getFirstname());
        this.setSSN(that.getSSN());
    }

    /**
     * Clones a member.
     *
     * @return Member Clone.
     */
    public Member clone() {
        return new Member(this);
    }

    /**
     * String representation of a member.
     *
     * @return A string.
     */
    public String toString() {
        String str = "\n\n" + this.getSSN() + ": " + this.getFirstname() + " " + this.getLastname() + "\n";

        for (int i = 0; i < this.boats.size(); i++) {
            str += this.boats.get(i).toString() + " ";
        }
        return str;
    }

    /**
     * Get the members first name.
     *
     * @return First name.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Set the members first name.
     *
     * @param firstname New first name.
     */
    public void setFirstname(String firstname) {
        if (!firstname.trim().equals("")) {
            this.firstname = firstname;
        }
        else {
            throw new IllegalArgumentException("First name cannot be empty.");
        }
    }

    /**
     * Get the members last name.
     *
     * @return Last name.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Set the members last name.
     *
     * @param lastname New last name.
     */
    public void setLastname(String lastname) {
        if (!lastname.trim().equals("")) {
            this.lastname = lastname;
        }
        else {
            throw new IllegalArgumentException("Last name cannot be empty.");
        }
    }

    /**
     * Get the members social security number.
     *
     * @return SSN.
     */
    public String getSSN() {
        return SSN;
    }

    /*
     *
     */
    private void setSSN(String SSN) {
        if (!SSN.trim().equals("")) {
            this.SSN = SSN;
        }
        else {
            throw new IllegalArgumentException("Social security number cannot be empty.");
        }
    }

    /**
     * Adds a boat to a member.
     *
     * @param boat The Boat to add.
     */
    public void addBoat(Boat boat) {
        this.boats.add(boat);
    }

    /**
     * Gets all members boats.
     *
     * @return Boats.
     */
    public ArrayList<Boat> getBoats() {
        ArrayList<Boat> boats = new ArrayList<>();

        for(Boat b : this.boats) {
            boats.add(b.clone());
        }
        return boats;
    }
}
