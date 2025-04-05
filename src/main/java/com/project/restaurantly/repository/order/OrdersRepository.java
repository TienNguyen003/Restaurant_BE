package com.project.restaurantly.repository.order;

import com.project.restaurantly.Entity.order.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    @Query("SELECT r FROM Orders r WHERE" +
            "(:user_id IS NULL OR r.user_id = :user_id) AND"+
            "(:status IS NULL OR r.status = :status)")
    Page<Orders> findByName
            (Pageable pageable, String user_id, int status);
}
