package kr.sparta.domain;


public class Customer {
    private String name; //이름
    private String phoneNumber; //전화번호(XXX-XXXX-XXXX)정규표현식
    private long cash; // 유저가 가지고 있는 현금
    private String uuid; // 유저가 가지고있는 uuid


    public Customer(String name, String phoneNumber, long cash,String uuid) {
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

    public long getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}
