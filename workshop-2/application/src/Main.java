import controller.DBController;

public class Main
{
    public static void main( String args[] )
    {
        String sql = "INSERT INTO Member (firstname, lastname, ssn) VALUES ('test', 'testson', 9999)";
        DBController db = new DBController();
        db.runCommand(sql);
    }
}
