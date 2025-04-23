package com.project.restaurantly.dto.response.chat;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatMessagesResponse {
    long id;

    long chatId;

    long senderId;

    String messageText;

    LocalDateTime sentAt;

    LocalDateTime updatedAt;

    int chatType;

    int status;
}
