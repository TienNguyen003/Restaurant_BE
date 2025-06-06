package com.project.restaurantly.dto.request.chat;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatMessagesRequest {
    long chatId;

    String senderId;

    String messageText;

    LocalDateTime sentAt;

    LocalDateTime updatedAt;

    int chatType;

    int type;

    int isForward;

    long receiver_id;

    int status = 1;
}
