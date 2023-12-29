package org.example.server.Utils;

import org.example.server.database.DataBase;

public class Checks {
    public static boolean isValidStr(String str) {
        return str.isEmpty() || str.isBlank();
    }

    public static boolean validEmail(String email) {
        return !email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
    }

    public static boolean validPassword(String password) {
        return !password.matches("^(?=.*[a-z])(?=.*\\d)[A-Za-z\\d#$@!%&*?]{8,}$");
    }

    public static boolean validFloor(int floor) {
        return floor <= 0 || floor >= DataBase.library.getFloorSize();
    }

    public static boolean validBoard(int cupboard, int floor) {
        return cupboard <= 0 ||
                cupboard >= DataBase
                        .library
                        .getFloor(floor)
                        .getCupboardSize();
    }
}
