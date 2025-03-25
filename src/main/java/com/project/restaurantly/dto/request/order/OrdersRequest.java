package com.project.restaurantly.dto.request.order;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrdersRequest {

    String user_id;

    float total_amount;

    String state;

    LocalDateTime create_at;

    LocalDateTime update_at;

    int status = 1;
}
