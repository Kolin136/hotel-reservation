package kr.sparta.handler;

import kr.sparta.dao.ReservationDAO;
import kr.sparta.domain.Reservation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CheckHandler {

    /**
     * 체크 핸들러에 넣어야할 것들.
     * 화면 출력 메소드
     * 예약번호를 입력하고 예약 정보를 받아오는 메소드.
     * 예약 취소 메소드.
     */

    /**
     * 일단 제가 생각한 대로 작성했습니다.
     * 피드백 남겨주시면 바로 반영하겠습니다.
     */

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    ReservationDAO dao = new ReservationDAO();


    public Reservation getReservation(String reservationId) {

        Reservation reservation = dao.getInquiry(reservationId);
        return reservation;

    }

    public void cancleReservation(String reservationId) {
        //dao.cancleReservation(reservationId);
        //리턴값을 줘서 취소가 완료되었다는 것을 알려줘도 괜찮을 듯.
        //reservationList에서 cancleFlag를 true로 해도 되고
        //reservationList에서 해당 객체를 삭제하는 것도 되고.
    }


}
