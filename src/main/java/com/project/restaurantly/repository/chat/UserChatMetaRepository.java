package com.project.restaurantly.repository.chat;

import com.project.restaurantly.Entity.chat.UserChatMeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserChatMetaRepository extends JpaRepository<UserChatMeta, Long> {
//    boolean existsByName(String name);

//    @Query("SELECT r FROM Menu r WHERE" +
//            "(:name IS NULL OR r.name LIKE %:name%) AND" +
//            "(:status IS NULL OR r.status = :status)")
//    Page<Menu> findByName
//            (String name, Pageable pageable, int status);
}
