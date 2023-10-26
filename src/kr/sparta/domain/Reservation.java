package kr.sparta.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Reservation {
    private int roomId; // 룸번호
    private String customerName; // 고객 이름
    private String customerPhoneNumber; // 고객 전화번호
    private LocalDateTime date; // 고객 예약 일시
    private int accommodationDay; //숙박일
    private String reservationNumber; // 예약 번호 ID

    public Reservation(int roomId, String customerName, String customerPhoneNumber, LocalDateTime date, int accommodationDay, String reservationNumber) {
        this.roomId = roomId;
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.date = date;
        this.accommodationDay = accommodationDay;
        this.reservationNumber = reservationNumber;
    }


    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getAccommodationDay() {
        return accommodationDay;
    }

    public void setAccommodationDay(int accommodationDay) {
        this.accommodationDay = accommodationDay;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "roomId=" + roomId +
                ", customerName='" + customerName + '\'' +
                ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                ", date=" + date +
                ", accommodationDay=" + accommodationDay +
                ", reservationNumber='" + reservationNumber + '\'' +
                '}';
    }
}
