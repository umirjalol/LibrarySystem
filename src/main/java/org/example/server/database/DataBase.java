package org.example.server.database;

import org.example.server.entity.Book;
import org.example.server.entity.Booking;
import org.example.server.entity.Library;
import org.example.server.entity.User;

import java.util.ArrayList;
import java.util.List;

public interface DataBase {
    List<User> users = new ArrayList<>();
    List<Booking> bookings = new ArrayList<>();
    List<Book> books = new ArrayList<>();
    Library library = new Library();
}
