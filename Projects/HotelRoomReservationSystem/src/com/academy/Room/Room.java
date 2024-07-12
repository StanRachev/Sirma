package com.academy.Room;

import java.io.Serializable;

public class Room implements Serializable {
    private Type type;
    private int number;
    private int price;
    private float cancellationFee;
    private boolean isBooked;

    public Room(Type type, int number, int price, float cancellationFee, boolean isBooked) {
        this.type = type;
        this.number = number;
        this.price = price;
        this.cancellationFee = cancellationFee;
        this.isBooked = isBooked;
    }

    public Type getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        return price;
    }

    public float getCancellationFee() {
        return cancellationFee;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
