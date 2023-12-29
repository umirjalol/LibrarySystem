package org.example.server.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
    {
        this.floorList = new ArrayList<>(4);
        this.floorList.add(new Floor());
        this.floorList.add(new Floor());
        this.floorList.add(new Floor());
        this.floorList.add(new Floor());
    }

    private final List<Floor> floorList;

    public int getFloorSize() {
        return floorList.size();
    }

    public Floor getFloor(int i) {
        return floorList.get(i);
    }

    public void addOneFloor() {
        floorList.add(new Floor());
    }

    public void deleteOneFloor() {
        floorList.remove(floorList.size() - 1);
    }
}
