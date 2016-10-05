package view;

public class GUIConsole {
    private MainMenu menu;

    public GUIConsole() {

        menu = new MainMenu();
    }

    public void run() {
        menu.printTitleBar();
        while(menu.applicationIsRunning()) {
            menu.printMainMenu();

            // TODO: Split up MenuOptions methods for easier/clearer use.
            // TODO: Main loop in MenuOptions-class?
            // TODO: GUIConsole content could go into main?
            // TODO: MenuOptions should be called GUIConsole?

            // TODO: MainMenu class.
            // TODO: Input class error handling.
            // TODO: MenuRouter class.
            // TODO: Output/ListOutput/SubMenu class.
        }
    }

}
