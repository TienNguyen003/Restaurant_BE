package com.project.restaurantly.Mapper.user;

import com.project.restaurantly.Entity.user.User;
import com.project.restaurantly.dto.request.user.user.UserCreationRequest;
import com.project.restaurantly.dto.request.user.user.UserUpdateRequest;
import com.project.restaurantly.dto.response.user.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    @Mapping(target = "role", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
