package com.project.restaurantly.repository.order;

import com.project.restaurantly.Entity.order.ShopCart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopCartRepository extends JpaRepository<ShopCart, Long> {
    @Query("SELECT r FROM ShopCart r WHERE" +
            "(:id IS NULL OR r.user_id = :id) AND"+
            "(:status IS NULL OR r.status = :status)")
    Page<ShopCart> findByName
            (long id, Pageable pageable, int status);

    @Query("SELECT r FROM ShopCart r WHERE" +
            "(:status IS NULL OR r.status = :status)")
    List<ShopCart> findByStt
            (int status);

    @Query("SELECT r FROM ShopCart r WHERE" +
            "(:user_id IS NULL OR r.user_id = :user_id) AND"+
            "(:product_id IS NULL OR r.product.id = :product_id)")
    ShopCart findByUserIdAndProductId(long user_id, long product_id);

    @Query("SELECT count(r) FROM ShopCart r WHERE" +
            "(:user_id IS NULL OR r.user_id = :user_id) AND"+
            "(:status IS NULL OR r.status = :status)")
    int totalCartByUerId
            (long user_id, int status);
}
