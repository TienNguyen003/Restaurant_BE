package com.project.restaurantly.dto.response.order;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderTablesResponse {
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
