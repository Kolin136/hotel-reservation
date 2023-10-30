package kr.sparta.handler;

import kr.sparta.dao.ReservationDAO;
import kr.sparta.domain.Reservation;

import java.util.List;

public class AdminHandler {
    ReservationDAO dao = new ReservationDAO();
    public void printAllReservations() {
        List<Reservation> reservationList = dao.getReservationList();
        for(Reservation r : reservationList) {
            System.out.println(r);
        }
    }
    public int getDayLength() {
        return dao.inputManagementRoom();
    }
}
