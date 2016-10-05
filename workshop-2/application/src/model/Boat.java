package model;

/**
 *
 */
public class Boat {
    private int id;
    private BoatType type;
    private int length;
    private String name;

    /**
     *
     */
    public enum BoatType {
        Sailboat, Motorsailer, Canoe, Other
    }

    /**
     *
     * @param type
     * @param length
     * @param name
     */
    public Boat(BoatType type, int length, String name) {
        this.setType(type);
        this.setLength(length);
        this.setName(name);
    }

    /**
     *
     * @param id
     * @param type
     * @param length
     * @param name
     */
    public Boat(int id, BoatType type, int length, String name) {
        this.setId(id);
        this.setType(type);
        this.setLength(length);
        this.setName(name);
    }

    /**
     * Copy constructor
     *
     * @param that
     */
    public Boat(Boat that) {
        this.setId(that.getId());
        this.setType(that.getType());
        this.setLength(that.getLength());
        this.setName(that.getName());
    }

    /**
     *
     * @return
     */
    public Boat clone() {
        return new Boat(this);
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     * @return
     */
    public boolean setId(int id) {
        if (id > 0) {
            this.id = id;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     *
     * @return
     */
    public BoatType getType() {
        return type;
    }

    /**
     *
     * @param type
     * @return
     */
    public boolean setType(BoatType type) {
        this.type = type;
        return true;
    }

    /**
     *
     * @return
     */
    public int getLength() {
        return length;
    }

    /**
     *
     * @param length
     */
    public void setLength(int length) {
        if (length > 0) {
            this.length = length;
        }
        else {
            throw new IllegalArgumentException("Boat length cannot be zero or less.");
        }
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        if (!name.equals("")) {
            this.name = name;
        }
        else {
            throw new IllegalArgumentException("Boat name cannot be empty.");
        }
    }

    /**
     *
     * @return
     */
    public String toString() {
        return this.getName() + ", " + this.getType() + ", " + this.getLength() + "cm.";
    }
}
