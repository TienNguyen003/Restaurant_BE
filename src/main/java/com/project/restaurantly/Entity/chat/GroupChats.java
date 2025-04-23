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
public class GroupChats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String groupName;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

    int status;
}
