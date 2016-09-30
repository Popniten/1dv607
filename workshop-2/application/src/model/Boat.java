package model;

/**
 * Created by popniten on 2016-09-21.
 */
public class Boat {
    private String type;
    private int length;
    private String name;
    private int owner;

    public Boat(String type, int length, String name, int owner) {
        this.setType(type);
        this.setLength(length);
        this.setName(name);
        this.setOwner(owner);
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

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public String toString() {
        return this.getName() + ", " + this.getType();
    }
}
