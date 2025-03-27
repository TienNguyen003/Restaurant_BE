package com.project.restaurantly.dto.request.products;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewRequest {
    String user_id;

    long product_id;

    int parent_review_id;

    int rating;

    String comment;

    LocalDateTime created_at;

    int status = 1;
}
