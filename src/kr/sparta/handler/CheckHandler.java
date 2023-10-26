package kr.sparta.handler;

import kr.sparta.dao.ReservationDAO;
import kr.sparta.domain.Customer;
import kr.sparta.domain.Reservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckHandler {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    ReservationDAO dao = new ReservationDAO();

    public Reservation getReservation(String reservationId) {
        Reservation reservation = dao.getInquiry(reservationId);
        return reservation;

    }

    public void printMyReservation(String reservationId) throws IOException {
        Reservation reservation = getReservation(reservationId);
        System.out.println("예약하신 내역입니다.");
        System.out.println("예약 번호: "+ reservationId);
        System.out.println("성함: " + reservation.getCustomerName());
        System.out.println("연락처: " + reservation.getCustomerPhoneNumber());
        System.out.println("예약객실: " + reservation.getRoomId());
        System.out.println("예약일자: " + reservation.getAccommodationDay());
        System.out.println("1. 뒤로가기  2.취소하기");

        int choice = getNumber();
        if (choice == 1) {
            return;
        } else if (choice == 2) {
            cancelReservation(reservationId);
        }
    }

    public int getNumber() {
        try {
            int number = Integer.parseInt(in.readLine());
            return number;
        } catch (IOException e) {
            return -1;
        }
    }

    public void cancelReservation(String reservationId) {
        System.out.println("해당 예약을 취소하시겠습니까?");
        System.out.println("1.예    2.아니오");
        int choice = getNumber();
        if(choice == 1) {
            Customer customer = dao.reservationRemove(reservationId);
            System.out.println("취소가 완료되었습니다.");
        } else if (choice == 2) {
            return;
        } else {
            System.out.println("잘못누르셨습니다. 메인화면으로 돌아갑니다.");
            return;
        }

    }
}
