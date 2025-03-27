package com.project.restaurantly.repository.products;

import com.project.restaurantly.Entity.products.ReviewProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewProduct, Long> {
    @Query("SELECT r FROM ReviewProduct r WHERE" +
            "(:product_id IS NULL OR r.product.id = :product_id) AND" +
            "(:status IS NULL OR r.status = :status)"+
            "ORDER BY r.created_at DESC")
    Page<ReviewProduct> findByProductId(Pageable pageable, int status, long product_id);

    @Query("SELECT SUM(r.rating), COUNT(r) FROM ReviewProduct r WHERE" +
            "(:product_id IS NULL OR r.product.id = :product_id) AND" +
            "(:status IS NULL OR r.status = :status)")
    Object[] findRatingSumAndCountByProductId(long product_id, int status);
}
