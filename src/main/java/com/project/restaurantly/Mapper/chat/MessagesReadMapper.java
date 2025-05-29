package com.project.restaurantly.Mapper.chat;

import com.project.restaurantly.Entity.chat.MessagesRead;
import com.project.restaurantly.dto.request.chat.MessagesReadRequest;
import com.project.restaurantly.dto.response.chat.MessagesReadResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MessagesReadMapper {
    MessagesRead toMessagesRead(MessagesReadRequest request);

    MessagesReadResponse toMessagesReadResponse(MessagesRead chat);

    void updateMessagesRead(@MappingTarget MessagesRead chat, MessagesReadRequest request);
}
