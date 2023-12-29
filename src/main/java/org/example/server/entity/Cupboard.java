package org.example.server.entity;

public class Cupboard {
    {
        this.shelves = new Shelf[10];
        for (int i = 0; i < 10; i++) {
            this.shelves[i] = new Shelf();
        }
    }

    private final Shelf[] shelves;

    public Shelf getShelf(int shelf) {
        return shelves[shelf - 1];
    }
}
