package kr.sparta;


import kr.sparta.dao.ReservationDAO;
import kr.sparta.domain.ManagementRoom;
import kr.sparta.domain.Reservation;
import kr.sparta.domain.Room;
import kr.sparta.handler.AdminHandler;
import kr.sparta.handler.CheckHandler;
import kr.sparta.handler.ReserveHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Pattern;

public class ReservationApp {
    public static void main(String[] args) throws IOException {
        //글씨 꾸미기~
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_YELLOW = "\u001B[33m";

        ReserveHandler reserveHandler = new ReserveHandler();
        CheckHandler checkHandler = new CheckHandler();
        AdminHandler adminHandler = new AdminHandler();
//        AdminHandler adminHandler = new AdminHandler();
        Scanner sc = new Scanner(System.in);
        ReservationDAO dao = new ReservationDAO();
        LocalDate now = LocalDate.now();
        int dayLength = dao.inputManagementRoom();

        String phoneNumberPattern = "^\\d{3}-\\d{3,4}-\\d{4}$";
        String namePattern = "^[가-힣]{2,5}$";


        //스위치 안에 1. 예약하기, 2. 예약조회/취소,
        while_loop:
        while (true) {
            System.out.println(ANSI_YELLOW + "\"안녕하세요 9발업 저글링 HOTEL 에 방문하신 것을 환영합니다.\"" + ANSI_RESET);
            System.out.println("------------------------------------------------------");
            System.out.println("1. 예약하기");
            System.out.println("2. 예약확인/취소");
            String customerName, customerPhoneNumber;
            int day = 0;
            long cash;
            int number;
            //////
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

                    int month = 0;
                    while(true) {
                        while(!sc.hasNextInt()) {
                            sc.next();
                            System.out.println("------------------------------------------------------");
                            System.out.println("올바른 숫자를 입력해주세요");
                        }
                        month = sc.nextInt();
                        sc.nextLine();
                        if(month < now.getMonthValue() || month >= 13) {
                            System.out.println("------------------------------------------------------");
                            System.out.println("올바른 숫자를 입력해주세요");
                        } else break;
                    }

                    System.out.println(month + "월 예약현황입니다.");
                    reserveHandler.showAll(now.getYear(), month);
                    System.out.println();
                    System.out.println("------------------------------------------------------");
                    System.out.println("1.예약 진행                     2.메인메뉴로");
                    while(!sc.hasNextInt()) {
                        sc.next();
                        System.out.println("------------------------------------------------------");
                        System.out.println("올바른 숫자를 입력해주세요");
                    }
                    int option = sc.nextInt();
                    sc.nextLine();
                    if(option != 1) break;

                    System.out.println("------------------------------------------------------");
                    System.out.println("성함을 입력해주세요.");
                    while(true) {
                        System.out.println("------------------------------------------------------");
                        customerName = sc.nextLine();
                        if(Pattern.matches(namePattern,customerName)) {
                            break;
                        }
                        ///////////
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
                        ///////////
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
                    while(!sc.hasNextLong()) {
                        sc.next();
                        System.out.println("------------------------------------------------------");
                        System.out.println("올바른 숫자를 입력해주세요");
                    }
                    cash = sc.nextLong();
                    sc.nextLine();
                    ///////////
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

                        while(!sc.hasNextInt()) {
                            sc.next();
                            System.out.println("------------------------------------------------------");
                            System.out.println("올바른 숫자를 입력해주세요");
                        }

                        day = sc.nextInt();
                        sc.nextLine();

                        ///////////
                        if(day == 0) {
                            break mainLoop;
                        }
                        ///////////

                        if(day > dayLength || day < LocalDate.now().getDayOfMonth()) {
                            System.out.println("------------------------------------------------------");
                            System.out.println("오늘은 " + LocalDate.now().getMonthValue() + "월 " + LocalDate.now().getDayOfMonth() + "일 입니다.");
                            System.out.println("올바른 날짜를 입력해주세요");
                            continue;
                        }


                        if (reserveHandler.show(day,true).isEmpty()) {

                            System.out.println("------------------------------------------------------");
                            System.out.println("예약이 가능한 객실이 없습니다. 다른 날짜를 입력해주세요.");
                            System.out.println("------------------------------------------------------");
                        } else {
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
                    ///////////
                    if(customerReservationNumber.equals("0")) {
                        break mainLoop;
                    }
                    ///////////
                    checkHandler.printMyReservation(customerReservationNumber);
                    break;
                case 9:
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

