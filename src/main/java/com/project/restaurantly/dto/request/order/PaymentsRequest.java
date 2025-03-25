package com.project.restaurantly.dto.request.order;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentsRequest {

    long orders_id;

    long ordersTables_id;

    String payment_method;

    String payment_status;

    LocalDateTime create_at;

    int status = 1;
}
