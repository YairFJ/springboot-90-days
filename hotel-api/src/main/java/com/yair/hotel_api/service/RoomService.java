package com.yair.hotel_api.service;

import com.yair.hotel_api.model.Room;
import com.yair.hotel_api.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    public RoomService(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms(){
        return roomRepository.getAllRooms();
    }

    public Optional<Room> getRoomById(Long id){
        return roomRepository.getRoomById(id);
    }

    public void createRoom(Room room){
        roomRepository.saveRoom(room);
    }

}
