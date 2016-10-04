package model;

import java.util.ArrayList;

/**
 * Created by popniten on 2016-09-21.
 */
public class Boat {
    private int id;
    private String type;
    private int length;
    private String name;

    public Boat(String type, int length, String name) {
        this.setType(type);
        this.setLength(length);
        this.setName(name);
    }

    public Boat(int id, String type, int length, String name) {
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

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return this.getName() + ", " + this.getType() + ", " + this.getLength() + "cm.";
    }
}
