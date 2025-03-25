package com.project.restaurantly.repository.order;

import com.project.restaurantly.Entity.order.Favorites;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, Long> {
    @Query("SELECT r FROM Favorites r WHERE" +
            "(:status IS NULL OR r.status = :status)")
    Page<Favorites> findByName
            (Pageable pageable, int status);

    @Query("SELECT r FROM Favorites r WHERE" +
            "(:status IS NULL OR r.status = :status)")
    List<Favorites> findByStt
            (int status);
}
