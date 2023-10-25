package kr.sparta.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Hotel {

    private ArrayList<Room> roomList; // 룸 정보 리스트

    private ArrayList<Reservation> reservationList; // 예약 정보 리스트

    private int assets; // 자산

    public void Hotel(ArrayList<Room> roomList, ArrayList<Reservation> reservationList, int assets){
        this.roomList = roomList;
        this.reservationList = reservationList;
        this.assets = assets;
    }

    public ArrayList<Room> getRoomList() {
        return roomList;
    }
    public void setRoomList(ArrayList<Room> roomList) {
        this.roomList = roomList;
    }
    public ArrayList<Reservation> getReservationList() {
        return this.reservationList;
    }
    public void setReservationList(ArrayList<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
    public int getAssets() {
        return assets;
    }
    public void setAssets(int assets) {
        this.assets = assets;
    }

}
