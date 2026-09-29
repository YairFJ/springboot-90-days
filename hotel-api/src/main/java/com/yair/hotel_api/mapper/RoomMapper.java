package com.yair.hotel_api.mapper;

import com.yair.hotel_api.dto.RoomResponseDTO;
import com.yair.hotel_api.model.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomMapper {
    public static RoomResponseDTO toResponseDTO(Room room){

        return new RoomResponseDTO(
                room.getId(),
                room.getNumber(),
                room.getType(),
                room.getPricePerNight(),
                room.isAvailable()
        );

    }
    public static List<RoomResponseDTO> toDtoList(List<Room> list){
        List<RoomResponseDTO> dtoList = new ArrayList<>();

        list.forEach(room -> dtoList.add(toResponseDTO(room)));

        return dtoList;
    }
}
