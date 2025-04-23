package com.project.restaurantly.dto.request.chat;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserChatMetaRequest {
    long userId;

    long chatId;

    LocalDateTime lastSeenAt;

    LocalDateTime leftAt;

    LocalDateTime deletedAt;

    int chatType;

    boolean isMuted;
}
