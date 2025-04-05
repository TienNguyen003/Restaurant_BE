package com.project.restaurantly.dto.response.products;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscountCodesResponse {
    long id;

    String title;

    String code;

    int discount_value;

    String discount_type;

    String discount_category;

    LocalDateTime start_date;

    LocalDateTime end_date;

    int is_active;

    int usage_limit;

    int used_count;

    int min_price;

    String description;
}
