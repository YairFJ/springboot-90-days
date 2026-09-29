package com.yair.hotel_api.service;
import com.yair.hotel_api.dto.RoomRequestDTO;
import com.yair.hotel_api.dto.RoomResponseDTO;
import com.yair.hotel_api.mapper.RoomMapper;
import com.yair.hotel_api.model.Room;
import com.yair.hotel_api.repository.IRoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService implements IRoomService {
    private final IRoomRepository repository;

    public RoomService(IRoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RoomResponseDTO> getAllRooms(){
        return RoomMapper.toDtoList(repository.findAll());
    }

    @Override
    public ResponseEntity<RoomResponseDTO> getRoomById(Long id){
        Optional<Room> room = repository.findById(id);


        if(room.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        RoomResponseDTO roomResponseDTO = RoomMapper.toResponseDTO(room.get());
        return new ResponseEntity<>(roomResponseDTO,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RoomResponseDTO> createRoom(RoomRequestDTO roomDTO){
        if(roomDTO.getNumber() > 0 && roomDTO.getType() != null && roomDTO.getPricePerNight() != null){
            Room room = new Room(
                    roomDTO.getNumber(),
                    roomDTO.getType(),
                    roomDTO.getPricePerNight()
            );
            repository.save(room);
            RoomResponseDTO roomResponseDTO = RoomMapper.toResponseDTO(room);
            return new ResponseEntity<>(roomResponseDTO,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<RoomResponseDTO> editRoom(Long id, RoomRequestDTO editedRoom){

        Room oldRoom = repository.findById(id).orElse(null);

        if(oldRoom == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        oldRoom.setNumber(editedRoom.getNumber());
        oldRoom.setType(editedRoom.getType());
        oldRoom.setPricePerNight(editedRoom.getPricePerNight());

        Room savedRoom = repository.save(oldRoom);
        RoomResponseDTO room = RoomMapper.toResponseDTO(savedRoom);

        return new ResponseEntity<>(room,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RoomResponseDTO> deleteRoom(Long id){
        if(repository.findById(id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
