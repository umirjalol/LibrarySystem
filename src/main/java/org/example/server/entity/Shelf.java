package org.example.server.entity;

public class Shelf {
    private final Book[] books = new Book[20];
    private int count;

    public boolean isFull() {
        return count == 20;
    }

    public Book[] getBooks() {
        return books;
    }

    public boolean addBooks(Book book) {
        if (isFull())
            return false;
        books[count++] = book;
        return true;
    }
}
