package kr.sparta.handler;


import kr.sparta.dao.ReservationDAO;
import kr.sparta.domain.Hotel;
import kr.sparta.domain.ManagementRoom;
import kr.sparta.domain.Reservation;
import kr.sparta.domain.Room;

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
    int n = dao.inputManagementRoom();


    public void show(int day) {
        //30~31일 모든 일수담긴 리스트 가져오기
        ArrayList<ManagementRoom> managementRooms= dao.getRoomData();

        //해당 일 객체만 뽑기
        ManagementRoom managementRoom = managementRooms.get(day-1);

        //해당 일의 1~3사이즈방 예약가능,불가 가져오기
        boolean[] roomCheck =managementRoom.getReserveDateFlag();

        //예약 가능 방 가능 필터링 결과
        ArrayList<Integer> roomResult = new ArrayList<>();

        for (int i = 1; i <=roomCheck.length  ; i++) {
            if(!roomCheck[i-1]){
                roomResult.add(i);
            }
        }

        System.out.printf("%d일 예약 가능방 목록입니다\n",day);
        for (int roomSize : roomResult) {
            String sizeName = managementRoom.getRoomList().getRoomSize()[roomSize-1];
            System.out.printf("%d. %s\n",roomSize,sizeName );
        }


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
                long roomPrice = dao.roomgetPrice(roomSelect);
                //소지금에 따라 예약 가능,불가 처리
                if (cash - roomPrice >= 0) {
                    long wallet = cash - roomPrice;
                    System.out.println("이 정보로 예약하시겠습니까?");
                    System.out.println("성함: " + name);
                    System.out.println("연락처: " + number);
                    // System.out.println("예약객실: " + reserveHandler.printRoomInfo()); //이게 3이면 Deluxe
                    //재석님 보고 계세요?? 그러면 이거를 성호님한테 부탁을 드리죠 roomgetSize 이런식으로 인덱스로 방 받게
                    Room tmpRoom = new Room(new int[]{1, 2, 3},
                            new String[]{"Standard", "Superior", "Deluxe"},
                            new long[]{50000L, 100000L, 150000L});
//                    System.out.println("예약객실: " + dao.getRoomData().get(0).getRoomList().getRoomSize()[roomSelect-1]);
                    System.out.println("예약객실: " + tmpRoom.getRoomSize()[roomSelect-1]);
                    LocalDate now = LocalDate.now();
                    System.out.println("예약일자: " + now.getYear() + "." + now.getMonthValue() + "." + date);
                    System.out.println("------------------------------------------------------");
                    System.out.println("1. 예약확정                 2. 메인 메뉴로");//간격 tap*5로 통일
                    int option = Integer.parseInt(br.readLine());
                    if(option == 1) {
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
                System.out.println("1~3사이즈 입력해주세요");
            }
        }
    }
}
