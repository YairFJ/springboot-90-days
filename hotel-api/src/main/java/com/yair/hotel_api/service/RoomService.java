package com.yair.hotel_api.service;

import com.yair.hotel_api.model.Room;
import com.yair.hotel_api.repository.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<Room> getRoomById(Long id){
        Optional<Room> room = roomRepository.getRoomById(id);

        if(room.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(room.get(),HttpStatus.OK);
    }

    public void createRoom(Room room){
        roomRepository.saveRoom(room);
    }

    public ResponseEntity<Room> editRoom(Long id, Room room){
        if(roomRepository.getRoomById(id).isEmpty()){
            return new ResponseEntity<>(room,HttpStatus.NOT_FOUND);
        }
        Room editedRoom = roomRepository.editRoom(id,room);
        return new ResponseEntity<>(editedRoom,HttpStatus.OK);
    }

    public ResponseEntity<Room> deleteRoom(Long id){
        if(roomRepository.deleteRoom(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
