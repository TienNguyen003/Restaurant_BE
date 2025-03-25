package com.project.restaurantly.dto.response.restaurant;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BranchesResponse {
    long id;

    LocationsResponse locations;

    String branch_name;

    String address;

    LocalDateTime create_at;

    LocalDateTime update_at;

    int status;
}
