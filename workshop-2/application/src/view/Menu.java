package view;

public class Menu {
    private StringBuilder titleBar;

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

    public String mainMenuRoute(int menuChoice) {
        String s = "";
        switch (menuChoice) {
            case 0:     // Quit
                System.out.println("Quit");
                break;
            case 1:     // List members compact
                s = this.membersListCompact();
                break;
            case 2:     // List members verbose
                System.out.println("List members verbose");
                break;
            case 3:     // Register member
                System.out.println("Register member");
                break;
            case 4:     // Update member
                System.out.println("Update member");
                break;
            case 5:     // Remove member
                System.out.println("Remove member");
                break;
            case 6:     // View member
                System.out.println("View member");
                break;
            case 7:     // Register boat
                System.out.println("Register boat");
                break;
            case 8:     // Update boat
                System.out.println("Update boat");
                break;
            case 9:     // Delete boat
                System.out.println("Delete boat");
                break;
            default:    // Default
                break;

        }

        return s;
    }

    private String membersListCompact() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------------------\n");
        // TODO: Get each member here.
        sb.append("Kitty, id: 0, owns 2 boats.\n");
        sb.append("Popniten, id: 1, owns 1 boats.\n");
        sb.append("------------------------------------\n");

        return sb.toString();
    }
}
