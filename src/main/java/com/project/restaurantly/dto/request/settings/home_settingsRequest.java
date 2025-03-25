package com.project.restaurantly.dto.request.settings;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class home_settingsRequest {
    @NotBlank(message = "Tên phần không được để trống")
    String section;

    @NotBlank(message = "Dữ liệu không được để trống")
    String data;
}
