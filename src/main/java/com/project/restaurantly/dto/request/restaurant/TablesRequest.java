package com.project.restaurantly.dto.request.restaurant;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TablesRequest {

    long rooms_id;

    int table_number;

    int seating_capacity;

    LocalDateTime create_at;

    LocalDateTime update_at;

    int status = 1;
}
