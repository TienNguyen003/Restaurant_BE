package com.project.restaurantly.dto.response.products;

import com.project.restaurantly.Entity.products.Product;
import com.project.restaurantly.Entity.user.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewResponse {
    long id;

    User user;

    Product product;

    int parent_review_id;

    int rating;

    String comment;

    LocalDateTime created_at;

    int status;
}
