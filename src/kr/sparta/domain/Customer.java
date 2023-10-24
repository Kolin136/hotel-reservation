package kr.sparta.domain;

import java.util.UUID;

public class Customer {
    private String name; //이름
    private String phoneNumber; //전화번호(XXX-XXXX-XXXX)정규표현식
    private int cash; //
    private UUID reservationNumber; //예약번호

    public Customer(String name, String phoneNumber, int cash) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.cash = cash;
    }
}
