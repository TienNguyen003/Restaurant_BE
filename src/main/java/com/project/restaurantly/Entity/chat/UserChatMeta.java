package com.project.restaurantly.Entity.chat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserChatMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String userId;

    long chatId;

    LocalDateTime lastSeenAt;

    LocalDateTime leftAt;

    LocalDateTime deletedAt;

    LocalDateTime lastTimeMessage;

    int unreadCount;

    int chatType;

    // 0 not muted, 1 muted
    int isMuted;
}
