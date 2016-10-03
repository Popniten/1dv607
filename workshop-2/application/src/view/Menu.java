package view;

import model.Member;
import model.Registry;

public class Menu {
    private StringBuilder titleBar;
    private Registry reg = new Registry();

    public Menu() {
        this.initTitleBar();
    }

    private void initTitleBar() {
        titleBar = new StringBuilder();
        titleBar.append("####################################\n");
        titleBar.append("# The Happy Pirate Member Registry #\n");
        titleBar.append("####################################\n");
        titleBar.append("------------------------------------\n");
    }

    public String getTitleBar() {
        return titleBar.toString();
    }

    public String getMainMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("MAIN MENU\n");
        sb.append("1. List members (compact)\n");
        sb.append("2. List members (verbose)\n");
        sb.append("3. Register member\n");
        sb.append("4. Update member\n");
        sb.append("5. Remove member\n");
        sb.append("6. View member\n");
        sb.append("7. Register boat\n");
        sb.append("8. Update boat\n");
        sb.append("9. Delete boat\n");
        sb.append("\n");
        sb.append("0. Exit application\n");
        sb.append("Choose, then press enter: ");

        return sb.toString();
    }

    public String getSeparator() {
        return "------------------------------------\n";
    }

    private void registerMember() {
        System.out.print("Enter first name: ");
        String fName = Input.getString();
        System.out.print("Enter last name: ");
        String lName = Input.getString();
        System.out.print("Enter SSN: ");
        String ssn = Input.getString();

        String test = reg.addMember(new Member(fName, lName, ssn));

        System.out.println(test);

        // Registry.add(new Member(fName...))
    }

    private void updateMember() {
        System.out.print("Enter SSN of member to update: ");
        String ssn = Input.getString();
        System.out.print("Enter first name (NameFromDatabase): ");
        String fName = Input.getString();
        System.out.print("Enter last name (NameFromDatabase): ");
        String lName = Input.getString();
    }

    private void removeMember() {
        System.out.print("Enter SSN of member to delete: ");
        String ssn = Input.getString();
        System.out.print("Are you sure you want to do this (y/n)? ");
        String answer = Input.getString();

        if (answer.equals("y")) {
            System.out.println("Deleting member...");
        }
    }

    public String mainMenuRoute(int menuChoice) {
        StringBuilder s = new StringBuilder();
        switch (menuChoice) {
            case 0:     // Quit
                return null;
            case 1:     // List members compact
                s.append("Compact members list\n");
                s.append("Press Enter to continue...");
                break;
            case 2:     // List members verbose
                s.append("Verbose members list\n");
                s.append("Press Enter to continue...");
                break;
            case 3:     // Register member
                System.out.println(getSeparator());
                System.out.println("Register member\n");
                this.registerMember();
                s.append("Press Enter to continue...");
                break;
            case 4:     // Update member
                System.out.println(getSeparator());
                System.out.println("Update member\n");
                this.updateMember();
                s.append("Press Enter to continue...");
                break;
            case 5:     // Remove member
                System.out.println(getSeparator());
                System.out.println("Remove member\n");
                this.removeMember();
                s.append("Press Enter to continue...");
                break;
            case 6:     // View member
                s.append("View member");
                s.append("Press Enter to continue...");
                break;
            case 7:     // Register boat
                s.append("Register boat\n");
                break;
            case 8:     // Update boat
                s.append("Update boat\n");
                break;
            case 9:     // Delete boat
                s.append("Delete boat\n");
                break;
            default:    // Default
                return null;

        }

        return s.toString();
    }

}
