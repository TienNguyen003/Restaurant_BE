package com.project.restaurantly.Mapper.chat;

import com.project.restaurantly.Entity.chat.GroupChats;
import com.project.restaurantly.Entity.menu.Menu;
import com.project.restaurantly.dto.request.chat.GroupChatsRequest;
import com.project.restaurantly.dto.request.menu.MenuRequest;
import com.project.restaurantly.dto.response.chat.GroupChatsResponse;
import com.project.restaurantly.dto.response.menu.MenuResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface GroupChatsMapper {
    GroupChats toGroupChats(GroupChatsRequest request);

    GroupChatsResponse toGroupChatsResponse(GroupChats chat);

    void updateGroupChats(@MappingTarget GroupChats chat, GroupChatsRequest request);
}
