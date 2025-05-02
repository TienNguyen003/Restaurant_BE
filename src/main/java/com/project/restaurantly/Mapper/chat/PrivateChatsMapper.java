package com.project.restaurantly.Mapper.chat;

import com.project.restaurantly.Entity.chat.PrivateChats;
import com.project.restaurantly.dto.request.chat.PrivateChatsRequest;
import com.project.restaurantly.dto.response.chat.PrivateChatsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PrivateChatsMapper {
    @Mapping(target = "userOneId", ignore = true)
    @Mapping(target = "userTwoId", ignore = true)
    PrivateChats toPrivateChats(PrivateChatsRequest request);

    PrivateChatsResponse toPrivateChatsResponse(PrivateChats chat);

    @Mapping(target = "userOneId", ignore = true)
    @Mapping(target = "userTwoId", ignore = true)
    void updatePrivateChats(@MappingTarget PrivateChats chat, PrivateChatsRequest request);
}
