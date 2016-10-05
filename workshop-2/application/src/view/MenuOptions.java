package view;

import model.Boat;
import model.Member;
import model.Registry;
import java.util.ArrayList;

/**
 * A class that handles the main menus options.
 */
class MenuOptions {
    private Registry registry = new Registry();

    /**
     * Asks user to input information about a
     * new member and registers that member.
     */
    void registerMember() {
        System.out.print("Enter first name: ");
        String fName = Input.getString();
        System.out.print("Enter last name: ");
        String lName = Input.getString();
        System.out.print("Enter SSN: ");
        String ssn = Input.getString();

        try {
            registry.addMember(new Member(fName, lName, ssn));
            System.out.println("Created member " + fName + " " + lName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Update an existing members information.
     */
    void updateMember() {
        System.out.print("Enter SSN of member to update: ");
        String ssn = Input.getString();

        Member m = registry.getMember(ssn);

        // If members exist, ask for new information.
        if (m != null) {
            System.out.print("Enter first name (" + m.getFirstname() + "): ");
            String fName = Input.getString();
            System.out.print("Enter last name (" + m.getLastname() + "): ");
            String lName = Input.getString();

            // Use existing name if name fields are empty.
            if (!isEmpty(fName)) {
                m.setFirstname(fName);
            }

            if(!isEmpty(lName)) {
                m.setLastname(lName);
            }

            try {
                registry.updateMember(m);
                System.out.println("Updated member " + m.getFirstname() + " " + m.getLastname());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("That member does not exist!");
        }
    }

    /**
     * Removes an existing member from the registry.
     */
    void removeMember() {
        System.out.print("Enter SSN of member to delete: ");
        String ssn = Input.getString();

        Member m = registry.getMember(ssn);

        // If member exists, remove after confirmation.
        if (m != null) {
            System.out.print("Are you sure you want to do this (y/n)? ");
            String answer = Input.getString();

            if (answer.equals("y")) {
                registry.removeMember(m);
                System.out.println("Deleting member " + m.getFirstname() + " " + m.getLastname());
            }
        } else {
            System.out.println("That member does not exist!");
        }
    }

    /**
     * Outputs a compact list of all existing members
     * in the boat club.
     */
    void listMembersCompact() {
        ArrayList<Member> members = registry.getMembers();

        for (Member m : members) {
            System.out.println(
                m.getFirstname()
                + " " + m.getLastname()
                + " (" + m.getSSN()
                + "), number of boats: "
                + m.getBoats().size() + "."
            );
        }
    }

    /**
     * Outputs a verbose list of all existing
     * members in the boat club.
     */
    void listMembersVerbose() {
        ArrayList<Member> members = registry.getMembers();

        for (Member m : members) {
            this.printMember(m);
        }
    }

    /**
     * Prints out an existing members information after
     * asking for a social security number.
     */
    void viewMember() {
        System.out.print("Enter SSN of member to view: ");
        String ssn = Input.getString();

        Member m = registry.getMember(ssn);

        if (m != null) {
            this.printMember(m);
        } else {
            System.out.println("That member does not exist!");
        }
    }

    /*
     * Helper function to print a members information.
     */
    private void printMember(Member m) {
        System.out.println();
        ArrayList<Boat> list = m.getBoats();
        System.out.println(m.getFirstname() + " " + m.getLastname() + " (" + m.getSSN() + ")");
        System.out.println("  Boats: " + m.getBoats().size());
        for (Boat b : list) {
            System.out.println("    " + b.getName() + ", " + b.getType() + ", " + b.getLength() + " cm.");
        }
    }

    /**
     * Registers a new boat to an existing member.
     */
    void registerBoat() {
        System.out.print("Enter owner SSN: ");
        String ssn = Input.getString();
        Member m = registry.getMember(ssn);

        // If member exists, get new boat information and register it.
        if (m != null) {
            System.out.print("Enter boat name: ");
            String bName = Input.getString();
            System.out.print("Enter boat length (in cm): ");
            int bLength = Input.getInt();
            System.out.println("Choose boat type: ");

            Boat.BoatType[] boatTypes = Boat.BoatType.values();

            for (int i = 0; i < boatTypes.length; i++) {
                System.out.println("  " + (i + 1) + ". " + boatTypes[i]);
            }

            System.out.print("Enter choice: ");
            int bType = Input.getInt();

            try {
                registry.addBoat(ssn, new Boat(boatTypes[bType - 1], bLength, bName));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Not a valid boat type.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("That member does not exist!");
        }
    }

    /**
     * Updates the information on an existing boat.
     *
     * @param b The boat to update.
     */
    void updateBoat(Boat b) {
        if (b != null) {
            boolean correctInput = true;
            System.out.print("Enter new boat name (" + b.getName() + "): ");
            String bName = Input.getString();
            System.out.print("Enter new boat length (" + b.getLength() + "): ");
            String bLength = Input.getString();
            System.out.println("Choose boat type: ");

            Boat.BoatType[] boatTypes = Boat.BoatType.values();

            // Print out the available boat types.
            for (int i = 0; i < boatTypes.length; i++) {
                System.out.println("  " + (i + 1) + ". " + boatTypes[i]);
            }

            System.out.print("Enter choice: ");
            int bType = Input.getInt();

            b.setType(boatTypes[bType - 1]);

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

            if (correctInput) {
                registry.updateBoat(b);
            } else {
                System.out.println("Something went wrong, check your input.");
            }
        } else {
            System.out.println("Boat does not exist!");
        }
    }

    /**
     * Deletes a boat from a user.
     *
     * @param b The boat to delete.
     */
    void deleteBoat(Boat b) {
        if (b != null) {
            registry.removeBoat(b);
        } else {
            System.out.println("Boat does not exist!");
        }
    }

    /**
     * A method to choose a boat from a member to
     * either update or delete.
     *
     * @param action The action to perform (used for output).
     * @return Boat The boat to process.
     */
    Boat chooseBoat(String action) {
        System.out.print("Enter owner SSN: ");
        String ssn = Input.getString();
        Member m = registry.getMember(ssn);
        Boat b = null;

        if (m != null) {
            ArrayList<Boat> boats = m.getBoats();

            if (boats.size() > 0) {
                for (int i = 0; i < boats.size(); i++) {
                    System.out.println((i + 1) + ": " + boats.get(i).getName());
                }

                System.out.print("Which boat do you wish to " + action + "? ");
                try {
                    b = boats.get(Input.getInt() - 1);
                } catch (Exception e) {
                    // TODO: MESSAGE!
                }
            } else {
                System.out.println("That member does not own any boats.");
            }
        } else {
            System.out.println("That member does not exist!");
        }

        return b;
    }

    /*
     * Checks if a string is empty or not.
     */
    private boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }
}
