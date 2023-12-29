package org.example.server.service;

import org.example.server.Utils.Checks;
import org.example.server.Utils.CommonUtils;
import org.example.server.database.DataBase;
import org.example.server.entity.Book;
import org.example.server.entity.Booking;
import org.example.server.entity.User;
import org.example.server.payload.Result;
import org.example.server.repository.BookRepo;
import org.example.server.repository.BookingRepo;
import org.example.server.repository.UserRepo;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UserService {
    public static List<Booking> showHistory() {
        return BookingRepo.findExpiredBookings(
                CommonUtils.getCurrentUser());
    }

    public static Result gatBooks(int floor, int cupboard, int shelf) {
        if (Checks.validFloor(floor)) {
            return new Result("floor not found", null, false);
        } else if (Checks.validBoard(cupboard, floor)) {
            return new Result("cupboard not found", null, false);
        } else if (shelf < 1 || shelf > 10) {
            return new Result("shelf not found", null, false);
        }
        return new Result("",
               Arrays.stream(DataBase.
                        library.
                        getFloor(floor).
                        getCupboard(cupboard).
                        getShelf(shelf).
                        getBooks()).filter(Objects::nonNull)
                       .toList(), true);
    }

    public static Result booking(long bookId) {
        Book book = BookRepo.findById(bookId);
        if (book == null)
            return new Result("book not found", null, false);
        book.setCount(book.getCount() + 1);
        Booking booking =
                new Booking(bookId,
                        CommonUtils.getCurrentUser().
                                getId());
        BookingRepo.save(booking);
        return new Result(
                "book successfully booking",
                booking, true);
    }

    public static List<Booking> bookedBooks() {
        return BookingRepo.findNonExpiredBookings(
                CommonUtils.getCurrentUser());
    }

    public static List<User> getAll() {
        return UserRepo.grtAll();
    }
}
