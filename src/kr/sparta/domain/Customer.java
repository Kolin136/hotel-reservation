package kr.sparta.domain;

import java.util.UUID;

public class Customer {
    private String name; //이름
    private String phoneNumber; //전화번호(XXX-XXXX-XXXX)정규표현식
    private int cash;

    private String uuid;


    public Customer(String name, String phoneNumber, int cash,String uuid) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.cash = cash;
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
