package com.project.restaurantly.repository.restaurant;

import com.project.restaurantly.Entity.restaurant.Tables;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TablesRepository extends JpaRepository<Tables, Long> {
    @Query("SELECT r FROM Tables r WHERE" +
            "(:status IS NULL OR r.status = :status)")
    Page<Tables> findByName
            (Pageable pageable, int status);

    @Query("SELECT r FROM Tables r WHERE" +
            "(:status IS NULL OR r.status = :status)")
    List<Tables> findByStt
            (int status);
}
