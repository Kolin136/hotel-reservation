package kr.sparta.dao;

import kr.sparta.domain.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class ReservationDAO {
    // 예약 목록 조회


    private static ArrayList<ManagementRoom> managementRoom = new ArrayList<>(); // 방을 관리하는 객체

    private static ArrayList<Reservation> reservationList = new ArrayList<>(); // 예약 담당 객체
    private static ArrayList<Customer> customerDataList = new ArrayList<>(); // 고객 정보 객체
    LocalDate cal = LocalDate.now(); // 현재 요일 받기
    LocalDateTime localDateTime; // UTC
    private static Hotel hotel = new Hotel(managementRoom, reservationList, 50000000); // 호텔 객체



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
        for (int i = 0; i < inputmonthofDay; i++) { // 방정보 입력
            managementRoom.add(new ManagementRoom(new boolean[]{false, false, false}
                    , new Room(new int[]{1, 2, 3},
                    new String[]{"Standard", "Superior", "Deluxe"},
                    new long[]{50000L, 100000L, 150000L})));
        }
        hotel.setManagementRoom(managementRoom);
        return inputmonthofDay;
    }

    // 호텔 정보
    public Hotel getHotel() {
        return hotel;
    }

    // 예약 정보
    public ArrayList<Reservation> getReservationList() {
        return reservationList;
    }

    // 방정보
    public ArrayList<ManagementRoom> getRoomData() {
        return managementRoom;
    }

    // 방 가격 get메서드
    public long getRoomPrice(int index) {
        return managementRoom.get(0).getRoomList().getFee()[index - 1];
    }

    // 방 크기 get메서드
    public String getRoomSize(int index) {
        return managementRoom.get(0).getRoomList().getRoomSize()[index - 1];
    }


    // 방 번호 get메서드
    public int getRoomNumber(int index) {
        return managementRoom.get(0).getRoomList().getRoomID()[index - 1];
    }

    // 방 정보 get 메서드
    public Room getRoomInfo()

    {
        int[] roomNumber = {1,2,3};
        String[] roomSize = {"Standard", "Superior", "Deluxe"};
        long[] roomPrice ={50000L, 100000L, 150000L};
        return new Room(roomNumber,roomSize,roomPrice);
    }


    // uuid random 생성 메서드
    public String uuidCreate(){
        return UUID.randomUUID().toString().substring(0,8);
    }

    public LocalDateTime locaDateCreate(){
        return LocalDateTime.now();
    }

    //Reservation 객체에 예약정보 입력
    public String inputReserveData ( int roomID, String customerName, String customerPhoneNumber,int day ,long cash)
    {
        String uuid = uuidCreate();
        hotel.getReservationList().add(new Reservation(roomID, customerName, customerPhoneNumber, locaDateCreate(), day, uuid));
        customerDataList.add(new Customer(customerName,customerPhoneNumber,cash,uuid));
        hotel.setAssets(getRoomPrice(roomID));
        hotel.getManagementRoom().get(day-1).getReserveDateFlag()[roomID-1] = true;

        return uuid;
    }

    //     고객은 자신의 예약 목록을 조회
    public Reservation getInquiry (String uuid)
    {
        int index = 0;
        boolean flag = false;
        //String uuid
        for (int i = 0; i < hotel.getReservationList().size(); i++) {
            if (uuid.equals(hotel.getReservationList().get(i).getReservationNumber())) { //같은 uuid 탐색
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
        boolean removeFlag = false;
        Customer customer = null;
        if(customerDataList.size() == hotel.getReservationList().size())
        {
            for (int i = 0; i < hotel.getReservationList().size(); i++) {
                if(hotel.getReservationList().get(i).getReservationNumber().equals(uuid))
                {
                    hotel.getManagementRoom().get(hotel.getReservationList().get(i).getAccommodationDay()-1) // 호텔 빈방으로 설정
                            .getReserveDateFlag()[hotel.getReservationList().get(i).getRoomId()-1] = false;
                    name = customerDataList.get(i).getName(); // 반환할 유저 이름
                    phoneNumber = customerDataList.get(i).getPhoneNumber(); // 반환할 전화번호
                    cash = customerDataList.get(i).getCash() +
                            hotel.getManagementRoom().get(i).getRoomList().getFee()[hotel.getReservationList().get(i).getRoomId()-1]; // 환불후 남은 캐쉬
                    customerDataList.remove(i); // 저장후 고객 정보 제거
                    hotel.getReservationList().remove(i); // 저장후 호텔 고객정보 제거
                    removeFlag = true; // 제거 확인 flag
                    break;
                }
            }
        }
        if(removeFlag)
            customer = new Customer(name, phoneNumber, cash, uuid);
        return customer;
    }


}
