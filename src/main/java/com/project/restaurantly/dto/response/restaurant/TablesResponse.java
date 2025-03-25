package com.project.restaurantly.dto.response.restaurant;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TablesResponse {
    long id;

    RoomsResponse rooms;

    int table_number;

    int seating_capacity;

    LocalDateTime create_at;

    LocalDateTime update_at;

    int status;
}
