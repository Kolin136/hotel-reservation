package kr.sparta.dao;

import kr.sparta.domain.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class ReservationDAO {
    // 예약 목록 조회

    private ArrayList<ManagementRoom> managementRoom = new ArrayList<>();

    private ArrayList<Reservation> reservationList = new ArrayList<>();
    private ArrayList<Customer> customerDataList = new ArrayList<>();
    LocalDate cal = LocalDate.now(); // 현재 요일 받기
    LocalDateTime localDateTime = LocalDateTime.now(); // UTC
    private Hotel hotel = new Hotel(managementRoom,reservationList,50000000);


    // 호텔 내부에 있는 방 정보 입력
    public int inputManagementRoom() {
        int month = this.cal.getMonthValue();
        int inputmonthofDay = 0;
        switch (month) {
            case 1 -> inputmonthofDay = 31;
            case 2 -> inputmonthofDay = 29;
            case 3 -> inputmonthofDay = 31;
            case 4 -> inputmonthofDay = 30;
            case 5 -> inputmonthofDay = 31;
            case 6 -> inputmonthofDay = 30;
            case 7 -> inputmonthofDay = 31;
            case 8 -> inputmonthofDay = 31;
            case 9 -> inputmonthofDay = 30;
            case 10 -> inputmonthofDay = 31;
            case 11 -> inputmonthofDay = 30;
            case 12 -> inputmonthofDay = 31;
        }
        for (int i = 0; i < inputmonthofDay; i++) {
            this.managementRoom.add(new ManagementRoom(new boolean[]{false, false, false}
                    ,new Room(new int[]{1, 2, 3},
                    new String[]{"Standard", "Superior", "Deluxe"},
                    new long[]{50000L, 100000L, 150000L})));
        }
        this.hotel.setManagementRoom(this.managementRoom);
        return inputmonthofDay;
    }

    // 호텔 정보
    public Hotel getHotel(){
        return hotel;
    }

    // 예약 정보 출력
    public ArrayList<Reservation> getReservationList ()
    {
        return this.reservationList;
    }


    // 방정보 출력
    public ArrayList<ManagementRoom> getRoomData(){
        return this.managementRoom;
    }

    // 방 가격 get메서드
    public long roomgetPrice(int index)
    {
        return managementRoom.get(0).getRoomList().getFee()[index-1];
    }

    // uuid random 생성 메서드
    public String uuidCreate(){
        return UUID.randomUUID().toString().substring(0,8);
    }

    //Reservation 객체에 예약정보 입력
    public String inputReserveData ( int roomID, String customerName, String customerPhoneNumber,int day ,long cash)
    {
        String uuid = uuidCreate();
        hotel.getReservationList().add(new Reservation(roomID, customerName, customerPhoneNumber, localDateTime, day, uuid));
        this.customerDataList.add(new Customer(customerName,customerPhoneNumber,cash,uuid));

        hotel.setAssets(cash);
        hotel.getManagementRoom().get(day-1).getReserveDateFlag()[roomID-1] = true;
        this.hotel.setReservationList(this.reservationList);
        return uuid;
    }

    //     고객은 자신의 예약 목록을 조회
    public Reservation getInquiry (String uuid)
    {
        int index = 0;
        boolean flag = false;
        //String uuid
        for (int i = 0; i < hotel.getReservationList().size(); i++) {
            if (uuid.equals(hotel.getReservationList().get(i).getReservationNumber())) {
                index = i;
                flag = true;
                break;
            }
        }
        return flag? hotel.getReservationList().get(index):null;
    }

    // 예약제거
    public Customer reservationRemove(String uuid){
        String name= "";
        String phoneNumber ="";
        long cash = 0;
        long roomcash=0;
        boolean removeHotelUserFlag = false;
        boolean removeUserFlag = false;
        Customer customer = null;
        int hotelListSize = hotel.getReservationList().size();
        for (int i = 0; i < hotelListSize; i++) {
            if(hotel.getReservationList().get(i).getReservationNumber().equals(uuid))
            {
                hotel.getManagementRoom().get(hotel.getReservationList().get(i).getAccommodationDay())
                        .getReserveDateFlag()[hotel.getReservationList().get(i).getRoomId()-1] = false;



                roomcash = hotel.getManagementRoom().get(i).getRoomList().getFee()[hotel.getReservationList().get(i).getRoomId()-1];
                hotel.getReservationList().remove(i);
                removeHotelUserFlag = true;
            }
            if(i < customerDataList.size()){
                if(customerDataList.get(i).equals(uuid))
                {
                    name = customerDataList.get(i).getName();
                    phoneNumber = customerDataList.get(i).getPhoneNumber();
                    cash = customerDataList.get(i).getCash() +roomcash;
                    customerDataList.remove(i);
                    removeUserFlag = true;
                    hotelListSize--;
                    i--;
                }


            }
        }
        if(removeHotelUserFlag && removeUserFlag)
             customer = new Customer(name, phoneNumber, cash, uuid);
        return customer;
    }


}
