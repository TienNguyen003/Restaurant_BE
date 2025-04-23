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
    long userOneId;

    long userTwoId;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

    int status = 1;
}
