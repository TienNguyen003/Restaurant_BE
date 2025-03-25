package com.project.restaurantly.dto.response.order;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrdersResponse {
    long id;

    String user_id;

    float total_amount;

    String state;

    LocalDateTime create_at;

    LocalDateTime update_at;

    int status;
}
