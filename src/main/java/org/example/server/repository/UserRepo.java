package org.example.server.repository;

import org.example.server.entity.User;
import org.example.server.entity.enums.Role;

import java.util.List;

import static org.example.server.database.DataBase.users;

public class UserRepo {

    public static boolean isExistsByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email))
                return true;
        }
        return false;
    }

    public static void saveUser(User newUser) {
        users.add(newUser);
    }

    public static User findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email))
                return user;
        }
        return null;
    }

    public static List<User> grtAll() {
        return users;
    }

    public static boolean changeRole(long id, Role role) {
        for (User user : users) {
            if(user.getRole().equals(Role.ADMIN))
                continue;
            if (user.getId().equals(id)) {
                user.setRole(role);
                return true;
            }
        }
        return false;
    }
}
