package model;

import java.util.ArrayList;

/**
 *
 */
public class Member {
    //TODO: add validation to setters
    private String firstname;
    private String lastname;
    private String SSN;
    private ArrayList<Boat> boats;

    /**
     *
     * @param firstname
     * @param lastname
     * @param SSN
     */
    public Member(String firstname, String lastname, String SSN) {
        this.boats = new ArrayList<>();
        setFirstname(firstname);
        setLastname(lastname);
        setSSN(SSN);
    }

    /**
     * copy constructor
     *
     * @param that
     */
    public Member(Member that) {
        this.boats = that.getBoats();
        this.setLastname(that.getLastname());
        this.setFirstname(that.getFirstname());
        this.setSSN(that.getSSN());
    }

    /**
     *
     * @return
     */
    public Member clone() {
        return new Member(this);
    }

    /**
     *
     * @return
     */
    public String toString() {
        String str = "\n\n" + this.getSSN() + ": " + this.getFirstname() + " " + this.getLastname() + "\n";

        for (int i = 0; i < this.boats.size(); i++) {
            str += this.boats.get(i).toString() + " ";
        }
        return str;
    }

    /**
     *
     * @return
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     *
     * @param firstname
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
     *
     * @return
     */
    public String getLastname() {
        return lastname;
    }

    /**
     *
     * @param lastname
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
     *
     * @return
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
     *
     * @param boat
     */
    public void addBoat(Boat boat) {
        this.boats.add(boat);
    }

    /**
     *
     * @return
     */
    public ArrayList<Boat> getBoats() {
        ArrayList<Boat> boats = new ArrayList<>();

        for(Boat b : this.boats) {
            boats.add(b.clone());
        }
        return boats;
    }
}
