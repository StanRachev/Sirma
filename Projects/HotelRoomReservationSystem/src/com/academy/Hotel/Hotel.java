package com.academy.Hotel;

import com.academy.Room.Room;

import java.util.*;

public class Hotel implements RoomManagement{
    private String hotelName;
    private Map<String, List<Room>> roomsAvailability;

    public Hotel(String hotelName) {
        this.hotelName = hotelName;
        roomsAvailability = new LinkedHashMap<>();
    }

    public Map<String, List<Room>> getRoomsAvailability() {
        return roomsAvailability;
    }

    @Override
    public void addRoom(Room room) {
        roomsAvailability.computeIfAbsent(room.getType().toString(), k -> new ArrayList<>());
        roomsAvailability.get(room.getType().toString()).add(room);
    }

    @Override
    public void removeRoom(Room room) {
        for (var roomsOfType : roomsAvailability.keySet()) {
            List<Room> rooms = roomsAvailability.get(roomsOfType);
            for (var r : rooms) {
                if (r.getNumber() == room.getNumber()) {
                    roomsAvailability.remove(r);
                }
            }
        }
    }

    @Override
    public void listRooms() {
        for (var entry : roomsAvailability.entrySet()) {
            System.out.println("Room type: " + entry.getKey());
            for (var room : entry.getValue()) {
                System.out.println("Room number: " + room.getNumber() + " - " + room.getPrice() + " BGN");
            }
        }
    }
}
