package com.project.restaurantly.repository.products;

import com.project.restaurantly.Entity.products.DiscountCodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountCodesRepository extends JpaRepository<DiscountCodes, Long> {

}
