package com.project.restaurantly.dto.response.settings;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class home_settingsResponse {
    long id;

    String section;

    String data;
}
