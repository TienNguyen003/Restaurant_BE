package com.project.restaurantly.dto.response.chat;

import com.project.restaurantly.Entity.user.User;
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

    User userOneId;

    User userTwoId;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

    int status;
}
