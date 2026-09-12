package com.yair.hotel_api.model;

import java.math.BigDecimal;

public class Room {
    private Long id;
    private int number;
    private String type;
    private BigDecimal pricePerNight;
    private boolean available;

    public Room(int number, String type, BigDecimal pricePerNight) {
        this.number = number;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.available = true;
    }
    public Long getId(){return this.id;}
    public void setId(Long id){
        this.id = id;
    }

    public int getNumber(){
        return this.number;
    }
    public void setNumber(int number){
        this.number = number;
    }

    public String getType(){
        return this.type;
    }
    public void setType(String type){
        this.type = type;
    }

    public BigDecimal getPricePerNight(){
        return this.pricePerNight;
    }
    public void setPricePerNight(BigDecimal price){
        this.pricePerNight = price;
    }

    public boolean isAvailable(){
        return this.available;
    }
    public void setAvailable(boolean available){
        this.available = available;
    }



}
