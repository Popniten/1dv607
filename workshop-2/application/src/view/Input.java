package view;

import java.util.Scanner;

public class Input {
    private static Scanner input = new Scanner(System.in);

    public static int getInt() {
        int i = input.nextInt();
        input = new Scanner(System.in);
        return i;
    }

    public static void waitForEnterKey() {
        try {
            System.in.read();
        } catch (Exception e) {

        }
    }

    public static String getString() {
        String s = input.nextLine();
        input = new Scanner(System.in);
        return s;
    }

    public static void clearBuffer() {
        input = new Scanner(System.in);
    }
}
