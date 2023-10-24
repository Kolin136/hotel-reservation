package kr.sparta.handler;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 예약과 관련된 기능 수행.
 * 해야하는 역할 정보를 입력받아서 객체 생성.
 *
 */
public class ReserveHandler {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void reserve() throws IOException {
        String name = br.readLine();
        String tel = br.readLine();
        //Reservation reservation = new Reservation(name, tel);

    }
    public void printPage() {
        //sout 실행할 메소드.
    }



}
