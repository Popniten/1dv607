package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kitty on 9/30/16.
 */
public class Registry {
    Database db;
    private ArrayList<Member> members;

    public Registry() {
        this.db = new Database();
        members = new ArrayList<>();
    }

    private void fetchAllMembers() {
        ResultSet result = this.db.selectFromDatabase(this.db.getMemberQuery());

        this.saveFetchedMembers(result);
    }

    private boolean fetchMember(String ssn) {
        ResultSet result = this.db.selectFromDatabase(this.db.getMemberQuery(ssn));
        this.saveFetchedMembers(result);

        return isMember(ssn);
    }

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

    /*public String registerMember(Member newMember) {
        return this.db.updateDatabase(this.db.getMemberQuery("insert", newMember));
    }*/

    private void saveFetchedMembers(ResultSet result) {
        try {
            this.members = new ArrayList<>();
            while(result.next()) {
                Member tmp = new Member(result.getString("firstname"), result.getString("lastname"), result.getString("ssn"));

                this.fetchBoats(tmp);

                this.members.add(tmp);
            }

            //done with fetches, close dbconnection
            this.db.closeDatabaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void fetchBoats(Member mem) {
        ResultSet result = this.db.selectFromDatabase(this.db.getMemberBoatsQuery(mem));
        this.addBoatsToMember(result, mem);
    }

    private void addBoatsToMember(ResultSet result, Member mem) {
        try {
            while(result.next()) {
                Boat tmp = new Boat(result.getInt("id"), result.getString("type"), result.getInt("length"), result.getString("name"));
                mem.addBoat(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Member> getMembers() {
        this.fetchAllMembers();
        ArrayList<Member> members = new ArrayList<>();
        for(Member m : this.members) {
            members.add(m.clone());
        }
        return members;
    }

    public String addMember(Member mem) {
        return this.db.updateDatabase(this.db.getMemberQuery("insert", mem));
    }

    public String updateMember(Member mem) {
        if (isMember(mem.getSSN())) {
            return this.db.updateDatabase(this.db.getMemberQuery("update", mem));
        }
        else {
            return null;
        }
    }

    public String removeMember(Member mem) {
        if (isMember(mem.getSSN())) {
            return this.db.updateDatabase(this.db.getMemberQuery("delete", mem));
        }
        else {
            return null;
        }
    }

    /*
        Returns a member if found, null if not
     */
    public Member getMember(String ssn) {
        if (this.fetchMember(ssn)) {
            return this.members.get(0);
        }
        return null;
    }

    /*
        Boat functions
    */
    public String addBoat(String ownerSsn, Boat boat) {
        if(this.fetchMember(ownerSsn)) {
            return this.db.updateDatabase(this.db.getInsertBoatQuery(ownerSsn, boat));
        }
        else {
            return "No member found with that SSN";
        }

    }

    public String updateBoat(Boat boat) {
        return this.db.updateDatabase(this.db.getBoatQuery("update", boat));
    }

    public String removeBoat(Boat boat) {
        return this.db.updateDatabase(this.db.getBoatQuery("delete", boat));
    }
}
