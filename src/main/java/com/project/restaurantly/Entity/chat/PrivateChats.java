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
public class PrivateChats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    long userOneId;

    long userTwoId;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

    int status;
}
