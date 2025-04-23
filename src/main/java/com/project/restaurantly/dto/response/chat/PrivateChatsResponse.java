package com.project.restaurantly.dto.response.chat;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PrivateChatsResponse {
    long id;

    long userOneId;

    long userTwoId;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

    int status;
}
