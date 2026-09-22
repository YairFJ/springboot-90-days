package com.yair.hotel_api.service;

import com.yair.hotel_api.model.Room;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface IRoomService {
    public List<Room> getAllRooms();
    public ResponseEntity<Room> getRoomById(Long id);

    public ResponseEntity<Room> createRoom(Room room);

    public ResponseEntity<Room> editRoom(Long id, Room editedRoom);

    public ResponseEntity<Room> deleteRoom(Long id);

}
