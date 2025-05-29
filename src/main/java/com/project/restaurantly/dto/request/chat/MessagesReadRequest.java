package com.project.restaurantly.dto.request.chat;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessagesReadRequest {
    long chatId;

    long messageId;

    int chatType;

    String userId;

    LocalDateTime read_at;

    // 0 is send, 1 is received, 2 is seen
    int isRead;
}
