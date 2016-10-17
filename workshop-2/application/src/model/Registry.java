package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * A registry to hold members and their boats.
 */
public class Registry {
    private Database db;
    private ArrayList<Member> members;

    /**
     * Constructor.
     */
    public Registry() {
        this.db = new Database();
        members = new ArrayList<>();
    }

    /**
     * Get all members from Database.
     *
     * @return ArrayList of Members.
     */
    public ArrayList<Member> getMembers() {
        this.fetchAllMembers();
        ArrayList<Member> members = new ArrayList<>();
        for(Member m : this.members) {
            members.add(m.clone());
        }
        return members;
    }

    /**
     * Add member to registry.
     *
     * @param mem Member to add.
     */
    public void addMember(Member mem) {
        try {
            this.db.updateDatabase(this.db.getMemberQuery("insert", mem));
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Update member in registry (and database).
     *
     * @param mem Member to update.
     */
    public void updateMember(Member mem) {
        if (isMember(mem.getSSN())) {
            try {
                this.db.updateDatabase(this.db.getMemberQuery("update", mem));
            } catch (Exception e) {
                throw e;
            }
        }
    }

    /**
     * Remove member from registry.
     *
     * @param mem Member to remove.
     * @return Null if unsuccessful.
     */
    public String removeMember(Member mem) {
        if (isMember(mem.getSSN())) {
            return this.db.updateDatabase(this.db.getMemberQuery("delete", mem));
        }
        else {
            return null;
        }
    }

    /**
     * Returns a member if found, null if not
     *
     * @param ssn Member to get.
     * @return Member|Null.
     */
    public Member getMember(String ssn) {
        if (this.fetchMember(ssn)) {
            return this.members.get(0);
        }
        return null;
    }

    /**
     * Add a boat to a member.
     *
     * @param ownerSsn Member that owns the boat.
     * @param boat Boat to add.
     * @return String.
     */
    public String addBoat(String ownerSsn, Boat boat) {
        if(this.fetchMember(ownerSsn)) {
            return this.db.updateDatabase(this.db.getInsertBoatQuery(ownerSsn, boat));
        }
        else {
            return "No member found with that SSN";
        }

    }

    /**
     * Update a boat.
     *
     * @param boat Boat to update.
     * @return String.
     */
    public String updateBoat(Boat boat) {
        return this.db.updateDatabase(this.db.getBoatQuery("update", boat));
    }

    /**
     * Remove a boat.
     *
     * @param boat Boat to remove.
     * @return String.
     */
    public String removeBoat(Boat boat) {
        return this.db.updateDatabase(this.db.getBoatQuery("delete", boat));
    }

    /*
     *
     */
    private void fetchAllMembers() {
        ResultSet result = this.db.selectFromDatabase(this.db.getMemberQuery());

        this.saveFetchedMembers(result);
    }

    /*
     *
     */
    private boolean fetchMember(String ssn) {
        ResultSet result = this.db.selectFromDatabase(this.db.getMemberQuery(ssn));
        this.saveFetchedMembers(result);

        return isMember(ssn);
    }

    /*
     *
     */
    private boolean isMember(String ssn) {
        boolean valid = false;
        ResultSet result = this.db.selectFromDatabase(this.db.getMemberQuery(ssn));
        try {
            if (result.next()) {
                valid = true;
            } else {
                valid = false;
            }
        } catch (SQLException e) {
            valid = false;
        }
        //done with fetches, close dbconnection
        this.db.closeDatabaseConnection();

        return valid;
    }

    /*
     *
     */
    private void saveFetchedMembers(ResultSet result) {
        try {
            this.members = new ArrayList<>();
            while(result.next()) {
                Member tmp = new Member(result.getString("firstname"), result.getString("lastname"), result.getString("ssn"));

                this.addMembersBoats(tmp);

                this.members.add(tmp);
            }

            //done with fetches, close dbconnection
            this.db.closeDatabaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     *
     */
    private void addMembersBoats(Member mem) {
        try {
            ResultSet result = this.db.selectFromDatabase(this.db.getMemberBoatsQuery(mem));

            while(result.next()) {
                Boat.BoatType type = Boat.BoatType.valueOf(result.getString("type"));
                Boat tmp = new Boat(result.getInt("id"), type, result.getInt("length"), result.getString("name"));
                mem.addBoat(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
