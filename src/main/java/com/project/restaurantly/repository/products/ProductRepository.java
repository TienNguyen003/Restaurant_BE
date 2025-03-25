package com.project.restaurantly.repository.products;

import com.project.restaurantly.Entity.products.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT r FROM Product r WHERE" +
            "(:status IS NULL OR r.status = :status)")
    Page<Product> findByName
            (Pageable pageable, int status);
}
