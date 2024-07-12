package com.academy.Hotel;

import com.academy.Room.Room;

public interface RoomManagement {
    void addRoom(Room room);
    void removeRoom(Room room);
    void listRooms();
}
