package com.yair.hotel_api.service;

import com.yair.hotel_api.model.Room;
import com.yair.hotel_api.repository.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final IRoomRepository repository;

    public RoomService(IRoomRepository repository) {
        this.repository = repository;
    }

    public List<Room> getAllRooms(){
        return repository.findAll();
    }

    public ResponseEntity<Room> getRoomById(Long id){
        if(repository.findById(id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(repository.findById(id).get(),HttpStatus.OK);
    }

    public ResponseEntity<Room> createRoom(Room room){
        if(room.getNumber() > 0 && room.getType() != null && room.getPricePerNight() != null){
            repository.save(room);
            return new ResponseEntity<>(room,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(room,HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Room> editRoom(Long id, Room editedRoom){

        Room oldRoom = repository.findById(id).orElse(null);

        if(oldRoom == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        oldRoom.setNumber(editedRoom.getNumber());
        oldRoom.setType(editedRoom.getType());
        oldRoom.setPricePerNight(editedRoom.getPricePerNight());
        oldRoom.setAvailable(editedRoom.isAvailable());

        Room savedRoom = repository.save(oldRoom);

        return new ResponseEntity<>(savedRoom,HttpStatus.OK);
    }

    public ResponseEntity<Room> deleteRoom(Long id){
        if(repository.findById(id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
