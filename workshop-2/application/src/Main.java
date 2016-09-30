import model.Member;
import model.Registry;
import view.GUIConsole;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        //GUIConsole prgm = new GUIConsole();

        Registry test = new Registry();
        //test.fetchMember(12345);
        String str = test.registerMember(new Member("Oskar", "Emilsson", "1337"));
        System.out.println(str);

        test.fetchAllMembers();

        ArrayList<Member> list = test.getMembers();
        System.out.println(list.toString());
        list.get(0).setSSN("fuckedup");

        list = test.getMembers();
        System.out.println(list.toString());
    }
}