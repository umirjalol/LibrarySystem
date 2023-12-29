package org.example.server.Utils;

import org.example.server.database.DataBase;
import org.example.server.entity.User;
import org.example.server.entity.enums.Role;

public class DataLoader {
    public static void load() {
        User moderator = new User();
        moderator.setName("Moderator");
        moderator.setEmail("moderator@gmail.com");
        moderator.setPassword("moderator1234");
        moderator.setRole(Role.MODERATOR);
        DataBase.users.add(moderator);
        
        User user = new User();
        user.setName("User");
        user.setEmail("user@gmail.com");
        user.setPassword("user1234");
        DataBase.users.add(user);


        User admin = new User();
        admin.setName("Admin");
        admin.setEmail("admin@gmail.com");
        admin.setPassword("admin1234");
        admin.setRole(Role.ADMIN);
        DataBase.users.add(admin);
    }
}
