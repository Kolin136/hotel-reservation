package kr.sparta;

//import kr.sparta.handler.CheckHandler;
//import kr.sparta.handler.ReserveHandler;

import kr.sparta.dao.ReservationDAO;
import kr.sparta.domain.ManagementRoom;
import kr.sparta.domain.Reservation;
import kr.sparta.domain.Room;
import kr.sparta.handler.CheckHandler;
import kr.sparta.handler.ReserveHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;
import java.util.regex.Pattern;

public class ReservationApp {
    public static void main(String[] args) throws IOException {
        //글씨 꾸미기~
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_YELLOW = "\u001B[33m";

        ReserveHandler reserveHandler = new ReserveHandler();
        CheckHandler checkHandler = new CheckHandler();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ReservationDAO dao = new ReservationDAO();
        int n = dao.inputManagementRoom();

        String phoneNumberPattern = "^\\d{3}-\\d{3,4}-\\d{4}$";

        //스위치 안에 1. 예약하기, 2. 예약조회/취소,
        while_loop:
        while (true) {
            System.out.println(ANSI_YELLOW + "\"안녕하세요 9발업 저글링 HOTEL 에 방문하신 것을 환영합니다.\"" + ANSI_RESET);
            System.out.println("------------------------------------------------------");
            System.out.println("1. 예약하기");
            System.out.println("2. 예약확인/취소");
            System.out.println("3. 방 현황 확인");
            int number = Integer.parseInt(in.readLine());
            String customerName, customerPhoneNumber;
            int day = 0;
            int cash;
            switch (number) {
                case 0:

                case 1:
                    System.out.println("------------------------------------------------------");
                    System.out.println("9발업 저글링 HOTEL 예약하기");
                    System.out.println("------------------------------------------------------");
                    System.out.println("성함을 입력해주세요.");
                    customerName = in.readLine();
                    System.out.println("전화번호를 입력해주세요.(XXX-XXXX-XXXX)");
                    while(true) {
                        customerPhoneNumber = in.readLine();
                        if(Pattern.matches(phoneNumberPattern,customerPhoneNumber)) {
                            break;
                        } else {
                            System.out.println("틀린 형식의 전화번호입니다. 다시 입력해주십시오");
                        }
                    }
                    System.out.println("본인의 보유 현금을 입력해주세요.");
                    cash = Integer.parseInt(in.readLine());

                    if (cash < 50000) {
                        System.out.println("현금이 부족합니다. 돈을 많이 버시고 방문해주세요");
                        break;
                    }

                    while(true) {
                        System.out.println("금월 중 원하시는 예약날짜를 입력해주세요. (예시) 10월 9일 예약을 원하실 때 9 를 입력해주세요)");

                        day = Integer.parseInt(in.readLine());

                        if (reserveHandler.show(day) == 0) {
                            System.out.println("예약이 가능한 객실이 없습니다. 다른 날짜를 입력해주세요.");
                        } else {
                            reserveHandler.reserve(customerName, customerPhoneNumber, cash, day);
                            break;
                        }
                    }

                    break;
                case 2:
                    System.out.println(ANSI_YELLOW + "\"예약확인\"" + ANSI_RESET);
                    System.out.println("------------------------------------------------------");
                    System.out.println("예약번호를 입력해주세요.");
                    String customerReservationNumber = in.readLine();
                    checkHandler.printMyReservation(customerReservationNumber);
                    break;
                case 3:
                    for(int i = 0; i < n; i++) {
                        ArrayList<ManagementRoom> mRoomList = dao.getRoomData();
                        ManagementRoom mRoom = mRoomList.get(i);
                        System.out.println("Day" + i);
                        Room tmp = mRoom.getRoomList();
                        for(int j = 0; j < 3; j++) {
                            System.out.println(tmp.getRoomID()[j] + " " + tmp.getRoomSize()[j] + " " + tmp.getFee()[j] + " " + mRoom.getReserveDateFlag()[j]);
                        }
                    }
                    break;
                case 0:
                    break while_loop;
                default:
                    //printError();
                    break;
            }
        }

    }
}

