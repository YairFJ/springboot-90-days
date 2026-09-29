package com.yair.hotel_api.controller;

import com.yair.hotel_api.dto.RoomRequestDTO;
import com.yair.hotel_api.dto.RoomResponseDTO;
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
    public ResponseEntity<RoomResponseDTO> createRoom(@RequestBody RoomRequestDTO roomDTO){
       return roomService.createRoom(roomDTO);
    }

    @GetMapping("/rooms")
    public List<RoomResponseDTO> getAllRooms(){
        return roomService.getAllRooms();
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<RoomResponseDTO> getRoomById(@PathVariable Long id){
        return roomService.getRoomById(id);
    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<RoomResponseDTO> editRoom(@PathVariable Long id, @RequestBody RoomRequestDTO room){
        return roomService.editRoom(id, room);
    }

    @DeleteMapping("/rooms/{id}")
    public ResponseEntity<RoomResponseDTO> deleteRoom(@PathVariable Long id){
        return roomService.deleteRoom(id);
    }
}
