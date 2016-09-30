package view;

public class GUIConsole {
    private Menu menu;
    private Input input;

    public GUIConsole() {
        menu = new Menu();
        input = new Input();
    }

    public void run() {
        System.out.println(menu.getTitleBar());
        System.out.println(menu.getMainMenu());
        System.out.println(menu.mainMenuRoute(input.getInput()));
    }

}
