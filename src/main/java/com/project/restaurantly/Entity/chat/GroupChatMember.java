package com.project.restaurantly.Entity.chat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupChatMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    long userId;

    long groupChatId;
}
