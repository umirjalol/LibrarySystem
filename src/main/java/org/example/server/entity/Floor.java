package org.example.server.entity;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    {
        this.cupboards = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            this.cupboards.add(new Cupboard());
        }
    }

    private final List<Cupboard> cupboards;

    public int getCupboardSize() {
        return cupboards.size();
    }

    public Cupboard getCupboard(int cupboard) {
        return cupboards.get(cupboard);
    }

    public void addOneCupboard() {
        cupboards.add(new Cupboard());
    }

    public void deleteOneCupboard() {
        cupboards.remove(cupboards.size() - 1);
    }
}
