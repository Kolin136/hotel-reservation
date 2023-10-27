package kr.sparta.handler;

import kr.sparta.dao.ReservationDAO;
import kr.sparta.domain.ManagementRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class ReserveHandler {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ReservationDAO dao = new ReservationDAO();


//    public void showAll(int year, int month) {
//        LocalDate calender = LocalDate.of(year, month, 1);
//        int startDay = calender.getDayOfWeek().getValue(); //해당 달의 1일이 무슨 요일인지(월요일:1 ~ 일요일:7)
//        int endDay = calender.lengthOfMonth(); // 해당 달이 30 or 31 몇일까지 있는지
//
//        System.out.println("[" + year + "년 " + month + "월" + "]");
//        System.out.println("일\t월\t화\t수\t목\t금\t토");
//
//        for (int k = 1; k <= endDay; k++) {
//            System.out.printf("%02d\t", k);
//            if (k % 7 == 0) {
//                System.out.println();
//            }
//
//        }
//    }

    public ArrayList<Integer> show(int day,boolean check) {
        //30~31일 모든 일수담긴 리스트 가져오기
        ArrayList<ManagementRoom> managementRooms = dao.getRoomData();

        //해당 일 객체만 뽑기
        ManagementRoom managementRoom = managementRooms.get(day - 1);

        //해당 일의 1~3사이즈방 예약가능,불가 가져오기
        boolean[] roomCheck = managementRoom.getReserveDateFlag();

        //예약 가능 방 가능 필터링 결과
        ArrayList<Integer> roomResult = new ArrayList<>();

        for (int i = 1; i <= roomCheck.length; i++) {
            if (!roomCheck[i - 1]) {
                roomResult.add(i);
            }
        }

        // show메소드를 예약 가능 방 목록 리턴용으로만 사용 or 목록 출력+리턴까지 할건가
        if(check) {
            System.out.printf("%d일 예약 가능방 목록입니다\n", day);
            for (int roomSize : roomResult) {
                String sizeName = managementRoom.getRoomList().getRoomSize()[roomSize - 1];
                long sizeFee = managementRoom.getRoomList().getFee()[roomSize - 1];
                System.out.printf("%d. %s :%d원\n", roomSize, sizeName, sizeFee);
            }
        }

        return roomResult;
    }


    //예약하기 함수
    public void reserve(String name, String number, long cash, int date) throws IOException {

            //해당날 예약 가능한 방 목록 불러오기
            ArrayList<Integer> openRoom = this.show(date,false);
            StringBuilder regex = new StringBuilder("^[");

            //예약 가능방 선택 제한 처리
            for (int i = 0; i <= openRoom.size(); i++) {
                if (i != openRoom.size()) {
                    regex.append(String.valueOf(openRoom.get(i)));

                } else {
                    regex.append("]$");
                }

            }


            System.out.println("방사이즈를 선택해주세요");

            while (true) {
                int roomSelect;
                try {
                    roomSelect = Integer.parseInt(br.readLine());

                } catch (Exception e) {
                    System.out.println("문자가 아닌 예약가능 방 숫자 입력해주세요");
                    continue;
                }

                if (Pattern.matches(regex.toString(), String.valueOf(roomSelect))) {
                    //선택한 방사이즈 가격
                    long roomPrice = dao.getRoomPrice(roomSelect);
                    //소지금에 따라 예약 가능,불가 처리
                    if (cash - roomPrice >= 0) {
                        long wallet = cash - roomPrice;
                        System.out.println("이 정보로 예약하시겠습니까?");
                        System.out.println("성함: " + name);
                        System.out.println("연락처: " + number);
                        System.out.println("예약객실: " + dao.getRoomSize(roomSelect));
                        LocalDate now = LocalDate.now();
                        System.out.println("예약일자: " + now.getYear() + "." + now.getMonthValue() + "." + date);
                        System.out.println("------------------------------------------------------");
                        System.out.println("1. 예약확정                 2. 메인 메뉴로");//간격 tap*5로 통일
                        int option = Integer.parseInt(br.readLine());
                        if (option == 1) {
                            System.out.println("------------------------------------------------------");
                            String customerUuid = dao.inputReserveData(roomSelect, name, number, date, wallet);
                            System.out.printf("%s님 예약이 완료됐습니다.\n", name);
                            System.out.println("------------------------------------------------------");
                            System.out.println(customerUuid);
                            System.out.println("위 예약번호를 기억해주세요!");
                            System.out.println("------------------------------------------------------");
                        }
                        break;
                    } else {
                        System.out.println("금액이 부족합니다. 방사이즈 다시 선택해주세요");
                    }

                } else {
                    System.out.println("예약 가능한 방 번호 입력해주세요");
                }
            }
    }
}
