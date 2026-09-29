package com.yair.hotel_api.dto;

import java.math.BigDecimal;

public class RoomRequestDTO {
    private int number;
    private String type;
    private BigDecimal pricePerNight;

    public RoomRequestDTO(){

    }
    public RoomRequestDTO(int number, String type, BigDecimal pricePerNight){
        this.number = number;
        this.type = type;
        this.pricePerNight = pricePerNight;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber(){
        return this.number;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public void setPricePerNight(BigDecimal price) {
        this.pricePerNight = price;
    }

    public BigDecimal getPricePerNight(){
        return this.pricePerNight;
    }

}
