package com.project.restaurantly.Entity.order;

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
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String user_id;

    float total_amount;

    float fee;

    String phone_number;

    String name;

    String address;

    String state;

    LocalDateTime create_at;

    LocalDateTime update_at;

    int status;
}
