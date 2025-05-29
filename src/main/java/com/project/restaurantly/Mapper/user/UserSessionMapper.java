package com.project.restaurantly.Mapper.user;

import com.project.restaurantly.Entity.user.UserSession;
import com.project.restaurantly.dto.request.user.UserSessionRequest;
import com.project.restaurantly.dto.response.user.UserSessionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserSessionMapper {
    UserSession toUserSession(UserSessionRequest request);

    UserSessionResponse toUserSessionResponse(UserSession user);

    void updateUserSession(@MappingTarget UserSession user, UserSessionRequest request);
}
