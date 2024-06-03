package com.example.study.model;

public class ItemUpdateDTO {
    private int startingPrice; // 클라이언트로부터 받은 새로운 가격
    private String description; // 새로운 설명

    // Getter와 Setter
    public int getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(int startingPrice) {
        this.startingPrice = startingPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}