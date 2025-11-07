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
public class ChatMessages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    long chatId;

    String senderId;

    String messageText;

    LocalDateTime sentAt;

    LocalDateTime updatedAt;

    // 0 is private chat, 1 is group chat
    int chatType;

    // 0 is text, 1 is image/gif, 2 is links
    int type;

    // 1 is reply, 2 is forward
    int isForward;

    // id tin nhan goc
    long receiver_id;

    // 0 is not pin, 1 is pin
    int isPined;

    int status;
}
