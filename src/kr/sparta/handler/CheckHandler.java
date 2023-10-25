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

    public int getNumber(){
        try {
            int number = Integer.parseInt(in.readLine());
            return number;
        }catch(Exception ex){
            return -1; // 숫자로 변환 못할 경우 -1을 리턴한다.
        }
    }

    //그냥 스태틱하게 화면만 보여주는 부분이랑 사용자에 입력에 따라 다른 정보를 보여줘야하는 부분을 분리시키면 어떨까.
    public void printMyReservation() {
        int reservationId = getNumber();
        Reservation reservation = getReservation(reservationId);
        System.out.println("예약하신 내역입니다." + reservation);
        System.out.println("1. 뒤로가기  2.취소하기");
        //reservationId 다음으로 전달해주기.
        int choice = getNumber();
        if(choice == 1) {
            return;
        } else if(choice == 2) {
            cancleReservation(reservation);
        }
    }

    public void cancleReservation(String reservationId) {
        //dao.cancleReservation(reservationId);
        //리턴값을 줘서 취소가 완료되었다는 것을 알려줘도 괜찮을 듯.
        //reservationList에서 cancleFlag를 true로 해도 되고
        //reservationList에서 해당 객체를 삭제하는 것도 되고.
    }


}
