package com.project.restaurantly.dto.response.menu;

import com.project.restaurantly.Entity.menu.Submenu;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MenuResponse {
    long id;

    String name;

    int status;

    List<Submenu> listSub;
}
