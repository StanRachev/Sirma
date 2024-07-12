package com.academy.Hotel;

import com.academy.Room.Room;
import com.academy.Room.RoomManager;

import java.util.List;

public class HotelManager {

    Hotel hotel;

    public HotelManager(Hotel hotel) {
        this.hotel = hotel;
    }

    public void populateHotelRooms() {
        RoomManager roomManager = new RoomManager();
        List<Room> rooms = roomManager.getRooms();

        for (var room : rooms) {
            this.hotel.addRoom(room);
        }
    }
}