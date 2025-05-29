package com.project.restaurantly.Entity.chat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessagesRead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    long messageId;

    long chatId;

    int chatType;

    String userId;

    LocalDateTime read_at;

    // 0 is send, 1 is received, 2 is seen
    int isRead;
}
