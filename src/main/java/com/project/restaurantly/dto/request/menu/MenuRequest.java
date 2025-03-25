package com.project.restaurantly.dto.request.menu;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MenuRequest {
    @NotBlank(message = "Tên mục không được để trống")
    String name;

    int status = 1;

    List<Long> listIdSub;
}
