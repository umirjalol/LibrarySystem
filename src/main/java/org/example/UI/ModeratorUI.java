package org.example.UI;

import org.example.server.entity.Book;
import org.example.server.entity.Booking;
import org.example.server.entity.enums.Status;
import org.example.server.payload.Result;
import org.example.server.service.ModeratorService;
import org.example.server.service.UserService;

import java.util.List;

import static org.example.UI.Constants.*;
import static org.example.UI.MainUI.paintRed;
import static org.example.UI.UserUI.showBooks;

public class ModeratorUI {
    public static void moderatorPage() {
        while (true) {
            System.out.println("\t\tModerator page");
            System.out.println("0 -> Exit");
            System.out.println("1 -> add books");
            System.out.println("2 -> add new book");
            System.out.println("3 -> search book");
            System.out.println("4 -> show bookings");
            System.out.println("5 -> change status");
            switch (SCANNER.nextLine()) {
                case "0" -> {
                    return;
                }
                case "1" -> addBooks();
                case "2" -> addNewBook();
                case "3" -> searchBook();
                case "4" -> ModeratorUI.showBookings();
                case "5" -> changeStatus();
                default -> System.out.println(paintRed(ERROR_INPUT));
            }
        }
    }

    private static void changeStatus() {
        showBookings();
        System.out.println("enter id ");
        long id = INT_SCANNER.nextLong();
        System.out.println("choose new status");
        System.out.println("1 -> NOT_TAKEN");
        System.out.println("2 -> TAKEN_AWAY");
        System.out.println("3 -> RETURNED");
        int anInt = INT_SCANNER.nextInt();
        Status status;
        if (anInt == 1) {
            status = Status.NOT_TAKEN;
        } else if (anInt == 2) {
            status = Status.TAKEN_AWAY;
        } else if (anInt == 3) {
            status = Status.RETURNED;
        } else {
            System.out.println("enter correct number");
            return;
        }
        Result result = ModeratorService.changeStatus(id, status);
        if (result.isSuccess()) {
            System.out.println(MainUI.paintGreen(result.getMessage()));
        } else {
            System.out.println(paintRed(result.getMessage()));
        }
    }

    private static void showBookings() {
        System.out.println("change status");
        System.out.println("1 -> NOT_TAKEN");
        System.out.println("2 -> TAKEN_AWAY");
        System.out.println("3 -> RETURNED");
        int anInt = INT_SCANNER.nextInt();
        Status status;
        if (anInt == 1) {
            status = Status.NOT_TAKEN;
        } else if (anInt == 2) {
            status = Status.TAKEN_AWAY;
        } else if (anInt == 3) {
            status = Status.RETURNED;
        } else {
            System.out.println("enter correct number");
            return;
        }
        List<Booking> bookings = ModeratorService.getBookings(status);
        UserUI.showBookings(bookings);
    }

    private static void searchBook() {
        System.out.println("enter name or author");
        String line = SCANNER.nextLine();
        List<Book> books = ModeratorService.searchBook(line);
        showBooks(books);
    }

    private static void addNewBook() {
        System.out.println("enter floor number");
        int floor = INT_SCANNER.nextInt();
        System.out.println("enter cupboard number");
        int cupboard = INT_SCANNER.nextInt();
        System.out.println("enter shelf number");
        int shelf = INT_SCANNER.nextInt();

        System.out.println("Enter name");
        String name = SCANNER.nextLine();

        System.out.println("Enter author ");
        String author = SCANNER.nextLine();

        System.out.println("Enter count");
        int count = INT_SCANNER.nextInt();
        Result result = ModeratorService.addNewBook(name, author, count, floor, cupboard, shelf);
        if (result.isSuccess()) {
            System.out.println(MainUI.paintGreen(result.getMessage()));
        } else {
            System.out.println(paintRed(result.getMessage()));
        }
    }

    private static void addBooks() {
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
            System.out.println("enter  book count");
            int bookCount = INT_SCANNER.nextInt();
            if (bookCount < 0) {
                System.out.println(paintRed("count must be positive"));
                return;
            }
            for (Book book : (List<Book>) result.getObject()) {
                if ( book.getId().equals(bookId)) {
                    book.setCount(book.getCount() + bookCount);
                    System.out.println(book);
                    break;
                }
            }
        } else
            System.out.println(paintRed(result.getMessage()));
    }
}
