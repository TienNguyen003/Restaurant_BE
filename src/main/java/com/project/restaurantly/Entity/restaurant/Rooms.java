package com.project.restaurantly.Entity.restaurant;

import com.project.restaurantly.Entity.category.RoomCategory;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    Floors floors;

    int room_number;

    String room_name;

    @OneToOne
    RoomCategory category;

    LocalDateTime create_at;

    LocalDateTime update_at;

    int status;
}
