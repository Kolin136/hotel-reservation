package kr.sparta.domain;

public class Room {
    private int roomSize;
    private int roomID;
    private int fee;
    private boolean reserved;

    public Room(int roomSize, int roomID, int fee, boolean reserved){
        this.roomSize = roomSize;
        this.roomID = roomID;
        this.fee = fee;
        this.reserved = reserved;
    }

    public int getRoomSize() {
        return roomSize;
    }
    public void setRoomSize(int roomSize) {
        this.roomSize = roomSize;
    }
    public int getRoomID() {
        return roomID;
    }
    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }
    public int getFee() {
        return fee;
    }
    public void setFee(int fee) {
        this.fee = fee;
    }
    public boolean isReserved() {
        return reserved;
    }
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}
