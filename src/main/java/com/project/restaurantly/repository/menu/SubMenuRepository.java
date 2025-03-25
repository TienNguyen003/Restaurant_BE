package com.project.restaurantly.repository.menu;

import com.project.restaurantly.Entity.menu.Submenu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubMenuRepository extends JpaRepository<Submenu, Long> {
    boolean existsByName(String name);

    @Query("SELECT r FROM Submenu r WHERE" +
            "(:name IS NULL OR r.name LIKE %:name%)")
    Page<Submenu> findByName
            (String name, Pageable pageable);
}
