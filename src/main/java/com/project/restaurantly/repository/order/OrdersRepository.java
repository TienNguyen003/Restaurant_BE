package com.project.restaurantly.repository.order;

import com.project.restaurantly.Entity.order.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    @Query("SELECT r FROM Orders r WHERE" +
            "(:status IS NULL OR r.status = :status)")
    Page<Orders> findByName
            (Pageable pageable, int status);

    @Query("SELECT r FROM Orders r WHERE" +
            "(:id IS NULL OR r.id = :id)")
    List<Orders> findByStt
            (long id);
}
