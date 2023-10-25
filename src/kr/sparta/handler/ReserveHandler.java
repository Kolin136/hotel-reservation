package kr.sparta.handler;


import kr.sparta.domain.Hotel;
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
        Hotel hotel;
        String name = br.readLine();
        String tel = br.readLine();


        //while문안에서 예약일,방 선택후 if문으로 호텔의 ReservationList에서 객체 하나하나 보면서 중복 예약일,방 있으면 다시
        //while문 첫줄 실행하고 중복없으면  Reservation 생성후 리턴


        // 예약하기 작업후 룸날짜,정보 결정후 예약하기 생성자 매개변수에 넣어준다.
        // reservation = new Reservation(rommId, name, tel, date, reservationNumber);

        //return reservation;
    }

//    public void 객체 UUID 입력 메서드(String UUID제외한 개인정보 )
//    {
//        //예약정보
//        //UUID.getUUID(uuid)
//        //  DAO 데이터 send
        // reservation데이터 넣어주고
    // DAO send (String UUID제외한 개인정보)
    // inputReserveData
//    }





}
