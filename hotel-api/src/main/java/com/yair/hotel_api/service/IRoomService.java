package com.yair.hotel_api.service;

import com.yair.hotel_api.dto.RoomRequestDTO;
import com.yair.hotel_api.dto.RoomResponseDTO;
import com.yair.hotel_api.model.Room;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface IRoomService {
    public List<Room> getAllRooms();
    public ResponseEntity<RoomResponseDTO> getRoomById(Long id);

    ResponseEntity<Room> createRoom(RoomRequestDTO roomDTO);

    public ResponseEntity<Room> editRoom(Long id, Room editedRoom);

    public ResponseEntity<Room> deleteRoom(Long id);

}
