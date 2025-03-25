package com.project.restaurantly.Mapper.role;

import com.project.restaurantly.Entity.role.Permission;
import com.project.restaurantly.dto.request.role.PermissionRequest;
import com.project.restaurantly.dto.response.role.PermissionResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest permissionRequest);

    PermissionResponse toPermissionResponse(Permission permission);
}
