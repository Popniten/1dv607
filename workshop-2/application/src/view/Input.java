package view;

import java.util.Scanner;

/**
 * A static class to simplify input.
 */
class Input {
    private static Scanner input = new Scanner(System.in);

    /**
     * Gets an integer input from the user.
     *
     * @return int The input from the user.
     */
    static int getInt() {
        int i = input.nextInt();
        clearBuffer();
        return i;
    }

    /**
     * A method to pause program until the
     * user presses the enter key.
     */
    static void waitForEnterKey() {
        try {
            System.in.read();
        } catch (Exception e) {

        }
    }

    /**
     * Gets a string input from the user.
     *
     * @return String The input from the user.
     */
    static String getString() {
        String s = input.nextLine();
        clearBuffer();
        return s;
    }

    /**
     * Clears the input buffer.
     */
    private static void clearBuffer() {
        input = new Scanner(System.in);
    }
}
