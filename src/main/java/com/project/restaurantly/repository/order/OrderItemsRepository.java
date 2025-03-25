package com.project.restaurantly.repository.order;

import com.project.restaurantly.Entity.order.OrderItems;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {
    @Query("SELECT r FROM OrderItems r WHERE" +
            "(:status IS NULL OR r.status = :status)")
    Page<OrderItems> findByName
            (Pageable pageable, int status);

    @Query("SELECT r FROM OrderItems r WHERE" +
            "(:status IS NULL OR r.status = :status)")
    List<OrderItems> findByStt
            (int status);
}
