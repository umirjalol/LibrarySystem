package org.example.server.service;

import org.example.server.Utils.Checks;
import org.example.server.database.DataBase;
import org.example.server.entity.Book;
import org.example.server.entity.Booking;
import org.example.server.entity.enums.Status;
import org.example.server.payload.Result;
import org.example.server.repository.BookRepo;
import org.example.server.repository.BookingRepo;

import java.util.List;

import static org.example.server.Utils.Checks.*;

public class ModeratorService {
    public static Result addNewBook(String name, String author, int count, int floor, int cupboard, int shelf) {
        if (Checks.validFloor(floor)) {
            return new Result("floor not found", null, false);
        } else if (Checks.validBoard(cupboard, floor)) {
            return new Result("cupboard not found", null, false);
        } else if (shelf < 1 || shelf > 10) {
            return new Result("shelf not found", null, false);
        } else if (isValidStr(name)) {
            return new Result("name is not valid", null, false);
        } else if (isValidStr(author)) {
            return new Result("author is not valid", null, false);
        } else if (count < 0) {
            return new Result("count is not valid", null, false);
        }
        Book book = new Book(author, name, count);
        boolean b = DataBase.
                library.
                getFloor(floor).
                getCupboard(cupboard).
                getShelf(shelf).
                addBooks(book);
        if (!b)
            return new Result("shelf is full", null, false);
        BookRepo.save(book);
        return new Result("book successfully added", null, true);
    }

    public static List<Book> searchBook(String line) {
        return BookRepo.search(line);
    }

    public static List<Booking> getBookings(Status status) {
        return BookingRepo.findByStatus(status);
    }

    public static Result changeStatus(long id, Status status) {
        if (BookingRepo.changeStatus(id, status))
            return new Result("successfully changed", null, true);
        return new Result("booking not found", null, false);
    }
}
