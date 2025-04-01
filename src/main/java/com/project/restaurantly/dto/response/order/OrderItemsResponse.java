package com.project.restaurantly.dto.response.order;

import com.project.restaurantly.Entity.products.Product;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderItemsResponse {
    long id;

    long orders_id;

    long ordersTables_id;

    Product product;

    int quantity;

    LocalDateTime create_at;

    int status;
}
