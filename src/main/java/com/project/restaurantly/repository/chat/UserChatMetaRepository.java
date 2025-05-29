package com.project.restaurantly.repository.chat;

import com.project.restaurantly.Entity.chat.UserChatMeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserChatMetaRepository extends JpaRepository<UserChatMeta, Long> {
    UserChatMeta findByChatIdAndUserId(long chatId, String userId);

//    @Query("SELECT r FROM Menu r WHERE" +
//            "(:name IS NULL OR r.name LIKE %:name%) AND" +
//            "(:status IS NULL OR r.status = :status)")
//    Page<Menu> findByName
//            (String name, Pageable pageable, int status);

    @Query("SELECT r FROM UserChatMeta r WHERE" +
            "(:userId IS NULL OR r.userId = :userId) AND" +
            "(:chatType IS NULL OR r.chatType = :chatType) AND" +
            "(:chatId IS NULL OR r.chatId = :chatId)")
    List<UserChatMeta> findByChatId
            (long chatId, String userId, int chatType);
}
