package org.example.server.repository;

import org.example.server.database.DataBase;
import org.example.server.entity.Book;

import java.util.List;

public class BookRepo {
    public static Book findById(long bookId) {
        for (Book book : DataBase.books) {
            if (book.getId().equals(bookId))
                return book;
        }
        return null;
    }

    public static void save(Book book) {
        DataBase.books.add(book);
    }

    public static List<Book> search(String line) {
        return DataBase.books.
                stream().
                filter(
                        b -> b.getName().equalsIgnoreCase(line) ||
                                b.getAuthor().equalsIgnoreCase(line)
                ).toList();
    }
}
