package com.yair.hotel_api.service;

import com.yair.hotel_api.dto.RoomRequestDTO;
import com.yair.hotel_api.dto.RoomResponseDTO;
import com.yair.hotel_api.model.Room;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface IRoomService {
     List<RoomResponseDTO> getAllRooms();
     ResponseEntity<RoomResponseDTO> getRoomById(Long id);

     ResponseEntity<RoomResponseDTO> createRoom(RoomRequestDTO roomDTO);

     ResponseEntity<RoomResponseDTO> editRoom(Long id, RoomRequestDTO editedRoom);

     ResponseEntity<RoomResponseDTO> deleteRoom(Long id);

}
