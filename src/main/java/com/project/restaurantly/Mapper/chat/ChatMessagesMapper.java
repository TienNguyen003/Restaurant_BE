package com.project.restaurantly.Mapper.chat;

import com.project.restaurantly.Entity.chat.ChatMessages;
import com.project.restaurantly.dto.request.chat.ChatMessagesRequest;
import com.project.restaurantly.dto.response.chat.ChatMessagesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ChatMessagesMapper {
    ChatMessages toChatMessages(ChatMessagesRequest request);

    ChatMessagesResponse toChatMessagesResponse(ChatMessages chat);

    void updateChatMessages(@MappingTarget ChatMessages chat, ChatMessagesRequest request);
}
