package kr.sparta.dao;

import kr.sparta.domain.Customer;
import kr.sparta.domain.Hotel;
import kr.sparta.domain.Reservation;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.UUID;

public class ReservationDAO {
    // 예약 목록 조회

    private ArrayList<Reservation> reservationList;
    private ArrayList<Customer> users;

    public ArrayList<Reservation> getReservationList()
    {
        return this.reservationList;
    }

    public void add(Reservation reservation)
    {
        this.reservationList.add(reservation);
    }


//    public Hotel getHotelInfo(Hotel hotel)
//    {
//        return hotel;
//    }
    // 고객은 자신의 예약 목록을 조회
//    public Reservation getInquiry(String inquiry)
//    {
//        int index;
//        boolean flag =false;
//        //String uuid
//        for (int i = 0; i < this.reservationList.size(); i++) {
//            if(inquiry.equals(this.reservationList.get(i).getReservationNumber().toString()))
//            {
//                index =i;
//                break;
//            }
//        }
//
//    }

//    public void inputReserveData()


}
