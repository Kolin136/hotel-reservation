package kr.sparta.domain;

import java.time.LocalDate;
import java.util.UUID;

public class Reservation {
    private Room room;
    private  String custormerName;
    private  String custormerPhoneNumber;
    private LocalDate date;
    private UUID reservationNumber;

    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }


    public String getCustormerName() {
        return custormerName;
    }
    public void setCustormerName(String custormerName) {
        this.custormerName = custormerName;
    }


    public String getCustormerPhoneNumber() {
        return custormerPhoneNumber;
    }
    public void setCustormerPhoneNumber(String custormerPhoneNumber) {
        this.custormerPhoneNumber = custormerPhoneNumber;
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
