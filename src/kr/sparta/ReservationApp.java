package kr.sparta;

import kr.sparta.handler.AdminHandler;
import kr.sparta.handler.CheckHandler;
import kr.sparta.handler.ReserveHandler;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ReservationApp {
    public static void main(String[] args) throws IOException {
        //글씨 색상 넣어주기
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_YELLOW = "\u001B[33m";

        ReserveHandler reserveHandler = new ReserveHandler();
        CheckHandler checkHandler = new CheckHandler();
        AdminHandler adminHandler = new AdminHandler();
        Scanner sc = new Scanner(System.in);
        LocalDate now = LocalDate.now();
        int dayLength = adminHandler.getDayLength(); //이번 달이 며칠로 구성되어 있는가

        //전화번호 XXX-XXX(X)-XXXX 형식 + 이름 한글로 된 2~5자 이름만 허용
        String phoneNumberPattern = "^\\d{3}-\\d{3,4}-\\d{4}$";
        String namePattern = "^[가-힣]{2,5}$";


        //스위치 안에 1. 예약하기, 2. 예약조회/취소, 9. 모든 예약조회(Hidden).  예약 과정 input에 0 입력시 메인메뉴로(test 용도)
        while_loop:
        while (true) {
            System.out.println(ANSI_YELLOW + "\"안녕하세요 9발업 저글링 HOTEL 에 방문하신 것을 환영합니다.\"" + ANSI_RESET);
            System.out.println("------------------------------------------------------");
            System.out.println("1. 예약하기");
            System.out.println("2. 예약확인/취소");
            String customerName, customerPhoneNumber; //고객 성함, 전화번호
            int day = 0; // 예약을 원하는 날 input
            long cash; // 고객 현금 input
            int number; // 메인 메뉴 옵션
            ////// 정수 입력만 받기
            while(!sc.hasNextInt()) {
                sc.next();
                System.out.println("올바른 숫자를 입력해주세요");
            }
            number = sc.nextInt();
            sc.nextLine();
            //////
            mainLoop:
            switch (number) {
                case 0:
                    System.out.println("프로그램 종료");
                    break while_loop;
                case 1:
                    System.out.println("------------------------------------------------------");
                    System.out.println("9발업 저글링 HOTEL 예약하기");
                    System.out.println("------------------------------------------------------");
                    System.out.println("예약을 원하시는 월을 선택해주세요");
                    System.out.println("------------------------------------------------------");

                    int month = now.getMonthValue();

                    System.out.println(month + "월 예약현황입니다.");
                    reserveHandler.showMonth(now.getYear(), month);

                    System.out.println("------------------------------------------------------");
                    System.out.println("성함을 입력해주세요.");
                    while(true) {
                        System.out.println("------------------------------------------------------");
                        customerName = sc.nextLine();
                        if(Pattern.matches(namePattern,customerName)) {
                            break;
                        }
                        ///////////0 입력 시 메인화면
                        else if(customerName.equals("0")) {
                            break mainLoop;
                        }
                        ///////////
                        else {
                            System.out.println("------------------------------------------------------");
                            System.out.println("틀린 형식의 이름입니다. 다시 입력해주십시오");
                        }

                    }
                    System.out.println("------------------------------------------------------");
                    System.out.println("전화번호를 입력해주세요.(XXX-XXXX-XXXX)");
                    while(true) {
                        customerPhoneNumber = sc.nextLine();
                        if(Pattern.matches(phoneNumberPattern,customerPhoneNumber)) {
                            break;
                        }
                        ///////////0 입력 시 메인화면
                        else if(customerPhoneNumber.equals("0")) {
                            break mainLoop;
                        }
                        ///////////
                        else {
                            System.out.println("------------------------------------------------------");
                            System.out.println("틀린 형식의 전화번호입니다. 다시 입력해주십시오");
                        }
                    }
                    System.out.println("------------------------------------------------------");
                    System.out.println("본인의 보유 현금을 입력해주세요.");
                    ////// 정수 입력만 받기
                    while(!sc.hasNextLong()) {
                        sc.next();
                        System.out.println("------------------------------------------------------");
                        System.out.println("올바른 숫자를 입력해주세요");
                    }
                    ///////
                    cash = sc.nextLong();
                    sc.nextLine();
                    /////////// 0 입력 시 메인 화면으로
                    if(customerPhoneNumber.equals("0")) {
                        break mainLoop;
                    }
                    ///////////

                    if (cash < 50000) {
                        System.out.println("------------------------------------------------------");
                        System.out.println("현금이 부족합니다. 돈을 많이 버시고 방문해주세요");
                        break;
                    }

                    while(true) {
                        System.out.println("------------------------------------------------------");
                        System.out.println("금월 중 원하시는 예약날짜를 입력해주세요. (예시) 10월 9일 예약을 원하실 때 9 를 입력해주세요)");

                        ////// 정수 입력만 받기
                        while(!sc.hasNextInt()) {
                            sc.next();
                            System.out.println("------------------------------------------------------");
                            System.out.println("올바른 숫자를 입력해주세요");
                        }
                        //////

                        day = sc.nextInt();
                        sc.nextLine();

                        /////////// 0 입력 시 메인 화면으로
                        if(day == 0) {
                            break mainLoop;
                        }
                        ///////////

                        //오늘 일자보다 앞서거나 이번 달에 없는 날이라면 재입력 요구
                        if(day > dayLength || day < LocalDate.now().getDayOfMonth()) {
                            System.out.println("------------------------------------------------------");
                            System.out.println("오늘은 " + LocalDate.now().getMonthValue() + "월 " + LocalDate.now().getDayOfMonth() + "일 입니다.");
                            System.out.println("올바른 날짜를 입력해주세요");
                            continue;
                        }

                        // 예약 가능한 객실들 출력
                        if (reserveHandler.showDay(day,true).isEmpty()) {

                            System.out.println("------------------------------------------------------");
                            System.out.println("예약이 가능한 객실이 없습니다. 다른 날짜를 입력해주세요.");
                            System.out.println("------------------------------------------------------");
                        } else {
                            //예약 진행 로직. 방 선택은 이 함수 내부에서
                            reserveHandler.reserve(customerName, customerPhoneNumber, cash, day);
                        }
                        break;
                    }

                    break;
                case 2:
                    System.out.println(ANSI_YELLOW + "\"예약확인\"" + ANSI_RESET);
                    System.out.println("------------------------------------------------------");
                    System.out.println("예약번호를 입력해주세요.");
                    String customerReservationNumber = sc.nextLine();
                    /////////// 0 입력 시 메인 화면으로
                    if(customerReservationNumber.equals("0")) {
                        break mainLoop;
                    }
                    ///////////
                    // 예약내역 출력
                    checkHandler.printMyReservation(customerReservationNumber);
                    break;
                case 9:
                    //모든 예약현황 출력
                    adminHandler.printAllReservations();
                    System.out.println("------------------------------------------------------");
                    break;
                default:
                    System.out.println("------------------------------------------------------");
                    System.out.println("존재하지 않는 메뉴입니다.");
                    System.out.println("------------------------------------------------------");
                    break;
            }
        }
    }
}

