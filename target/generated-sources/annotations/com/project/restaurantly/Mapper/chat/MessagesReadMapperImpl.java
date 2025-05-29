package com.project.restaurantly.Mapper.chat;

import com.project.restaurantly.Entity.chat.MessagesRead;
import com.project.restaurantly.dto.request.chat.MessagesReadRequest;
import com.project.restaurantly.dto.response.chat.MessagesReadResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class MessagesReadMapperImpl implements MessagesReadMapper {

    @Override
    public MessagesRead toMessagesRead(MessagesReadRequest request) {
        if ( request == null ) {
            return null;
        }

        MessagesRead.MessagesReadBuilder messagesRead = MessagesRead.builder();

        messagesRead.messageId( request.getMessageId() );
        messagesRead.chatId( request.getChatId() );
        messagesRead.chatType( request.getChatType() );
        messagesRead.userId( request.getUserId() );
        messagesRead.read_at( request.getRead_at() );
        messagesRead.isRead( request.getIsRead() );

        return messagesRead.build();
    }

    @Override
    public MessagesReadResponse toMessagesReadResponse(MessagesRead chat) {
        if ( chat == null ) {
            return null;
        }

        MessagesReadResponse.MessagesReadResponseBuilder messagesReadResponse = MessagesReadResponse.builder();

        messagesReadResponse.id( chat.getId() );
        messagesReadResponse.chatId( chat.getChatId() );
        messagesReadResponse.messageId( chat.getMessageId() );
        messagesReadResponse.chatType( chat.getChatType() );
        messagesReadResponse.userId( chat.getUserId() );
        messagesReadResponse.read_at( chat.getRead_at() );
        messagesReadResponse.isRead( chat.getIsRead() );

        return messagesReadResponse.build();
    }

    @Override
    public void updateMessagesRead(MessagesRead chat, MessagesReadRequest request) {
        if ( request == null ) {
            return;
        }

        chat.setMessageId( request.getMessageId() );
        chat.setChatId( request.getChatId() );
        chat.setChatType( request.getChatType() );
        chat.setUserId( request.getUserId() );
        chat.setRead_at( request.getRead_at() );
        chat.setIsRead( request.getIsRead() );
    }
}
