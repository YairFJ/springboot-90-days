package com.yair.hotel_api.repository;

import com.yair.hotel_api.model.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class RoomRepository {
    private List<Room> rooms = new ArrayList<>();

    private static long lastId = 1;


    public void saveRoom(Room room){
        room.setId(lastId);
        lastId++;
        rooms.add(room);
    }

    public List<Room> getAllRooms(){
        return rooms;
    }

    public Optional<Room> getRoomById(Long id){
         return rooms.stream().filter(room -> room.getId().equals(id)).findFirst();
    }


}
