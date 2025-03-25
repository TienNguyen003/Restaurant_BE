package com.project.restaurantly.repository.restaurant;

import com.project.restaurantly.Entity.restaurant.Locations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationsRepository extends JpaRepository<Locations, Long> {
    @Query("SELECT r FROM Locations r WHERE" +
            "(:name IS NULL OR r.name LIKE %:name%) AND" +
            "(:status IS NULL OR r.status = :status)")
    Page<Locations> findByName
            (String name, Pageable pageable, int status);

    @Query("SELECT r FROM Locations r WHERE" +
            "(:status IS NULL OR r.status = :status)")
    List<Locations> findByStt
            (int status);
}
