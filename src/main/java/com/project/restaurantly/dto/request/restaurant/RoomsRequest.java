package com.project.restaurantly.dto.request.restaurant;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomsRequest {

    long floors_id;

    int room_number;

    String room_name;

    long category_id;

    LocalDateTime create_at;

    LocalDateTime update_at;

    int status = 1;
}
