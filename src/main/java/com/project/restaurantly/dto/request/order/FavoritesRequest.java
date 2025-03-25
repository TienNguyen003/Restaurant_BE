package com.project.restaurantly.dto.request.order;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FavoritesRequest {
    long id;

    String user_id;

    long product_id;

    LocalDateTime create_at;

    int status = 1;
}
