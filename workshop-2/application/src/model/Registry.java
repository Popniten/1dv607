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

    public void fetchAllMembers() {
        ResultSet result = this.db.selectFromDatabase(this.db.getMemberQuery());

        this.saveFetchedMembers(result);

        //done with fetches, close dbconnection
        this.db.closeDatabaseConnection();
    }

    public void fetchMember(int ssn) {
        ResultSet result = this.db.selectFromDatabase(this.db.getMemberQuery(ssn));

        this.saveFetchedMembers(result);

        //done with fetches, close dbconnection
        this.db.closeDatabaseConnection();
    }

    public String registerMember(Member newMember) {
        return this.db.updateDatabase(this.db.getMemberQuery("insert", newMember));
    }

    private void saveFetchedMembers(ResultSet result) {
        try {
            this.members = new ArrayList<>();
            while(result.next()) {
                Member tmp = new Member(result.getString("firstname"), result.getString("lastname"), result.getString("ssn"));

                this.fetchBoats(tmp);

                this.members.add(tmp);
            }
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
                Boat tmp = new Boat(result.getString("type"), result.getInt("length"), result.getString("name"), result.getString("owner"));
                mem.addBoat(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Member> getMembers() {
        ArrayList<Member> members = new ArrayList<>();
        for(Member m : this.members) {
            members.add(m.clone());
        }
        return members;
    }
}
