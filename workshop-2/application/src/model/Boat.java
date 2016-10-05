package model;

import java.util.ArrayList;

/**
 * Created by popniten on 2016-09-21.
 */
public class Boat {
    private int id;
    private BoatType type;
    private int length;
    private String name;

    public enum BoatType {
        Sailboat, Motorsailer, Canoe, Other
    }

    public Boat(BoatType type, int length, String name) {
        this.setType(type);
        this.setLength(length);
        this.setName(name);
    }

    public Boat(int id, BoatType type, int length, String name) {
        this.setId(id);
        this.setType(type);
        this.setLength(length);
        this.setName(name);
    }

    /* Copy constructor */
    public Boat(Boat that) {
        this.setId(that.getId());
        this.setType(that.getType());
        this.setLength(that.getLength());
        this.setName(that.getName());
    }

    public Boat clone() {
        return new Boat(this);
    }

    public int getId() {
        return id;
    }

    public boolean setId(int id) {
        if (id > 0) {
            this.id = id;
            return true;
        }
        else {
            return false;
        }
    }

    public BoatType getType() {
        return type;
    }

    public boolean setType(BoatType type) {
        this.type = type;
        return true;
    }

    public int getLength() {
        return length;
    }

    public boolean setLength(int length) {
        if (length > 0) {
            this.length = length;
            return true;
        }
        else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if (!name.equals("")) {
            this.name = name;
            return true;
        }
        else {
            return false;
        }
    }

    public String toString() {
        return this.getName() + ", " + this.getType() + ", " + this.getLength() + "cm.";
    }
}
