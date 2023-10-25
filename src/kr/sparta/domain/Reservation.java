package kr.sparta.domain;

import java.time.LocalDate;
import java.util.UUID;

public class Reservation {
    private int roomId; // 룸번호
    private  String customerName; // 고객 이름
    private  String customerPhoneNumber; // 고객 전화번호
    private LocalDate date; // 고객 예약 일시
    private UUID reservationNumber; // 예약 번호 ID

    public int getRoom() {
        return roomId;
    }
    public void setRoom(int room) {
        this.roomId = room;
    }


    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }
    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }


    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }


    public UUID getReservationNumber() {
        return reservationNumber;
    }
    public void setReservationNumber(UUID reservationNumber) {
        this.reservationNumber = reservationNumber;
    }
}
