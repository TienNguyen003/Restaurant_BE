package com.project.restaurantly.dto.response.order;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentsResponse {
    long id;

    OrdersResponse orders;

    OrderTablesResponse ordersTables;

    String payment_method;

    String payment_status;

    LocalDateTime create_at;

    int status;
}
