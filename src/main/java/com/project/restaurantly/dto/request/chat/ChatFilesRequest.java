package com.project.restaurantly.dto.request.chat;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatFilesRequest {
    long chatId;

    String fileName;

    String fileUrl;

    String fileType;

    LocalDateTime uploadedAt;

    long uploadedBy;

    int chatType;

    int status = 1;
}
