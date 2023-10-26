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
        //메인 화면 프린트해주고 입력받기 -> 어떤 클래스가 메소드를 가져야하는지


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
            int day;
            int cash;
            switch (number) {
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
                    System.out.println("금월 중 원하시는 예약날짜를 입력해주세요. (예시) 10월 9일 예약을 원하실 때 9 를 입력해주세요)");
                    //여기서 한달만 따질 거니까 일수만 받을지? 체크인 14시 체크아웃 12시로 통일?

                    day = Integer.parseInt(in.readLine());
                    //이후에 handler에서
                    // LocalDate currentTime = LocalDate.now();
                    // LocalDateTime date = LocalDateTime.of(currentTime.getYear(), currentTime.getMonthValue(), day, 14, 0, 0)
                    //날짜뿐만 아니라 시간 정보도 주기 위해서(ISO8601) LocalDateTime으로 선언

                    System.out.println("본인의 보유 현금을 입력해주세요.");
                    cash = Integer.parseInt(in.readLine());

                    //reserveHandler.showRooms(cash, day); //여기서 보유현금과 원하는 날짜에 부합하는 객실들만 쫘르르 출력    managementRoom[26]  3개방이 있을 테니.
                    System.out.println("원하는 객실을 선택해주세요.");

                    //예약 확정 전 정보 출력도 해주기
                    System.out.println("이 정보로 예약하시겠습니까?");
                    System.out.println("성함: " + customerName);
                    System.out.println("연락처: " + customerPhoneNumber);
//                    System.out.println("예약객실: " + reserveHandler.printRoomInfo());
                    LocalDate now = LocalDate.now();
                    System.out.println("예약일자: " + now.getYear() + "." + now.getMonthValue() + "." + day);
                    System.out.println("------------------------------------------------------");
                    System.out.println("1. 예약확정                 2. 메인 메뉴로");//간격 tap*5로 통일
                    int option = Integer.parseInt(in.readLine());
                    if(option == 1) {
                        //reserveHandler.reserve(name, phoneNumber, DATE, cash);
                        System.out.println("------------------------------------------------------");
                        System.out.println("예약이 확정되었습니다!");
                        //reserveHandler.showUuid() 예약번호 보여주기 "
                        System.out.println("위 예약번호를 기억해주세요!");
                        System.out.println("------------------------------------------------------");
                    }
                    //reserveHandler.reserve(name, phoneNumber, DATE, cash); //handler에 지역변수로 저장된 이름, 번호, 날짜, 현금 넘겨주고 원하는 객실 고르게끔


                    //reserveHandler.showUuid() 예약번호 보여주기 "
                    //예약하기
                    break;
                case 2:
                    //2f48f241-9d64-4d16-bf56-70b9d4e0e79a
                    //예약 조회/취소
                    System.out.println(ANSI_YELLOW + "\"예약확인\"" + ANSI_RESET);
                    System.out.println("------------------------------------------------------");
                    System.out.println("예약번호를 입력해주세요.");
                    String customerReservationNumber = in.readLine();
//                    checkHandler.printMyReservation(customerReservationNumber);

//                    int choice = Integer.parseInt(in.readLine());
//                    switch (choice) {
//                        case 1:
//                            System.out.println("정말 예약을 취소하시겠습니까?");
//                            System.out.println("1. 예       2. 아니오");
//                            int number1 = Integer.parseInt(in.readLine());
//                            switch (number1) {
//                                case 1:
//                                    checkHandler.cancleReservation(reservationNumber);
//                                    break;
//                                default:
//                                    break;
//                            }
//                        default:
//                            break;
//                    }
//                    break;
                    break;
                case 3:
                    for(int i = 0; i < n; i++) {
                        ArrayList<ManagementRoom> mRoomList = dao.getRoomData();
                        for(ManagementRoom mRoom: mRoomList) {
                            System.out.println();
                            System.out.println("Day" + i);
                            Room tmp = mRoom.getRoomList();
                            for(int j = 0; j < 3; j++) {
                                System.out.println(tmp.getRoomID()[j] + " " + tmp.getRoomSize()[j] + " " + tmp.getFee()[j] + " " + mRoom.getReserveDateFlag()[j]);
                                System.out.println();
                            }
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

