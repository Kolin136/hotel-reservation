package kr.sparta.handler;


import kr.sparta.dao.ReservationDAO;
import kr.sparta.domain.Hotel;
import kr.sparta.domain.ManagementRoom;
import kr.sparta.domain.Reservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * 예약과 관련된 기능 수행.
 * 해야하는 역할 정보를 입력받아서 객체 생성.
 */
public class ReserveHandler {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    ReservationDAO dao = new ReservationDAO();


    public void show() {
        ArrayList<ManagementRoom> managementRooms= dao.returnRoomData();


    }



    //예약하기 함수
    public void reserve(String name, String number, long cash, int date) throws IOException {
        //예약가능 목록
        //DateList dateList=new DateList();

        System.out.println("방사이즈를 선택해주세요");

        while (true) {

            int roomSelect = Integer.parseInt(br.readLine());

            if (Pattern.matches("^[1-3]$", String.valueOf(roomSelect))) {
                //선택한 방사이즈 가격
                long roomPrice = dao.RoomgetPrice(roomSelect);
                //소지금에 따라 예약 가능,불가 처리
                if (cash - roomPrice >= 0) {
                    long wallet = cash - roomPrice;
                    dao.inputReserveData(roomSelect, name, number, date, wallet);
                    System.out.printf("%s님 예약이 완료됐습니다.\n", name);
                    break;
                } else {
                    System.out.println("금액이 부족합니다. 방사이즈 다시 선택해주세요");
                }

            } else {
                System.out.println("1~3사이즈 입력해주세요");
            }
        }
    }



}
