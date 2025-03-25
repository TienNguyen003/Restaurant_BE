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
public class OrderTables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String user_id;

    float amount;

    String state;

    String special_requests;

    String order_type;

    int entity_id;

    int number_of_guests;

    LocalDateTime order_date;

    LocalDateTime reservation_time;

    LocalDateTime create_at;

    LocalDateTime update_at;

    int status;
}
