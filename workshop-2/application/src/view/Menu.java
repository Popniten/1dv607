package view;

import model.Boat;
import model.Member;
import model.Registry;

import java.util.ArrayList;

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
    }

    private void updateMember() {
        System.out.print("Enter SSN of member to update: ");
        String ssn = Input.getString();

        Member m = reg.getMember(ssn);

        if (m != null) {
            System.out.print("Enter first name (" + m.getFirstname() + "): ");
            String fName = Input.getString();
            System.out.print("Enter last name (" + m.getLastname() + "): ");
            String lName = Input.getString();

            if (!fName.equals("")) {
                m.setFirstname(fName);
            }

            if(!lName.equals("")) {
                m.setLastname(lName);
            }

            reg.updateMember(m);
        } else {
            System.out.println("That member does not exist!");
        }
    }

    private void removeMember() {
        System.out.print("Enter SSN of member to delete: ");
        String ssn = Input.getString();

        Member m = reg.getMember(ssn);

        if (m != null) {
            System.out.print("Are you sure you want to do this (y/n)? ");
            String answer = Input.getString();

            if (answer.equals("y")) {
                reg.removeMember(m);
                System.out.println("Deleting member " + m.getFirstname());
            }
        } else {
            System.out.println("That member does not exist!");
        }
    }

    private void listMembers() {
        ArrayList<Member> members = reg.getMembers();
        System.out.println(members.size());

        for (Member m : members) {
            System.out.println(m.toString());
        }
    }

    private void viewMember() {
        System.out.print("Enter SSN of member to view: ");
        String ssn = Input.getString();

        Member m = reg.getMember(ssn);

        if (m != null) {
            System.out.println(m.toString());
        } else {
            System.out.println("That member does not exist!");
        }
    }

    private void registerBoat() {
        System.out.print("Enter owner SSN: ");
        String ssn = Input.getString();
        Member m = reg.getMember(ssn);

        if (m != null) {
            System.out.print("Enter boat name: ");
            String bName = Input.getString();
            System.out.print("Enter boat type: ");
            String bType = Input.getString();
            System.out.print("Enter boat length (in cm): ");
            int bLength = Input.getInt();

            reg.addBoat(new Boat(bType, bLength, bName, ssn));
        } else {
            System.out.println("That member does not exist!");
        }
    }

    private void updateBoat(Boat b) {
        boolean correctInput = true;
        System.out.print("Enter new boat name (" + b.getName() + "): ");
        String bName = Input.getString();
        System.out.print("Enter new boat length (" + b.getLength() + "): ");
        String bLength = Input.getString();
        System.out.print("Enter new boat type (" + b.getType() + "): ");
        String bType = Input.getString();
        System.out.print("Enter new boat owner SSN (" + b.getOwner() + "): ");
        String bOwnerSSN = Input.getString();

        if (!bName.equals("")) {
            b.setName(bName);
        }

        if (!bLength.equals("")) {
            try {
                b.setLength(Integer.parseInt(bLength));
            } catch (Exception e) {
                correctInput = false;
            }
        }

        if (!bType.equals("")) {
            b.setType(bType);
        }

        if (!bOwnerSSN.equals("")) {
            b.setOwner(bOwnerSSN);
        }

        if (correctInput) {
            reg.updateBoat(b);
        } else {
            System.out.println("Something went wrong, check your input.");
        }
    }

    private void updateBoatMenu() {
        System.out.print("Enter owner SSN: ");
        String ssn = Input.getString();
        Member m = reg.getMember(ssn);

        if (m != null) {
            ArrayList<Boat> boats = m.getBoats();

            if (boats.size() > 1) {
                for (int i = 0; i < boats.size(); i++) {
                    System.out.println((i + 1) + ": " + boats.get(i).getName());
                }

                System.out.println("Which boat do you wish to update? ");
                updateBoat(boats.get(Input.getInt() - 1));
            } else if (boats.size() == 1) {
                Boat b = boats.get(0);
                updateBoat(b);
            } else {
                System.out.println("That member does not own any boats.");
            }
        } else {
            System.out.println("That member does not exist!");
        }
    }

    private void deleteBoat() {

    }

    public String mainMenuRoute(int menuChoice) {
        StringBuilder s = new StringBuilder();
        switch (menuChoice) {
            case 0:     // Quit
                return null;
            case 1:     // List members compact
                s.append("Compact members list\n");
                this.listMembers();

                break;
            case 2:     // List members verbose
                s.append("Verbose members list\n");
                this.listMembers();
                break;
            case 3:     // Register member
                System.out.println(getSeparator());
                System.out.println("Register member\n");
                this.registerMember();
                break;
            case 4:     // Update member
                System.out.println(getSeparator());
                System.out.println("Update member\n");
                this.updateMember();
                break;
            case 5:     // Remove member
                System.out.println(getSeparator());
                System.out.println("Remove member\n");
                this.removeMember();
                break;
            case 6:     // View member
                s.append("View member");
                this.viewMember();
                break;
            case 7:     // Register boat
                s.append("Register boat\n");
                this.registerBoat();
                break;
            case 8:     // Update boat
                s.append("Update boat\n");
                this.updateBoatMenu();
                break;
            case 9:     // Delete boat
                s.append("Delete boat\n");
                this.deleteBoat();
                break;
            default:    // Default
                return null;

        }

        s.append("Press Enter to continue...");
        return s.toString();
    }

}
