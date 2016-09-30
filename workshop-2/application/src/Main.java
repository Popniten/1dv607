import model.Boat;
import model.Member;
import model.Registry;
import view.GUIConsole;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        //GUIConsole prgm = new GUIConsole();

        Registry test = new Registry();
        test.fetchMember("1339");
        Boat myBoat = new Boat("Testboat", 345, "Kallekuling", "999");
        //myBoat.setOwner("1339");
        String str = test.addBoat(myBoat);
        System.out.println(str);

        //test.fetchAllMembers();

        //ArrayList<Member> list = test.getMembers();
        //System.out.println(list.toString());

    }
}