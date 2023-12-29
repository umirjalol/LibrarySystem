package org.example.UI;

import org.example.server.entity.Book;
import org.example.server.payload.Result;
import org.example.server.service.UserService;
import org.example.server.entity.Booking;
import org.example.server.entity.enums.Role;

import java.util.List;

import static org.example.UI.Constants.*;
import static org.example.UI.MainUI.paintRed;

public class UserUI {
    public static void cabinet(Role role) {
        switch (role) {
            case USER -> userPage();
            case ADMIN -> AdminUI.adminPage();
            case MODERATOR -> ModeratorUI.moderatorPage();
            default -> System.out.println("404 not found ");
        }
    }


    private static void userPage() {
        while (true) {
            System.out.println("\t\tUser page");
            System.out.println("0 -> Exit");
            System.out.println("1 -> Show history");
            System.out.println("2 -> book booking");
            System.out.println("3 -> booked books");
            switch (SCANNER.nextLine()) {
                case "0" -> {
                    return;
                }
                case "1" -> showHistory();
                case "2" -> bookBooking();
                case "3" -> bookedBooks();
                default -> System.out.println(paintRed(ERROR_INPUT));
            }
        }
    }

    private static void bookedBooks() {
        List<Booking> history = UserService.bookedBooks();
        showBookings(history);
    }

    private static void bookBooking() {
        System.out.println("enter floor number");
        int floor = INT_SCANNER.nextInt();
        System.out.println("enter cupboard number");
        int cupboard = INT_SCANNER.nextInt();
        System.out.println("enter shelf number");
        int shelf = INT_SCANNER.nextInt();
        Result result = UserService.gatBooks(floor, cupboard, shelf);
        if (result.isSuccess()) {
            showBooks((List<Book>) result.getObject());
            System.out.println("enter  book id");
            long bookId = INT_SCANNER.nextLong();
            Result result1 = UserService.booking(bookId);
            if (result1.isSuccess()) {
                System.out.println(result1.getMessage());
                showBookings(List.of((Booking) result1.getObject()));
            } else
                System.out.println(paintRed(result.getMessage()));
        } else
            System.out.println(paintRed(result.getMessage()));
    }

    public static void showBooks(List<Book> books) {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("|    id              |       author       |        name        |count|");
        for (Book book : books) {
            if (book != null) {
                System.out.println(book);
            }
        }
        System.out.println("----------------------------------------------------------------------");

    }

    private static void showHistory() {
        List<Booking> history = UserService.showHistory();
        showBookings(history);
    }

    public static void showBookings(List<Booking> bookings) {
        System.out.println("-------------------------------------------");
        System.out.println("|    ID              |   expired time     |");
        for (Booking booking : bookings) {
            if (booking != null) {
                System.out.println(booking);
            }
        }
        System.out.println("-------------------------------------------");
    }
}
