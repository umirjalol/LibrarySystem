package org.example.server.Utils;

import org.example.server.entity.User;


public class CommonUtils {
    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public static Long generateId() {
        return System.nanoTime();
    }

}
