package com.yair.hotel_api.controller;

import com.yair.hotel_api.model.Room;
import com.yair.hotel_api.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/rooms")
    public void createRoom(@RequestBody Room room){
        roomService.createRoom(room);
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    @GetMapping("/rooms/{id}")
    public Optional<Room> getRoomById(@PathVariable Long id){
        return roomService.getRoomById(id);
    }
}
