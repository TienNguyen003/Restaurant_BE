package com.project.restaurantly.repository.chat;

import com.project.restaurantly.Entity.chat.ChatMessages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessagesRepository extends JpaRepository<ChatMessages, Long> {
//    boolean existsByName(String name);

    @Query("SELECT r FROM ChatMessages r WHERE" +
            "(:chatId IS NULL OR r.chatId = :chatId) AND" +
            "(:status IS NULL OR r.status = :status)")
    List<ChatMessages> findBySenderId
            (String status, long chatId);

    @Query("SELECT r FROM ChatMessages r WHERE" +
            "(:status IS NULL OR r.status = :status)")
    List<ChatMessages> findByStt
            (int status);

    @Query("SELECT count(r) FROM ChatMessages r WHERE" +
            "(:chatId IS NULL OR r.chatId = :chatId) AND" +
            "(:isPined IS NULL OR r.isPined = :isPined) AND" +
            "(:status IS NULL OR r.status = :status)")
    int countMessageIsPin
            (long chatId, int status, int isPined);
}
