package com.project.restaurantly.dto.response.user;

import com.project.restaurantly.Entity.user.Employee;
import com.project.restaurantly.dto.response.role.RoleResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse  {
    String id;

    String username;

    Employee employee;

    RoleResponse role;

    String urlImage;

    int status;
}
