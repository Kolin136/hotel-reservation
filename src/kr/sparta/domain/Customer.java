package kr.sparta.domain;

import java.util.UUID;

public class Customer {
    private String name; //이름
    private String phoneNumber; //전화번호(XXX-XXXX-XXXX)정규표현식
    private int cash;


    public Customer(String name, String phoneNumber, int cash) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.cash = cash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}
