package com.project.restaurantly.Mapper.chat;

import com.project.restaurantly.Entity.chat.UserChatMeta;
import com.project.restaurantly.dto.request.chat.UserChatMetaRequest;
import com.project.restaurantly.dto.response.chat.UserChatMetaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserChatMetaMapper {
    UserChatMeta toUserChatMeta(UserChatMetaRequest request);

    UserChatMetaResponse toUserChatMetaResponse(UserChatMeta chat);

    void updateUserChatMeta(@MappingTarget UserChatMeta chat, UserChatMetaRequest request);
}
