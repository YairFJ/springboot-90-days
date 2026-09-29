package com.yair.hotel_api.dto;

import java.math.BigDecimal;

public class RoomResponseDTO {
    private Long id;
    private int number;
    private String type;
    private BigDecimal pricePerNight;
    private boolean available;

    public RoomResponseDTO(){

    }

    public RoomResponseDTO(Long id, int number, String type, BigDecimal pricePerNight,boolean available){
        this.id = id;
        this.number = number;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(BigDecimal pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
