package com.project.restaurantly.repository.chat;

import com.project.restaurantly.Entity.chat.ChatFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatFilesRepository extends JpaRepository<ChatFiles, Long> {
//    boolean existsByName(String name);
//
//    @Query("SELECT r FROM Menu r WHERE" +
//            "(:name IS NULL OR r.name LIKE %:name%) AND" +
//            "(:status IS NULL OR r.status = :status)")
//    Page<Menu> findByName
//            (String name, Pageable pageable, int status);
//
    @Query("SELECT r FROM ChatFiles r WHERE" +
            "(:status IS NULL OR r.status = :status)")
    List<ChatFiles> findByStt
            (int status);
}
