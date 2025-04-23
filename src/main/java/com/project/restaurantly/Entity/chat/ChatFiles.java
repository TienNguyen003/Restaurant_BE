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
public class ChatFiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    long chatId;

    String fileName;

    String fileUrl;

    String fileType;

    LocalDateTime uploadedAt;

    long uploadedBy;

    int chatType;

    int status;
}
