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
public class ShopCartResponse {
    long id;

    long user_id;

    Product product;

    int quantity;

    LocalDateTime create_at;

    int status;
}
