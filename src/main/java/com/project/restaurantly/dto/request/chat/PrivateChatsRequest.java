package com.project.restaurantly.dto.request.chat;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PrivateChatsRequest {
    String userOneId;

    String userTwoId;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

    int isPinned = 0;

    int status = 1;
}
