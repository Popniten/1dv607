package view;

/**
 * A class that handles the printing and operations
 * of the main menu in the Member Registry application.
 */
public class GUIConsole {
    private MenuOptions options = new MenuOptions();
    private boolean appRunning = true;

    /**
     * Starts the console application.
     */
    public void run() {
        this.printTitleBar();
        while(this.applicationIsRunning()) {
            this.printMainMenu();
        }
    }

    /*
     * Prints a 'graphical' title bar.
     */
    private void printTitleBar() {
        StringBuilder titleBar = new StringBuilder();
        titleBar.append("####################################\n");
        titleBar.append("# The Happy Pirate Member Registry #\n");
        titleBar.append("####################################\n");
        System.out.println(titleBar);
    }

    /*
     * Prints the main menu and waits for user
     * input.
     */
    private void printMainMenu() {
        StringBuilder mainMenu = new StringBuilder();
        mainMenu.append("MAIN MENU\n");
        mainMenu.append("1. List members (compact)\n");
        mainMenu.append("2. List members (verbose)\n");
        mainMenu.append("3. Register member\n");
        mainMenu.append("4. Update member\n");
        mainMenu.append("5. Remove member\n");
        mainMenu.append("6. View member\n");
        mainMenu.append("7. Register boat\n");
        mainMenu.append("8. Update boat\n");
        mainMenu.append("9. Delete boat\n");
        mainMenu.append("\n");
        mainMenu.append("0. Exit application\n");

        System.out.println(mainMenu);

        System.out.print("Choose, then press enter: ");
        this.mainMenuRoute(Input.getInt());
    }

    /*
     * Lets the calling object check if the user
     * has asked to quit the application.
     *
     * @return False If the user the application
     *         should not continue to run.
     */
    private boolean applicationIsRunning() {
        return this.appRunning;
    }

    /*
     * Takes the users input choice and routes
     * to the appropriate action.
     */
    private void mainMenuRoute(int menuChoice) {

        switch (menuChoice) {
            case 0:     // Quit
                this.appRunning = false;
                System.out.println("Quitting application...");
                break;
            case 1:     // List members compact
                this.printSeparator();
                System.out.println("MEMBER LIST (compact)");
                options.listMembersCompact();
                break;
            case 2:     // List members verbose
                this.printSeparator();
                System.out.println("MEMBER LIST (verbose)");
                options.listMembersVerbose();
                break;
            case 3:     // Register member
                this.printSeparator();
                System.out.println("REGISTER MEMBER");
                options.registerMember();
                break;
            case 4:     // Update member
                this.printSeparator();
                System.out.println("UPDATE MEMBER");
                options.updateMember();
                break;
            case 5:     // Remove member
                this.printSeparator();
                System.out.println("REMOVE MEMBER");
                options.removeMember();
                break;
            case 6:     // View member
                this.printSeparator();
                System.out.println("VIEW MEMBER");
                options.viewMember();
                break;
            case 7:     // Register boat
                this.printSeparator();
                System.out.println("REGISTER BOAT");
                options.registerBoat();
                break;
            case 8:     // Update boat
                this.printSeparator();
                System.out.println("UPDATE BOAT");
                options.updateBoat(options.chooseBoat("update"));
                break;
            case 9:     // Delete boat
                this.printSeparator();
                System.out.println("DELETE BOAT");
                options.deleteBoat(options.chooseBoat("delete"));
                break;
            default:    // Default
                this.printSeparator();
                System.out.println("Not a valid menu choice...");
                break;

        }

        System.out.println("\nPress Enter to continue...");
        Input.waitForEnterKey();
        printSeparator();
    }

    /*
     * Prints a separator between menu
     * option outputs.
     */
    private void printSeparator() {
        System.out.println("\n------------------------------------");
    }
}
