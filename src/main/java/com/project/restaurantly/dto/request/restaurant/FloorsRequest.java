package com.project.restaurantly.dto.request.restaurant;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FloorsRequest {

    String name;

    long branches_id;

    int floor_number;

    LocalDateTime create_at;

    LocalDateTime update_at;

    int status = 1;
}
