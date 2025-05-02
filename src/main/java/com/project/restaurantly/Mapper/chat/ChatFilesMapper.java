package com.project.restaurantly.Mapper.chat;

import com.project.restaurantly.Entity.chat.ChatFiles;
import com.project.restaurantly.dto.request.chat.ChatFilesRequest;
import com.project.restaurantly.dto.response.chat.ChatFilesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ChatFilesMapper {
    ChatFiles toChatFiles(ChatFilesRequest request);

    ChatFilesResponse toChatFilesResponse(ChatFiles files);

    void updateChatFiles(@MappingTarget ChatFiles files, ChatFilesRequest request);
}
