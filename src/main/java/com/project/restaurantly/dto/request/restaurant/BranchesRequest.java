package com.project.restaurantly.dto.request.restaurant;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BranchesRequest {

    long locations_id;

    String branch_name;

    String address;

    LocalDateTime create_at;

    LocalDateTime update_at;

    int status = 1;
}
