package org.example.UI;

import static org.example.UI.Constants.*;

public class MainUI {
    public static void homePage() {
        while (true) {
            System.out.println("\t\tLibrary System");
            System.out.println("0 -> Exit");
            System.out.println("1 -> SignIn");
            System.out.println("2 -> SignUp");
            switch (SCANNER.nextLine()) {
                case "0" -> {
                    return;
                }
                case "1" -> AuthUI.signIn();
                case "2" -> AuthUI.signUp();
                default -> System.out.println(paintRed(ERROR_INPUT));
            }
        }
    }

    public static String paintRed(String text) {
        return ANSI_RED + text + ANSI_RESET;
    }

    public static String paintGreen(String text) {
        return ANSI_GREEN + text + ANSI_RESET;
    }
}
