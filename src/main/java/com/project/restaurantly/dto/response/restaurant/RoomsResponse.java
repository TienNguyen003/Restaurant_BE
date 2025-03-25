package com.project.restaurantly.dto.response.restaurant;

import com.project.restaurantly.Entity.category.RoomCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomsResponse {
    long id;

    FloorsResponse floors;

    int room_number;

    String room_name;

    RoomCategory category;

    LocalDateTime create_at;

    LocalDateTime update_at;

    int status;
}
