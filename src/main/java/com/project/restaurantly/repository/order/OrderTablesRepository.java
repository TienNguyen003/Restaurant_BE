package com.project.restaurantly.repository.order;

import com.project.restaurantly.Entity.order.OrderTables;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderTablesRepository extends JpaRepository<OrderTables, Long> {
    @Query("SELECT r FROM OrderTables r WHERE" +
            "(:status IS NULL OR r.status = :status)")
    Page<OrderTables> findByName
            (Pageable pageable, int status);

    @Query("SELECT r FROM OrderTables r WHERE" +
            "(:status IS NULL OR r.status = :status)")
    List<OrderTables> findByStt
            (int status);
}
