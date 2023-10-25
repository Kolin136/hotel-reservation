package kr.sparta;

//import kr.sparta.handler.CheckHandler;
//import kr.sparta.handler.ReserveHandler;

public class ReservationApp {
    public static void main(String[] args) {
        //글씨 꾸미기~
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_YELLOW = "\u001B[33m";
        //
        //메인 화면 프린트해주고 입력받기 -> 어떤 클래스가 메소드를 가져야하는지
        //int number = 클래스.getNumber()
        int number = 0;

//        ReserveHandler reserveHandler = new ReserveHandler();
//        CheckHandler checkHandler = new CheckHandler();

        //스위치 안에 1예약하기, 2 예약조회/취소,
        while_loop:
        while (true) {
            System.out.println(ANSI_YELLOW + "\"안녕하세요 9발업 저글링 HOTEL 에 방문하신 것을 환영합니다.\"" + ANSI_RESET);
            System.out.println("------------------------------------------------------");
            System.out.println("1. 예약하기");
            System.out.println("2. 예약확인/취소");
//            int number = 클래스.getNumber();
            switch (number) {
                case 1:
                    //reserveHandler.showRooms() - "roomID호. roomSize fee 예약가능여부(이건 어떻게) 로 쫘르르 출력
                    //reserveHandler.reserve(클래스.getNumber())로 원하는 방 입력 -> 함수 내부에서 여러 입력 받으면서 이름, 전화번호, 예약날짜 받게끔  + 마지막으로 이 정보가 맞습니까 확인 -> 예약확정시 어쩌구저쩌구
                    //예약하기
                    break;
                case 2:
                    //예약 조회/취소
                    //UUID reservationNumber = 클래스.getNumber() 사용자에게 예약번호 입력요청.
                    //CheckHandler.checkReservation(reservationNumber) -> 이 번호에 해당하는 Reservation이 있으면 출력, 없으면 해당하는 예약이 없습니다.
                    System.out.println("1. 예약 취소    2. 메인 메뉴로");
//                    switch (클래스.getNumber()) {
//                        case 1:
//                            System.out.println("정말 예약을 취소하시겠습니까?");
//                            System.out.println("1. 예       2. 아니오");
//                            switch (클래스.getNumber()) {
//                                case 1:
//                                    CheckHandler.cancelReservation(DAO.getReservationByReservationNumber(reservationNumber));
//                                    break;
//                                default:
//                                    break;
//                            }
//                        default:
//                            break;
//                    }
//                    break;
                case 0:
                    break while_loop;
                default:
                    //printError();
                    break;
            }
        }

    }
}

