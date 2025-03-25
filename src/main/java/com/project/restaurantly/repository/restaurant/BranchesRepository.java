package com.project.restaurantly.repository.restaurant;

import com.project.restaurantly.Entity.restaurant.Branches;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchesRepository extends JpaRepository<Branches, Long> {
    @Query("SELECT r FROM Branches r WHERE" +
            "(:status IS NULL OR r.status = :status)")
    Page<Branches> findByName
            (Pageable pageable, int status);

    @Query("SELECT r FROM Branches r WHERE" +
            "(:status IS NULL OR r.status = :status)")
    List<Branches> findByStt
            (int status);
}
