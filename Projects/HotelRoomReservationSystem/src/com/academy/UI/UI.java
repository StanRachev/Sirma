package com.academy.UI;

import com.academy.Hotel.Hotel;
import com.academy.Room.RoomTypeManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UI implements UserInterface {

    BufferedReader reader;
    Hotel hotel;
    boolean isOut;

    public UI(Hotel hotel) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.hotel = hotel;
        isOut = false;
    }

    public boolean isOut() {
        return isOut;
    }

    @Override
    public void greeting() {
        System.out.println("Hello!");
    }

    @Override
    public void menu() {
        pause(1);
        System.out.println(
                """
                1. View Rooms
                2. Book a Room
                3. Cancel Booking
                4. Exit
                """);
    }

    @Override
    public void chooseAction() {

        try {
            System.out.print("-> ");
            String choice = reader.readLine();

            switch (choice) {
                case "1":
                    viewRooms();
                    break;
                case "2":
                    bookRoom();
                    break;
                case "3":
                    cancelBooking();
                    break;
                default:
                    this.isOut = true;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewRooms() {
        RoomTypeManager roomTypeManager = new RoomTypeManager();

        for (var roomType : roomTypeManager.getRoomTypes()) {
            System.out.println("Room type: " + roomType.getType());
            System.out.println("Number of guests: " + roomType.getMaxOccupancy());
            System.out.println(Arrays.toString(roomType.getAmenities()));
            System.out.println();
        }
    }

    private void bookRoom() {
        System.out.println("To book a room choose one of the following: ");
        System.out.println();

        var hotelRooms = hotel.getRoomsAvailability();
        int cntr = 1;

        for (var roomType : hotelRooms.keySet()) {
            int price = hotelRooms.get(roomType).getFirst().getPrice();
            int availability = 0;

            for (var room : hotelRooms.get(roomType)) {
                if (!room.isBooked()) {
                    availability++;
                }
            }
            System.out.println(cntr++ + ". " + roomType + " - " + price + " BGN | Free: " + availability);
        }
        System.out.println();
    }

    private void cancelBooking() {

    }

    public static void pause(double seconds)
    {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {}
    }
}