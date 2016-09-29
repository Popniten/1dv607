package view;

import controller.DBController;
import model.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by popniten on 2016-09-21.
 */
public class GUIConsole {
    DBController db;
    Scanner input;

    public GUIConsole() {
        db = new DBController();
        input = new Scanner(System.in);
        this.run();
    }

    private void run() {
        int key = -1;
        printMenu(createMainMenu());
        while (key != 0) {
            key = this.input.nextInt();
            switch (key) {
                case 1:
                    printMemberList(db.selectFromDatabase("SELECT * FROM Member"));
                    break;
                case 2:
                    registerMember();
                    break;
            }

            printMenu(createMainMenu());
        }
    }

    private String createMainMenu() {
        String menu = "\n DAZ PROGRAMASSSS \n";
        menu += "1. List members \n";
        menu += "2. Register member \n";
        menu += "3. Update member \n";
        menu += "4. Remove member \n";

        return menu;
    }

    private void printMenu(String menu) {
        System.out.println(menu);
    }

    private void printMemberList(ResultSet result) {
        try {
            while(result.next()) {
                Member tmp = new Member(result.getString("firstname"), result.getString("lastname"), result.getString("ssn"));
                System.out.println(tmp.toString());

            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }

    private void registerMember() {
        this.input = new Scanner(System.in);
        System.out.print("SSN: ");
        String ssn = this.input.nextLine();
        System.out.print("Firstname: ");
        String firstname = this.input.nextLine();
        System.out.print("Lastname: ");
        String lastname = this.input.nextLine();

        Member newMember = new Member(firstname, lastname, ssn);
        this.db.updateDatabase(newMember.getSQLQuery("insert"));
    }
}
