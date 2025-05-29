package com.project.restaurantly.Mapper.chat;

import com.project.restaurantly.Entity.chat.ChatMessages;
import com.project.restaurantly.dto.request.chat.ChatMessagesRequest;
import com.project.restaurantly.dto.response.chat.ChatMessagesResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class ChatMessagesMapperImpl implements ChatMessagesMapper {

    @Override
    public ChatMessages toChatMessages(ChatMessagesRequest request) {
        if ( request == null ) {
            return null;
        }

        ChatMessages.ChatMessagesBuilder chatMessages = ChatMessages.builder();

        chatMessages.chatId( request.getChatId() );
        chatMessages.senderId( request.getSenderId() );
        chatMessages.messageText( request.getMessageText() );
        chatMessages.sentAt( request.getSentAt() );
        chatMessages.updatedAt( request.getUpdatedAt() );
        chatMessages.chatType( request.getChatType() );
        chatMessages.status( request.getStatus() );

        return chatMessages.build();
    }

    @Override
    public ChatMessagesResponse toChatMessagesResponse(ChatMessages chat) {
        if ( chat == null ) {
            return null;
        }

        ChatMessagesResponse.ChatMessagesResponseBuilder chatMessagesResponse = ChatMessagesResponse.builder();

        chatMessagesResponse.id( chat.getId() );
        chatMessagesResponse.chatId( chat.getChatId() );
        chatMessagesResponse.senderId( chat.getSenderId() );
        chatMessagesResponse.messageText( chat.getMessageText() );
        chatMessagesResponse.sentAt( chat.getSentAt() );
        chatMessagesResponse.updatedAt( chat.getUpdatedAt() );
        chatMessagesResponse.chatType( chat.getChatType() );
        chatMessagesResponse.isRead( chat.getIsRead() );
        chatMessagesResponse.status( chat.getStatus() );

        return chatMessagesResponse.build();
    }

    @Override
    public void updateChatMessages(ChatMessages chat, ChatMessagesRequest request) {
        if ( request == null ) {
            return;
        }

        chat.setChatId( request.getChatId() );
        chat.setSenderId( request.getSenderId() );
        chat.setMessageText( request.getMessageText() );
        chat.setSentAt( request.getSentAt() );
        chat.setUpdatedAt( request.getUpdatedAt() );
        chat.setChatType( request.getChatType() );
        chat.setStatus( request.getStatus() );
    }
}
