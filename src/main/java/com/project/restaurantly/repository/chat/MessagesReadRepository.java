package com.project.restaurantly.repository.chat;

import com.project.restaurantly.Entity.chat.MessagesRead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessagesReadRepository extends JpaRepository<MessagesRead, Long> {
    @Query("SELECT r FROM MessagesRead r WHERE" +
            "(:chatId IS NULL OR r.chatId = :chatId) AND" +
            "(:chatType IS NULL OR r.chatType = :chatType) AND" +
            "(:userId IS NULL OR r.userId = :userId)")
    List<MessagesRead> findByChatIdAndChatTypeAndUserId(long chatId, int chatType, String userId);
}
