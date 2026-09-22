package com.yair.hotel_api.repository;

import com.yair.hotel_api.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoomRepository extends JpaRepository<Room, Long> {
}
