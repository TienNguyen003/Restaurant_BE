package com.project.restaurantly.dto.response.restaurant;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FloorsResponse {
    long id;

    String name;

    BranchesResponse branches;

    int floor_number;

    LocalDateTime create_at;

    LocalDateTime update_at;

    int status;
}
