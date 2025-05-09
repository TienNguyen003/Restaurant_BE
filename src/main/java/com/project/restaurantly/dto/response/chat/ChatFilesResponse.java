package com.project.restaurantly.dto.response.chat;

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
public class ChatFilesResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    long chatId;

    String fileName;

    String fileUrl;

    String fileType;

    LocalDateTime uploadedAt;

    String uploadedBy;

    int chatType;

    int status;
}
