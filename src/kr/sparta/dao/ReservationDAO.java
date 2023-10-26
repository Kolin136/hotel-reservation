package kr.sparta.dao;

import kr.sparta.domain.*;

import java.time.LocalDate;
import java.util.*;

public class ReservationDAO {
    // 예약 목록 조회

    private ArrayList<ManagementRoom> managementRoom = new ArrayList<>();

    private ArrayList<Reservation> reservationList = new ArrayList<>();
    private ArrayList<Customer> customerDataList = new ArrayList<>();
    LocalDate cal = LocalDate.now(); // 현재 요일 받기
    protected Hotel hotel;


    // 호텔 내부에 있는 방 정보 입력
    public void inputManagementRoom() {
        int month = this.cal.getDayOfMonth();
        int inputmonth = 0;
        switch (month) {
            case 1 -> inputmonth = 31;
            case 2 -> inputmonth = 29;
            case 3 -> inputmonth = 31;
            case 4 -> inputmonth = 30;
            case 5 -> inputmonth = 31;
            case 6 -> inputmonth = 30;
            case 7 -> inputmonth = 31;
            case 8 -> inputmonth = 31;
            case 9 -> inputmonth = 30;
            case 10 -> inputmonth = 31;
            case 11 -> inputmonth = 30;
            case 12 -> inputmonth = 31;
        }
        for (int i = 0; i < inputmonth; i++) {
            this.managementRoom.add(new ManagementRoom(new boolean[]{false, false, false}
                    ,new Room(new int[]{1, 2, 3},
                    new String[]{"Standard", "Superior", "Deluxe"},
                    new long[]{50000L, 100000L, 150000L})));
        }
        this.hotel.setManagementRoom(this.managementRoom);
    }


    // 예약 정보 출력
    public ArrayList<Reservation> getReservationList ()
    {
        return this.reservationList;
    }

    public void add (Reservation reservation)
    {
        this.reservationList.add(reservation);

    }


//    public Hotel getHotelInfo(Hotel hotel)
//    {
//        return hotel;
//    }

    // 방정보 출력
    public ManagementRoom returnRoomData(int index){
        return this.managementRoom.get(index);
    }

    //객체에 예약정보 입력
    public void inputReserveData ( int roomID, String roomSize,int fee,int day)
    {

    }

    //     고객은 자신의 예약 목록을 조회
    public Reservation getInquiry (String inquiry)
    {
        int index = 0;
        boolean flag = false;
        //String uuid
        for (int i = 0; i < this.reservationList.size(); i++) {
            if (inquiry.equals(this.reservationList.get(i).getReservationNumber())) {
                index = i;
                flag = true;
                break;
            }
        }
        if (flag)
            return reservationList.get(index);
        else return null;
    }

}
