package com.academy.Room;

import com.academy.Serialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class RoomManager {

    private List<Room> rooms;
    String path = "C:\\Users\\vival\\OneDrive\\Desktop\\Stan\\Java\\Sirma\\Homeworks_For_GitHub\\Sirma\\Projects\\HotelRoomReservationSystem\\savedFiles\\rooms.csv";

    public RoomManager() {
        rooms = loadFromFileRooms(path);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Room> rooms() {
        List<Room> listRooms = new ArrayList<>();
        listRooms.add(new Room(Type.SINGLE, 101, 100, 20, false));
        listRooms.add(new Room(Type.SINGLE, 102, 100, 20, false));
        listRooms.add(new Room(Type.DOUBLE, 201, 150, 50, false));
        listRooms.add(new Room(Type.DOUBLE, 202, 150, 50, false));
        listRooms.add(new Room(Type.DELUXE, 301, 250, 90, false));
        listRooms.add(new Room(Type.DELUXE, 302, 250, 90, false));
        listRooms.add(new Room(Type.SUITE, 401, 300, 130, false));
        return listRooms;
    }

    public void saveRoomsToFile() {
        List<Room> listRooms = rooms();
        Serialize.saveToFile(path, listRooms);
    }

    public List<Room> loadFromFileRooms(String fileName) {
        int cntr = 1;
        List<Room> list = new ArrayList<>();

        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            list = (List<Room>) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
