package view;

public class GUIConsole {
    private Menu menu;

    public GUIConsole() {
        menu = new Menu();
    }

    public void run() {
        System.out.println(menu.getTitleBar());
        System.out.println(menu.getMainMenu());

        int choice = Input.getInt();
        while(choice != 0) {
//            Input.clearBuffer();

            System.out.println(menu.mainMenuRoute(choice));
            Input.waitForEnterKey();
            System.out.println(menu.getSeparator() + menu.getMainMenu());
            choice = Input.getInt();

        }

    }

}
