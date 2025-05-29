package com.project.restaurantly.dto.response.chat;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserChatMetaResponse {
    long id;

    String userId;

    long chatId;

    LocalDateTime lastSeenAt;

    LocalDateTime leftAt;

    LocalDateTime deletedAt;

    LocalDateTime lastTimeMessage;

    int unreadCount;

    int chatType;

    int isMuted;
}
