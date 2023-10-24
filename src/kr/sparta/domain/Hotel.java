package kr.sparta.domain;

import java.util.ArrayList;

public class Hotel {

    private ArrayList<Room> roomList;

    //private ArrayList<Reservation> reservationList;

    private int assets;

    public void Hotel(ArrayList<Room> roomList , int assets){


    }

    public ArrayList<Room> getRoomList() {
        return roomList;
    }
    public void setRoomList(ArrayList<Room> roomList) {
        this.roomList = roomList;
    }
    public int getAssets() {
        return assets;
    }
    public void setAssets(int assets) {
        this.assets = assets;
    }
}
