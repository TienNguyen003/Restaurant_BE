package com.project.restaurantly.repository.menu;

import com.project.restaurantly.Entity.menu.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    boolean existsByName(String name);

    @Query("SELECT r FROM Menu r WHERE" +
            "(:name IS NULL OR r.name LIKE %:name%) AND" +
            "(:status IS NULL OR r.status = :status)")
    Page<Menu> findByName
            (String name, Pageable pageable, int status);

    @Query("SELECT r FROM Menu r WHERE" +
            "(:status IS NULL OR r.status = :status)")
    List<Menu> findByStt
            (int status);
}
