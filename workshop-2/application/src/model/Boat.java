package model;

/**
 * A representation of a boat.
 */
public class Boat {
    private int id;
    private BoatType type;
    private int length;
    private String name;

    /**
     * Available boat types.
     */
    public enum BoatType {
        Sailboat, Motorsailer, Canoe, Other
    }

    /**
     * Constructor.
     *
     * @param type Boat type.
     * @param length Boats length.
     * @param name Boats name.
     */
    public Boat(BoatType type, int length, String name) {
        this.setType(type);
        this.setLength(length);
        this.setName(name);
    }

    /**
     * Alternate constructor.
     *
     * @param id Boats database id.
     * @param type Boat type.
     * @param length Boats length.
     * @param name Boats name.
     */
    public Boat(int id, BoatType type, int length, String name) {
        this.setId(id);
        this.setType(type);
        this.setLength(length);
        this.setName(name);
    }

    /**
     * Constructor for copying a boat.
     *
     * @param that Boat to copy.
     */
    public Boat(Boat that) {
        this.setId(that.getId());
        this.setType(that.getType());
        this.setLength(that.getLength());
        this.setName(that.getName());
    }

    /**
     * Clone a boat.
     *
     * @return Cloned boat.
     */
    public Boat clone() {
        return new Boat(this);
    }

    /**
     * Return database id.
     *
     * @return Database id.
     */
    int getId() {
        return id;
    }

    /**
     * Set database id.
     *
     * @param id Id
     * @return True if successful.
     */
    boolean setId(int id) {
        if (id > 0) {
            this.id = id;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Return boat type.
     *
     * @return Boat type.
     */
    public BoatType getType() {
        return type;
    }

    /**
     * Set boats type.
     *
     * @param type The boat type.
     * @return True.
     */
    public boolean setType(BoatType type) {
        this.type = type;
        return true;
    }

    /**
     * Get the boats length.
     *
     * @return Boats length.
     */
    public int getLength() {
        return length;
    }

    /**
     * Set the boats length.
     *
     * @param length The boats length.
     * @throws IllegalArgumentException If length is zero or less.
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
     * Get the boats name.
     *
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the boats name.
     *
     * @param name Name.
     * @throws IllegalArgumentException If the boats name is empty.
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
     * String representation of a boat.
     *
     * @return String.
     */
    public String toString() {
        return this.getName() + ", " + this.getType() + ", " + this.getLength() + "cm.";
    }
}
