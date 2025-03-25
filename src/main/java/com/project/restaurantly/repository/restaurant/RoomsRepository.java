package com.project.restaurantly.repository.restaurant;

import com.project.restaurantly.Entity.restaurant.Rooms;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms, Long> {
    @Query("SELECT r FROM Rooms r WHERE" +
            "(:name IS NULL OR r.room_name LIKE %:name%) AND" +
            "(:status IS NULL OR r.status = :status)")
    Page<Rooms> findByName
            (String name, Pageable pageable, int status);

    @Query("SELECT r FROM Rooms r WHERE" +
            "(:status IS NULL OR r.status = :status)")
    List<Rooms> findByStt
            (int status);
}
