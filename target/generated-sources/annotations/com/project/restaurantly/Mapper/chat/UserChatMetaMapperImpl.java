package com.project.restaurantly.Mapper.chat;

import com.project.restaurantly.Entity.chat.UserChatMeta;
import com.project.restaurantly.dto.request.chat.UserChatMetaRequest;
import com.project.restaurantly.dto.response.chat.UserChatMetaResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class UserChatMetaMapperImpl implements UserChatMetaMapper {

    @Override
    public UserChatMeta toUserChatMeta(UserChatMetaRequest request) {
        if ( request == null ) {
            return null;
        }

        UserChatMeta.UserChatMetaBuilder userChatMeta = UserChatMeta.builder();

        userChatMeta.userId( request.getUserId() );
        userChatMeta.chatId( request.getChatId() );
        userChatMeta.lastSeenAt( request.getLastSeenAt() );
        userChatMeta.leftAt( request.getLeftAt() );
        userChatMeta.deletedAt( request.getDeletedAt() );
        userChatMeta.chatType( request.getChatType() );

        return userChatMeta.build();
    }

    @Override
    public UserChatMetaResponse toUserChatMetaResponse(UserChatMeta chat) {
        if ( chat == null ) {
            return null;
        }

        UserChatMetaResponse.UserChatMetaResponseBuilder userChatMetaResponse = UserChatMetaResponse.builder();

        userChatMetaResponse.id( chat.getId() );
        userChatMetaResponse.userId( chat.getUserId() );
        userChatMetaResponse.chatId( chat.getChatId() );
        userChatMetaResponse.lastSeenAt( chat.getLastSeenAt() );
        userChatMetaResponse.leftAt( chat.getLeftAt() );
        userChatMetaResponse.deletedAt( chat.getDeletedAt() );
        userChatMetaResponse.chatType( chat.getChatType() );

        return userChatMetaResponse.build();
    }

    @Override
    public void updateUserChatMeta(UserChatMeta chat, UserChatMetaRequest request) {
        if ( request == null ) {
            return;
        }

        chat.setUserId( request.getUserId() );
        chat.setChatId( request.getChatId() );
        chat.setLastSeenAt( request.getLastSeenAt() );
        chat.setLeftAt( request.getLeftAt() );
        chat.setDeletedAt( request.getDeletedAt() );
        chat.setChatType( request.getChatType() );
        chat.setMuted( request.isMuted() );
    }
}
