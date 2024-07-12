package com.academy;

import com.academy.Hotel.Hotel;
import com.academy.Hotel.HotelManager;
import com.academy.UI.UI;

public class Main {
    public static void main(String[] args) {
//        RoomTypeManager roomTypeManager = new RoomTypeManager();
//        RoomManager roomManager = new RoomManager();
//        roomTypeManager.saveRoomTypesToFile();
//        roomManager.saveRoomsToFile();



        Hotel paradise = new Hotel("Paradise");
        HotelManager hotelManager = new HotelManager(paradise);
        hotelManager.populateHotelRooms();

        UI ui = new UI(paradise);
        ui.greeting();

        while (!ui.isOut()) {
            ui.menu();
            ui.chooseAction();
        }
    }
}