package com.project.restaurantly.dto.request.order;

import com.project.restaurantly.Entity.products.Product;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderItemsRequest {

    long orders_id;

    long ordersTables_id;

    Product product;

    int quantity;

    LocalDateTime create_at = LocalDateTime.now();

    int status = 1;
}
