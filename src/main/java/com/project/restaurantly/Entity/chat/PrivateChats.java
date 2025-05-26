package com.project.restaurantly.Entity.chat;

import com.project.restaurantly.Entity.user.User;
import jakarta.persistence.*;
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

    @ManyToOne
    User userOneId;

    @ManyToOne
    User userTwoId;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

    boolean isPinned;

    int status;
}
