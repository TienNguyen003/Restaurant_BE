package com.project.restaurantly.Entity.settings;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Home_settings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String section;

    String data;

    String beLong;
}
