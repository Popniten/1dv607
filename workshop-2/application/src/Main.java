import model.Member;
import model.Registry;
import view.GUIConsole;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        //GUIConsole prgm = new GUIConsole();

        Registry test = new Registry();
        //test.fetchMember(12345);
        String str = test.removeMember(new Member("Pär", "Testsson", "666"));
        System.out.println(str);

        test.fetchAllMembers();

        ArrayList<Member> list = test.getMembers();
        System.out.println(list.toString());

    }
}