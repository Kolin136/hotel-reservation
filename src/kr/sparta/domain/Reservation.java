package kr.sparta.domain;

import java.time.LocalDate;
import java.util.UUID;

public class Reservation {
    private int roomId;
    private  String customerName;
    private  String customerPhoneNumber;
    private LocalDate date;
    private UUID reservationNumber;

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
