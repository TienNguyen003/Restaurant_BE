package com.project.restaurantly.repository.chat;

import com.project.restaurantly.Entity.chat.GroupChats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupChatsRepository extends JpaRepository<GroupChats, Long> {
//    boolean existsByName(String name);
//
//    @Query("SELECT r FROM Menu r WHERE" +
//            "(:name IS NULL OR r.name LIKE %:name%) AND" +
//            "(:status IS NULL OR r.status = :status)")
//    Page<Menu> findByName
//            (String name, Pageable pageable, int status);
//
    @Query("SELECT r FROM GroupChats r WHERE" +
            "(:status IS NULL OR r.status = :status)")
    List<GroupChats> findByStt
            (int status);
}
