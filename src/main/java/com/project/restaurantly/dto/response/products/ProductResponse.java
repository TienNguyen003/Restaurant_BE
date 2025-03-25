package com.project.restaurantly.dto.response.products;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {
    long id;

    String name;

    String thumbnail;

    String image;

    float price;

    float discount_price;

    int discount_percentage;

    String des;

    String category;

    int status;
}
