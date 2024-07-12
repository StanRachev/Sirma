package com.academy.Room;

import java.io.Serializable;

public class RoomType implements Serializable {

    private Type type;
    private int maxOccupancy;
    private String[] amenities;

    public RoomType(Type type, int maxOccupancy, String... values) {
        this.type = type;
        this.maxOccupancy = maxOccupancy;
        this.amenities = values;
    }

    public Type getType() {
        return type;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public String[] getAmenities() {
        return amenities;
    }
}