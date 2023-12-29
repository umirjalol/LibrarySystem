package org.example.UI;

import org.example.server.entity.User;
import org.example.server.entity.enums.Role;
import org.example.server.payload.Result;

import java.util.List;

import static org.example.UI.Constants.*;
import static org.example.UI.MainUI.paintRed;
import static org.example.server.service.AdminService.*;
import static org.example.server.service.UserService.getAll;

public class AdminUI {
    public static void adminPage() {
        while (true) {
            System.out.println("\t\tAdmin page");
            System.out.println("0 -> Exit");
            System.out.println("1 -> assign as moderator");
            System.out.println("2 -> assign as user");
            System.out.println("3 -> show uses");
            System.out.println("4 -> resize library");
            switch (SCANNER.nextLine()) {
                case "0" -> {
                    return;
                }
                case "1" -> assignAsModerator();
                case "2" -> assignAsUser();
                case "3" -> showUsers();
                case "4" -> resizeLibrary();
                default -> System.out.println(paintRed(ERROR_INPUT));
            }
        }

    }

    private static void resizeLibrary() {
        while (true) {
            System.out.println("\t\tAdmin page");
            System.out.println("0 -> Exit");
            System.out.println("1 -> add a floor");
            System.out.println("2 -> delete a floor");
            System.out.println("3 -> add a cupboard");
            System.out.println("4 -> delete a cupboard");
            switch (SCANNER.nextLine()) {
                case "0" -> {
                    return;
                }
                case "1" -> {
                    addAFloor();
                    System.out.println("successfully added");
                }
                case "2" -> {
                    deleteAFloor();
                    System.out.println("successfully deleted");
                }
                case "3" -> {
                    System.out.println("enter floor number");
                    int floor = INT_SCANNER.nextInt();
                    Result result = addACupboard(floor);
                    if (result.isSuccess()) {
                        System.out.println(MainUI.paintGreen(result.getMessage()));
                    } else {
                        System.out.println(paintRed(result.getMessage()));
                    }
                }
                case "4" -> {
                    System.out.println("enter floor number");
                    int floor = INT_SCANNER.nextInt();
                    Result result = deleteACupboard(floor);
                    if (result.isSuccess()) {
                        System.out.println(MainUI.paintGreen(result.getMessage()));
                    } else {
                        System.out.println(paintRed(result.getMessage()));
                    }
                }
                default -> System.out.println(paintRed(ERROR_INPUT));
            }
        }


    }

    private static void assignAsUser() {
        showUsers();
        System.out.println("enter id");
        long id = INT_SCANNER.nextLong();
        Result result = assignAs(Role.USER, id);
        if (result.isSuccess()) {
            System.out.println(MainUI.paintGreen(result.getMessage()));
        } else {
            System.out.println(paintRed(result.getMessage()));
        }

    }

    private static void assignAsModerator() {
        showUsers();
        System.out.println("enter id");
        long id = INT_SCANNER.nextLong();
        Result result = assignAs(Role.MODERATOR, id);
        if (result.isSuccess()) System.out.println(MainUI.paintGreen(result.getMessage()));
        else {
            System.out.println(paintRed(result.getMessage()));
        }

    }

    private static void showUsers() {
        List<User> users = getAll();
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("|    id           |       name         |       email        |   role   |");
        for (User user : users) {
            if (user != null) {
                System.out.println(user);
            }
        }
        System.out.println("-----------------------------------------------------------------------------");

    }
}