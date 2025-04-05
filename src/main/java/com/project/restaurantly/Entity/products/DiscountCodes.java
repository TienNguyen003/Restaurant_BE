package com.project.restaurantly.Entity.products;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscountCodes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
