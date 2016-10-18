package model;

import java.sql.ResultSet;

/**
 * Interface for data storage.
 */
interface IStorage {
    void insertMember(String fName, String lName, String ssn);
    ResultSet getMember(String ssn);
    ResultSet getAllMembers();
    void updateMember(String fName, String lName, String ssn);
    void deleteMember(String ssn);

    void insertBoat(String name, String type, int length, String ownerSSN);
    ResultSet getMembersBoats(String ownerSSN);
    void updateBoat(String name, String type, int length, int boatID);
    void deleteBoat(int boatID);
}
