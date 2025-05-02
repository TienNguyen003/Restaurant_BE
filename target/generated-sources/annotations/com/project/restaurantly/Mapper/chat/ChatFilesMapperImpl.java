package com.project.restaurantly.Mapper.chat;

import com.project.restaurantly.Entity.chat.ChatFiles;
import com.project.restaurantly.dto.request.chat.ChatFilesRequest;
import com.project.restaurantly.dto.response.chat.ChatFilesResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class ChatFilesMapperImpl implements ChatFilesMapper {

    @Override
    public ChatFiles toChatFiles(ChatFilesRequest request) {
        if ( request == null ) {
            return null;
        }

        ChatFiles.ChatFilesBuilder chatFiles = ChatFiles.builder();

        chatFiles.chatId( request.getChatId() );
        chatFiles.fileName( request.getFileName() );
        chatFiles.fileUrl( request.getFileUrl() );
        chatFiles.fileType( request.getFileType() );
        chatFiles.uploadedAt( request.getUploadedAt() );
        chatFiles.uploadedBy( request.getUploadedBy() );
        chatFiles.chatType( request.getChatType() );
        chatFiles.status( request.getStatus() );

        return chatFiles.build();
    }

    @Override
    public ChatFilesResponse toChatFilesResponse(ChatFiles files) {
        if ( files == null ) {
            return null;
        }

        ChatFilesResponse.ChatFilesResponseBuilder chatFilesResponse = ChatFilesResponse.builder();

        chatFilesResponse.id( files.getId() );
        chatFilesResponse.chatId( files.getChatId() );
        chatFilesResponse.fileName( files.getFileName() );
        chatFilesResponse.fileUrl( files.getFileUrl() );
        chatFilesResponse.fileType( files.getFileType() );
        chatFilesResponse.uploadedAt( files.getUploadedAt() );
        chatFilesResponse.uploadedBy( files.getUploadedBy() );
        chatFilesResponse.chatType( files.getChatType() );
        chatFilesResponse.status( files.getStatus() );

        return chatFilesResponse.build();
    }

    @Override
    public void updateChatFiles(ChatFiles files, ChatFilesRequest request) {
        if ( request == null ) {
            return;
        }

        files.setChatId( request.getChatId() );
        files.setFileName( request.getFileName() );
        files.setFileUrl( request.getFileUrl() );
        files.setFileType( request.getFileType() );
        files.setUploadedAt( request.getUploadedAt() );
        files.setUploadedBy( request.getUploadedBy() );
        files.setChatType( request.getChatType() );
        files.setStatus( request.getStatus() );
    }
}
