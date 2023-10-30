package kr.sparta.domain;


public class Room {

    private int[] roomID = new int[3]; // {1,2,3} 룸 번호
    private String[] roomSize = new String[3]; //{"Standard", "Superior", "Deluxe"} // 방 size
    private long[] fee = new long[3]; // {50000L,100000L,150000L} // 요금

    public Room(int[] roomID,String[] roomSize, long[] fee){
        for (int i = 0; i <3; i++) {
            this.roomID[i] = roomID[i];
            this.roomSize[i] = roomSize[i];
            this.fee[i]= fee[i];
        }

    }

    public int[] getRoomID() {
        return roomID;
    }
    public void setRoomID(int[] roomID) {
        this.roomID = roomID;
    }
    public String[] getRoomSize() {
        return roomSize;
    }
    public void setRoomSize(String[] roomSize) {
        this.roomSize = roomSize;
    }
    public long[] getFee() {
        return fee;
    }
    public void setFee(long[] fee) {
        this.fee = fee;
    }
}
