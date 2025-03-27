package com.project.restaurantly.dto.request.products;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {
    String name;

    String thumbnail;

    String image;

    float price;

    float discount_price;

    int discount_percentage;

    int quantity;

    String detail_des;

    String info;

    String des;

    String category;

    int status = 1;
}
