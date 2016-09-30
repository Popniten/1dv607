package model;

import java.util.ArrayList;
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
    private ArrayList<Boat> boats;

    public Member(String firstname, String lastname, String SSN) {
        this.boats = new ArrayList<>();
        setFirstname(firstname);
        setLastname(lastname);
        setSSN(SSN);
    }

    /*copy constructor*/
    public Member(Member that) {
        this.boats = that.getBoats();
        this.setLastname(that.getLastname());
        this.setFirstname(that.getFirstname());
        this.setSSN(that.getSSN());
    }

    public Member clone() {
        return new Member(this);
    }

    public String toString() {
        String str = "\n\n" + this.getSSN() + ": " + this.getFirstname() + " " + this.getLastname() + "\n";

        for (int i = 0; i < this.boats.size(); i++) {
            str += this.boats.get(i).toString() + " ";
        }
        return str;
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

    public void addBoat(Boat boat) {
        this.boats.add(boat);
    }

    public ArrayList<Boat> getBoats() {
        ArrayList<Boat> boats = new ArrayList<>();

        for(Boat b : this.boats) {
            boats.add(b.clone());
        }
        return boats;
    }


}
