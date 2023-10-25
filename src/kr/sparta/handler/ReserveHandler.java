package kr.sparta.handler;


import kr.sparta.domain.Reservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.UUID;

/**
 * 예약과 관련된 기능 수행.
 * 해야하는 역할 정보를 입력받아서 객체 생성.
 */
public class ReserveHandler {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Reservation reserve() throws IOException {
        Reservation reservation;
        String name = br.readLine();
        String tel = br.readLine();

        // 예약하기 작업후 룸날짜,정보 결정후 예약하기 생성자 매개변수에 넣어준다.
       // reservation = new Reservation(rommId, name, tel, date, reservationNumber);

        //return reservation;
    }


    public void printPage(int y, int m) {
        //sout 실행할 메소드.

    }


}
