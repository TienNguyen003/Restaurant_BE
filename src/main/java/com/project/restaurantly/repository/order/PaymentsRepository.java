package com.project.restaurantly.repository.order;

import com.project.restaurantly.Entity.order.Orders;
import com.project.restaurantly.Entity.order.Payments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Long> {
    @Query("SELECT r FROM Payments r WHERE" +
            "(:status IS NULL OR r.status = :status)")
    Page<Payments> findByName
            (Pageable pageable, int status);

    @Query("SELECT r FROM Payments r WHERE" +
            "(:status IS NULL OR r.status = :status)")
    List<Payments> findByStt
            (int status);
}
