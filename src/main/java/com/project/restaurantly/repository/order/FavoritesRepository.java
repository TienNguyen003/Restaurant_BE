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
            "(:user_id IS NULL OR r.user_id = :user_id) AND"+
            "(:status IS NULL OR r.status = :status)")
    Page<Favorites> findByUserId
            (Pageable pageable, int status, long user_id);

    @Query("SELECT r FROM Favorites r WHERE" +
            "(:status IS NULL OR r.status = :status)")
    List<Favorites> findByStt
            (int status);

    @Query("SELECT r FROM Favorites r WHERE" +
            "(:user_id IS NULL OR r.user_id = :user_id) AND"+
            "(:product_id IS NULL OR r.product.id = :product_id)")
    Favorites findByUserIdAndProductId(long user_id, long product_id);
}
