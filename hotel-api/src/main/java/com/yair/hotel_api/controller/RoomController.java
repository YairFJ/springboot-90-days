package com.yair.hotel_api.controller;

import com.yair.hotel_api.model.Room;
import com.yair.hotel_api.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/rooms")
    public ResponseEntity<Room> createRoom(@RequestBody Room room){
       return roomService.createRoom(room);
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id){
        return roomService.getRoomById(id);
    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> editRoom(@PathVariable Long id, @RequestBody Room room){
        return roomService.editRoom(id, room);
    }

    @DeleteMapping("/rooms/{id}")
    public ResponseEntity<Room> deleteRoom(@PathVariable Long id){
        return roomService.deleteRoom(id);
    }
}
