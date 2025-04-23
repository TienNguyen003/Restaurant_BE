package com.project.restaurantly.dto.response.chat;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupChatsResponse {
    long id;

    String groupName;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

    int status;
}
