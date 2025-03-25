package com.project.restaurantly.repository.settings;

import com.project.restaurantly.Entity.settings.Home_settings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeSettingRepository extends JpaRepository<Home_settings, Long> {
    @Query("SELECT u FROM Home_settings u WHERE u.beLong = :section")
    List<Home_settings> findBySection(String section);
}
