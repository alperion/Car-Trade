package com.example.demo.dto.request.users;

public class AddMoneyToAccountRequestDto {
    private String token;
    private int money;

    public AddMoneyToAccountRequestDto(String token, int money) {
        this.token = token;
        this.money = money;
    }

    public AddMoneyToAccountRequestDto() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
