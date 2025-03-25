package com.project.restaurantly.Mapper.role;

import com.project.restaurantly.Entity.role.Role;
import com.project.restaurantly.dto.request.role.RoleRequest;
import com.project.restaurantly.dto.request.role.RoleUpdateRequest;
import com.project.restaurantly.dto.response.role.RoleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);

    @Mapping(target = "permissions", ignore = true)
    void updateRole(@MappingTarget Role role, RoleUpdateRequest request);
}
