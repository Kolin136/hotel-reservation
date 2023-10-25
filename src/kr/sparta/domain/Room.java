package kr.sparta.domain;

public class Room {

    public enum roomSizeType{
        standard,
        superior,
        deluxe
    }
    private roomSizeType roomSize; // 방 size
    private int roomID; // 룸 번호
    private int fee; // 요금
    private boolean reserved; // 예약 완료 check

    public Room(roomSizeType roomSize, int roomID, int fee, boolean reserved){
        this.roomSize = roomSize;
        this.roomID = roomID;
        this.fee = fee;
        this.reserved = reserved;
    }

    public roomSizeType getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(roomSizeType roomSize) {
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
