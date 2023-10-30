package kr.sparta.domain;


public class ManagementRoom {

    final boolean[] reserveDateFlag = new boolean[3]; //예약 확인 false 예약x ture 예약o
    protected Room roomList; // 룸 정보

    public ManagementRoom(boolean[] reserveDateFlag, Room roomList)
    {
        for (int i = 0; i < 3; i++) {
            this.reserveDateFlag[i] = reserveDateFlag[i];
        }
        this.roomList = roomList;
    }

    public boolean[] getReserveDateFlag() {
        return reserveDateFlag;
    }

    public Room getRoomList() {
        return roomList;
    }

    public void setRoomList(Room roomList) {
        this.roomList = roomList;
    }
}
