package com.yair.hotel_api.repository;

import com.yair.hotel_api.model.Room;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class RoomRepository {
    private final List<Room> rooms = new ArrayList<>();

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

    public Room editRoom(Long id, Room room){
        Optional<Room> oldRoom = getRoomById(id);
        oldRoom.ifPresent(old -> {
            old.setNumber(room.getNumber());
            old.setType(room.getType());
            old.setPricePerNight(room.getPricePerNight());
            old.setAvailable(room.isAvailable());
        });
        return oldRoom.orElseThrow(()-> new RuntimeException("ID INCORRECT"));

    }

    public boolean deleteRoom(Long id){
       return rooms.removeIf((room -> Objects.equals(room.getId(), id)));
    }



}
