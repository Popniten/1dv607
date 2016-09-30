import model.Registry;
import view.GUIConsole;

public class Main {
    public static void main(String args[]) {
        //GUIConsole prgm = new GUIConsole();

        Registry test = new Registry();
        //test.fetchAllMembers();
        test.fetchMember(12345);
    }
}