import controller.DBController;
import model.Member;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main
{
    public static void main( String args[] )
    {
        DBController db = new DBController();
        Member me = new Member("Kalle", "Karlsson", "9203053310");
        db.updateDatabase(me.getSQLQuery("delete"));

        ResultSet debug = db.selectFromDatabase("SELECT * FROM Member");
        try {
            while(debug.next()) {
                Member tmp = new Member(debug.getString("firstname"), debug.getString("lastname"), debug.getString("ssn"));
                System.out.println(tmp.toString());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}