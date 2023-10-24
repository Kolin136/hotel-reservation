package kr.sparta;

public class ReservationApp {
    public static void main(String[] args) {
        //메인 화면 프린트해주고 입력받기 -> 어떤 클래스가 메소드를 가져야하는지
        //int number = 클래스.getNumber()
        int number = 0;
        //스위치 안에 1예약하기, 2 예약조회/취소,
        while_loop:
        while(true) {
            switch (number) {
                case 1 :
                    //예약하기
                    break;
                case 2 :
                    //예약 조회/취소
                    break;
                case 0 :
                    break while_loop;
                default:
                    //printError();
                    break;
            }
        }

    }
}
