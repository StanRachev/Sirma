package com.academy.Room;

import com.academy.Serialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class RoomTypeManager {

    private List<RoomType> roomTypes;
    String path = "C:\\Users\\vival\\OneDrive\\Desktop\\Stan\\Java\\Sirma\\Homeworks_For_GitHub\\Sirma\\Projects\\HotelRoomReservationSystem\\savedFiles\\roomtypes.csv";

    public RoomTypeManager() {
        roomTypes = loadFromFileRoomType(path);
    }

    public List<RoomType> getRoomTypes() {
        return roomTypes;
    }

    public List<RoomType> roomTypes() {
        List<RoomType> listRoomTypes = new ArrayList<>();

        listRoomTypes.add(new RoomType(Type.SINGLE, 1,
                "TV", "Wi-Fi"));
        listRoomTypes.add(new RoomType(Type.DOUBLE, 2,
                "TV", "Wi-Fi", "Minibar"));
        listRoomTypes.add(new RoomType(Type.DELUXE, 3,
                "TV", "Wi-Fi", "Minibar", "Balcony"));
        listRoomTypes.add(new RoomType(Type.SUITE, 4,
                "TV", "Wi-Fi", "Minibar", "Balcony", "Kitchen"));

        return listRoomTypes;
    }

    public void saveRoomTypesToFile() {
        List<RoomType> listRoomTypes = roomTypes();
        Serialize.saveToFile(path, listRoomTypes);
    }

    public List<RoomType> loadFromFileRoomType(String fileName) {
        int cntr = 1;
        List<RoomType> list = new ArrayList<>();

        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            list = (List<RoomType>) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
