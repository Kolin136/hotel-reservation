package kr.sparta.domain;

import java.util.ArrayList;

public class Hotel {

    private ArrayList<Room> roomList; // 룸 정보 리스트
    private ArrayList<Reservation> reservationList; // 예약 정보 리스트
    protected ArrayList<ManagementRoom> managementRoom;

    private long assets; // 자산 5천마넌 시작
    public Hotel(ArrayList<ManagementRoom> managementRoom, ArrayList<Reservation> reservationList, long assets){
        this.managementRoom = managementRoom;
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
        return reservationList;
    }

    public void setReservationList(ArrayList<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public ArrayList<ManagementRoom> getManagementRoom() {
        return managementRoom;
    }

    public void setManagementRoom(ArrayList<ManagementRoom> managementRoom) {
        this.managementRoom = managementRoom;
    }

    public long getAssets() {
        return assets;
    }

    public void setAssets(long assets) {
        this.assets += assets;
    }
}
