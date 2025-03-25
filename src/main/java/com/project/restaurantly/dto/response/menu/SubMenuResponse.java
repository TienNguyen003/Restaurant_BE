package com.project.restaurantly.dto.response.menu;

import com.project.restaurantly.Entity.menu.Menu;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubMenuResponse {
    long id;

    String name;

    int status;
}
